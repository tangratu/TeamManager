package Sports_Manager.TeamManager.controllers;

import Sports_Manager.TeamManager.DTOs.MatchDTO;
import Sports_Manager.TeamManager.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api.V1/matches")
public class MatchController {
    private MatchService ms;

    @Autowired
    public MatchController( MatchService s){
        ms =s;

    }
    @GetMapping(path = "/all")
    public ResponseEntity<List<MatchDTO>> getAllMatches(){
        return new ResponseEntity<>(ms.getAllMatches(), HttpStatus.FOUND);
    }
    @GetMapping(path = "/find")
    public ResponseEntity<MatchDTO> getMatchByID(@RequestParam("id") Long id){
        return new ResponseEntity<>(ms.getMatchByID(id),HttpStatus.FOUND);
    }
    @GetMapping(path="/info")
    public ResponseEntity<MatchDTO> getMatchByDesig(@RequestParam("desig") String desig){
        return new ResponseEntity<>(ms.getMatchByDesig(desig),HttpStatus.OK);
    }
    @PostMapping(path = "/create")
    public ResponseEntity<Void> createMatch(@RequestBody MatchDTO mdto){
        ms.createMatch(mdto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping(path = "/update")
    public ResponseEntity<Void> updateMatch(@RequestBody MatchDTO mdto){
        ms.updateMatch(mdto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping(path = "/delete")
    public ResponseEntity<Void> deleteMatch(@RequestParam("id") Long id){
        ms.deleteMatch(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
