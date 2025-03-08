package Sports_Manager.TeamManager.controllers;

import Sports_Manager.TeamManager.DTOs.PlayerDTO;
import Sports_Manager.TeamManager.mappers.PlayerMapper;
import Sports_Manager.TeamManager.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api.V1/players")
public class PlayerController {
    private PlayerService ps;
    private PlayerMapper pmpr;
    @Autowired
    public PlayerController(PlayerService service, PlayerMapper mapper){
        ps = service;
        pmpr = mapper;

    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<PlayerDTO>> getAllPlayers(){
        return new ResponseEntity<>(ps.getAllPlayers(), HttpStatus.ACCEPTED);
    }
    @PostMapping(path="/create")
    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody PlayerDTO pdto){
        return new ResponseEntity<>(pmpr.map2DTO(ps.createPlayer(pdto)),HttpStatus.CREATED);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<PlayerDTO> getPlayerByID(@PathVariable Long id){
        return new ResponseEntity<>(ps.getPlayerById(id),HttpStatus.FOUND);
    }
    @GetMapping(path="/{name}")
    public ResponseEntity<PlayerDTO> getPlayerByName(@PathVariable String name){
        return new ResponseEntity<>(ps.getPlayerByName(name),HttpStatus.FOUND);
    }
    @GetMapping(path="/ofTeam/{id}")
    public ResponseEntity<List<PlayerDTO>> getPlayersByTeamID(@PathVariable Long id){
        return new ResponseEntity<>(ps.getPlayersByTeamID(id),HttpStatus.FOUND);
    }
    @PutMapping(path = "/update")
    public ResponseEntity<Void> updatePlayer(@RequestBody PlayerDTO dto){
        ps.updatePlayer(dto);
        return new ResponseEntity<>(HttpStatus.FOUND);
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id){
        ps.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
