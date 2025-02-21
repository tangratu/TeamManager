package Sports_Manager.TeamManager.service;

import Sports_Manager.TeamManager.DTOs.PlayerDTO;
import Sports_Manager.TeamManager.DTOs.TeamDTO;
import Sports_Manager.TeamManager.mappers.PlayerMapper;
import Sports_Manager.TeamManager.mappers.TeamMapper;
import Sports_Manager.TeamManager.models.Player;
import Sports_Manager.TeamManager.models.Team;
import Sports_Manager.TeamManager.repos.PlayerRepo;
import Sports_Manager.TeamManager.repos.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private TeamRepo tr;
    private PlayerRepo pr;
    private PlayerMapper pmapr;
    private TeamMapper tmapr;

    @Autowired
    public TeamService(TeamRepo t, PlayerRepo p, PlayerMapper pm, TeamMapper tm){
        tr =t;
        pr=p;
        tmapr=tm;
        pmapr=pm;
    }
    public List<TeamDTO> getAllTeams(){
        return tr.findAll().stream().map(tmapr::map2DTO).collect(Collectors.toList());
    }
    public TeamDTO getTeamByName(String name){
        return tmapr.map2DTO(tr.getByName(name));
    }

    public List<Player> getPlayerList(Long team_id){
        return pr.getByTeamID(team_id).stream().collect(Collectors.toList());
    }
    public Team createTeam(TeamDTO dto){
        return tr.save(tmapr.mapDTO(dto,getPlayerList(dto.getIdteams())));
    }
    public TeamDTO getTeamByID(Long id){
        return tmapr.map2DTO(tr.getByID(id));
    }
    public Team updateTeam(TeamDTO dto){
        return tr.save(tmapr.mapDTO(dto,getPlayerList(dto.getIdteams())));
    }
    public void deleteTeamByID(Long id){
        tr.deleteByID(id);
    }
    public void addPlayerToTeam(Long player_id, Long team_id){
        tr.getByID(team_id).addPlayer(pr.getByID(player_id));
    }
    public void removePlayerFromTeam(Long player_id, Long team_id){
        tr.getByID(team_id).removePlayer(pr.getByID(player_id));
    }
}
