package Sports_Manager.TeamManager.service;

import Sports_Manager.TeamManager.DTOs.TournamentDTO;
import Sports_Manager.TeamManager.mappers.TournamentMapper;
import Sports_Manager.TeamManager.models.Tournament;
import Sports_Manager.TeamManager.repos.MatchRepo;
import Sports_Manager.TeamManager.repos.SportRepo;
import Sports_Manager.TeamManager.repos.TournamentRepo;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TournamentService {
    private TournamentRepo tr;
    private TournamentMapper tm;
    private SportRepo sr;
    private MatchRepo mr;

    public TournamentService(TournamentRepo t, TournamentMapper tt, SportRepo s, MatchRepo m){
        tr =t;
        tm =tt;
        mr=m;
        sr=s;
    }
    public List<TournamentDTO> getAllTournaments(){
        return tr.findAll().stream().map(dto -> tm.map2DTO(dto)).toList();
    }
    public TournamentDTO getByName(String name){
        return tm.map2DTO(tr.getByName(name));
    }
    public Tournament createTournament(TournamentDTO dto){
        return tr.save(tm.mapDTO(dto,sr.getByName(dto.getSport()),new LinkedList<>()));
    }
    public TournamentDTO updateTournament(TournamentDTO dto){
        return tm.map2DTO(tr.save(tm.mapDTO(dto,sr.getByName(dto.getSport()),tr.getAllMatchesByTournamentName(dto.getT_name()))));
    }
    public void deleteTournament(String name){
        tr.delete(tr.getByName(name));
    }
}
