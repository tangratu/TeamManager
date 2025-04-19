package Sports_Manager.TeamManager.controllers;

import Sports_Manager.TeamManager.DTOs.PlayerDTO;
import Sports_Manager.TeamManager.DTOs.TeamDTO;
import Sports_Manager.TeamManager.mappers.PlayerMapper;
import Sports_Manager.TeamManager.mappers.TeamMapper;
import Sports_Manager.TeamManager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api.V1/teams")
public class TeamController {
    private TeamService ts;
    private TeamMapper tmapr;
    private PlayerMapper pmapr;

    @Autowired
    public TeamController(TeamService t, TeamMapper m, PlayerMapper p){
        ts =t;
        tmapr=m;
        pmapr =p;
    }
    @GetMapping(path = "/All")
    public ResponseEntity<List<TeamDTO>> getAllTeams(){
        return new ResponseEntity<>(ts.getAllTeams(), HttpStatus.OK);
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<TeamDTO> getTeamByName(@PathVariable String name){
        return new ResponseEntity<>(ts.getTeamByName(name),HttpStatus.OK);
    }
    @PostMapping(path = "/create")
    public ResponseEntity<Void> createTeam(@RequestBody TeamDTO dto){
        ts.createTeam(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping(path = "/update")
    public ResponseEntity<Void> updateTeam(@RequestBody TeamDTO dto){
        ts.updateTeam(dto);
        return new ResponseEntity<>(HttpStatus.FOUND);

    }
    @GetMapping(path="/getPlayers/{name}")
    public ResponseEntity<List<PlayerDTO>> getPlayers(@PathVariable String name){
        return new ResponseEntity<>(ts.getPlayerList(name).stream().map(player -> pmapr.map2DTO(player)).collect(Collectors.toUnmodifiableList()), HttpStatus.OK);
    }
    @DeleteMapping(path = "/delete")
    public ResponseEntity<Void> deleteTeam(@RequestParam Long id){
        ts.deleteTeamByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(path = "/update/addPlayer")
    public ResponseEntity<Void> addPlayer(@RequestBody Map<String,String> rqbody){
        ts.addPlayerToTeam(rqbody.get("uname"),rqbody.get("teamName"));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(path = "/update/removePlayer")
    public ResponseEntity<Void> removePlayer(@RequestBody Map<String,Long> rqbody) {
        ts.removePlayerFromTeam(rqbody.get("player_id"),rqbody.get("team_id"));

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(path="/{name}/manager")
    public ResponseEntity<PlayerDTO> getManager(@PathVariable String name){
        return new ResponseEntity<>(pmapr.map2DTO(ts.getManager(name)),HttpStatus.OK);
    }





}
