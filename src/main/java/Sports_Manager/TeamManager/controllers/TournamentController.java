package Sports_Manager.TeamManager.controllers;

import Sports_Manager.TeamManager.DTOs.TournamentDTO;
import Sports_Manager.TeamManager.models.Match;
import Sports_Manager.TeamManager.service.TournamentService;
import com.sun.net.httpserver.HttpsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api.V1/tournaments")
public class TournamentController {
    private TournamentService ts;
    @Autowired
    public TournamentController(TournamentService t){
        ts=t;
    }
    @GetMapping(path = "/all")
    public ResponseEntity<List<TournamentDTO>> getAllTournaments(){
        return new ResponseEntity<>(ts.getAllTournaments(), HttpStatus.FOUND);
    }
    @GetMapping(path = "/find")
    public ResponseEntity<TournamentDTO> getByName(@RequestParam("name") String name){
        return new ResponseEntity<>(ts.getByName(name),HttpStatus.FOUND);
    }
    @PostMapping(path = "/create")
    public ResponseEntity<Void> createTournament(@RequestBody TournamentDTO tdto){
        ts.createTournament(tdto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping(path = "/update")
    public ResponseEntity<TournamentDTO> updateTournament(@RequestBody TournamentDTO tdto){
        return new ResponseEntity<>(ts.updateTournament(tdto),HttpStatus.FOUND);
    }
    @DeleteMapping(path = "/delete")
    public ResponseEntity<Void> deleteTournament(@RequestParam("name") String name){
        ts.deleteTournament(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(path = "/update/add")
    public ResponseEntity<Void> addMatch(@RequestBody Map<String,Long> input){
        ts.addMatch(input.get("id_tournament"),input.get("id_match"));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(path = "/update/remove")
    public ResponseEntity<Void> removeMatch(@RequestBody Map<String,Long> input){
        ts.removeMatch(input.get("id_tournament"),input.get("id_match"));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
