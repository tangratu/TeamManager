package Sports_Manager.TeamManager.controllers;

import Sports_Manager.TeamManager.models.Role;
import Sports_Manager.TeamManager.models.Sport;
import Sports_Manager.TeamManager.models.Venue;
import Sports_Manager.TeamManager.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path ="api.V1/utility")
public class UtilityController {
    private UtilityService us;

    @Autowired
    public UtilityController(UtilityService u){
        us =u;
    }
    @PostMapping(path = "/role/create")
    public ResponseEntity<Role> createRole(@RequestParam("role")  String r){
       return  new ResponseEntity<>(us.createRole(r), HttpStatus.CREATED);
    }
    @PostMapping(path = "/venue/create")
    public ResponseEntity<Venue> createVenue(@RequestBody Map<String,String> values) {
        return new ResponseEntity<>(us.createVenue(values.get("name"),values.get("location")),HttpStatus.CREATED);
    }
    @PostMapping(path="/sport/create")
    public ResponseEntity<Sport> createSport(@RequestBody Map<String,String> values){
        return new ResponseEntity<>(us.createSport(values.get("name"),values.get("ruleset")),HttpStatus.CREATED);
    }
    @DeleteMapping(path ="/role/delete")
    public ResponseEntity<Void> deleteRole(@RequestBody Long id){
        us.deleteRole(id);
        return new ResponseEntity<>(HttpStatus.FOUND);
    }
    @DeleteMapping(path="/venue/delete")
    public  ResponseEntity<Void> deleteVenue(@RequestBody Long id){
        us.deleteVenue(id);
        return new ResponseEntity<>(HttpStatus.FOUND);
    }
    @DeleteMapping(path ="/sport/delete")
    public ResponseEntity<Void> deleteSport(@RequestBody Long id){
        us.deleteSport(id);
        return new ResponseEntity<>(HttpStatus.FOUND);
    }
}
