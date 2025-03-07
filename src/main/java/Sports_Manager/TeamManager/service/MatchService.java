package Sports_Manager.TeamManager.service;

import Sports_Manager.TeamManager.DTOs.MatchDTO;
import Sports_Manager.TeamManager.mappers.MatchesMapper;
import Sports_Manager.TeamManager.models.Match;
import Sports_Manager.TeamManager.models.Venue;
import Sports_Manager.TeamManager.repos.MatchRepo;
import Sports_Manager.TeamManager.repos.TeamRepo;
import Sports_Manager.TeamManager.repos.VenueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {
    private MatchRepo mr;
    private MatchesMapper mm;
    private TeamRepo tr;
    private VenueRepo vr;

    @Autowired
    public MatchService(MatchRepo r, MatchesMapper m, TeamRepo t,VenueRepo v){
        mr =r;
        mm =m;
        tr =t;
        vr=v;
    }
    public List<MatchDTO> getAllMatches(){
        return mr.findAll().stream().map(dto -> mm.map2DTO(dto)).toList();
    }
    public Match getMatchByID(Long id){
        return mr.getByID(id);
    }
    public Match createMatch(MatchDTO mdto){
        return mr.save(mm.mapDTO(mdto,Integer.parseInt(mdto.getScore().split("-")[0]),
                Integer.parseInt(mdto.getScore().split("-")[1]),tr.getByName(mdto.getHost()),tr.getByName(mdto.getAway()),
                null,vr.getByName(mdto.getVenue())));
    }

}
