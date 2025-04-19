package Sports_Manager.TeamManager.service;

import Sports_Manager.TeamManager.models.Role;
import Sports_Manager.TeamManager.models.Sport;
import Sports_Manager.TeamManager.models.Venue;
import Sports_Manager.TeamManager.repos.RoleRepo;
import Sports_Manager.TeamManager.repos.SportRepo;
import Sports_Manager.TeamManager.repos.VenueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilityService {
    private RoleRepo rp;
    private SportRepo sp;
    private VenueRepo vp;
    @Autowired
    public UtilityService(RoleRepo r, SportRepo s, VenueRepo v){
        rp =r;
        sp=s;
        vp=v;
    }
    public Role createRole(String name){
        Role r = new Role();
        r.setName(name);
        return rp.save(r);
    }
    public Sport createSport(String name, String ruleset){
        Sport s = new Sport();
        s.setS_name(name);
        s.setRuleset(ruleset);
        return sp.save(s);
    }
    public Venue createVenue(String name, String location){
        Venue v = new Venue();
        v.setV_name(name);
        v.setLocation(location);
        return vp.save(v);
    }
    public void deleteRole(Long id){
        rp.deleteById(id);
    }
    public void deleteSport(Long id){
        sp.deleteById(id);
    }
    public void deleteVenue(Long id){
        vp.deleteById(id);
    }

}
