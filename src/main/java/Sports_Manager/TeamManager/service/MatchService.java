package Sports_Manager.TeamManager.service;

import Sports_Manager.TeamManager.DTOs.MatchDTO;
import Sports_Manager.TeamManager.mappers.MatchesMapper;
import Sports_Manager.TeamManager.models.Match;
import Sports_Manager.TeamManager.repos.MatchRepo;
import Sports_Manager.TeamManager.repos.TeamRepo;
import Sports_Manager.TeamManager.repos.TournamentRepo;
import Sports_Manager.TeamManager.repos.VenueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    private MatchRepo mr;
    private MatchesMapper mm;
    private TeamRepo tr;
    private VenueRepo vr;
    private TournamentRepo tnr;


    @Autowired
    public MatchService(MatchRepo r, MatchesMapper m, TeamRepo t, VenueRepo v, TournamentRepo tn){
        mr =r;
        mm =m;
        tr =t;
        vr=v;
        tnr =tn;
    }
    public List<MatchDTO> getAllMatches(){
        return mr.findAll().stream().map(dto -> mm.map2DTO(dto)).toList();
    }
    public MatchDTO getMatchByID(Long id){
        return mm.map2DTO(mr.getByID(id));
    }
    public MatchDTO getMatchByDesig(String desig){
        return mm.map2DTO(mr.getByDesig(desig));
    }

    public Match createMatch(MatchDTO mdto){
        return mr.save(mm.mapDTO(mdto,Integer.parseInt(mdto.getScore().split("-")[0]),
                Integer.parseInt(mdto.getScore().split("-")[1]),tr.getByName(mdto.getHost()),tr.getByName(mdto.getAway()),
                tnr.getByName(mdto.getTourney()),vr.getByName(mdto.getVenue())));
    }
    public void updateMatch(MatchDTO mdto){
        mr.save(mm.mapDTO(mdto,Integer.parseInt(mdto.getScore().split("-")[0]),
                Integer.parseInt(mdto.getScore().split("-")[1]),tr.getByName(mdto.getHost()),tr.getByName(mdto.getAway()),
                tnr.getByName(mdto.getTourney()),vr.getByName(mdto.getVenue())));
    }
    public void deleteMatch(Long id){
        mr.deleteById(id);
    }

}
