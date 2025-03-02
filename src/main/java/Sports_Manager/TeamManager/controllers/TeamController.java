package Sports_Manager.TeamManager.controllers;

import Sports_Manager.TeamManager.DTOs.TeamDTO;
import Sports_Manager.TeamManager.mappers.TeamMapper;
import Sports_Manager.TeamManager.models.Team;
import Sports_Manager.TeamManager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api.V1/teams")
public class TeamController {
    private TeamService ts;
    private TeamMapper tmapr;

    @Autowired
    public TeamController(TeamService t, TeamMapper m){
        ts =t;
        tmapr=m;
    }
    @GetMapping(path = "/All")
    public ResponseEntity<List<TeamDTO>> getAllTeams(){
        return new ResponseEntity<>(ts.getAllTeams(), HttpStatus.FOUND);
    }
    @GetMapping(path="/{id}")
    public ResponseEntity<TeamDTO> getTeamByID(@PathVariable Long id){
        return  new ResponseEntity<>(ts.getTeamByID(id),HttpStatus.FOUND);
    }
    @GetMapping(path = "/{name}")
    public ResponseEntity<TeamDTO> getTeamByName(@PathVariable String name){
        return new ResponseEntity<>(ts.getTeamByName(name),HttpStatus.FOUND);
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
    @DeleteMapping(path = "/delete")
    public ResponseEntity<Void> deleteTeam(@RequestParam Long id){
        ts.deleteTeamByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(path = "/update/addPlayer")
    public ResponseEntity<Void> addPlayer(@RequestBody Map<String,Long> rqbody){
        ts.addPlayerToTeam(rqbody.get("player_id"),rqbody.get("team_id"));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(path = "/update/removePlayer")
    public ResponseEntity<Void> removePlayer(@RequestBody Map<String,Long> rqbody) {
        ts.removePlayerFromTeam(rqbody.get("player_id"),rqbody.get("team_id"));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
