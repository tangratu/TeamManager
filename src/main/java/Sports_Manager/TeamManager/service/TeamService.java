package Sports_Manager.TeamManager.service;

import Sports_Manager.TeamManager.DTOs.TeamDTO;
import Sports_Manager.TeamManager.mappers.TeamMapper;
import Sports_Manager.TeamManager.models.Player;
import Sports_Manager.TeamManager.models.Team;
import Sports_Manager.TeamManager.repos.PlayerRepo;
import Sports_Manager.TeamManager.repos.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private TeamRepo tr;
    private PlayerRepo pr;

    private TeamMapper tmapr;

    @Autowired
    public TeamService(TeamRepo t, PlayerRepo p, TeamMapper tm){
        tr =t;
        pr =p;
        tmapr=tm;

    }
    public List<TeamDTO> getAllTeams(){
        return tr.findAll().stream().map(tmapr::map2DTO).collect(Collectors.toList());
    }
    public TeamDTO getTeamByName(String name){
        return tmapr.map2DTO(tr.getByName(name));
    }

    public List<Player> getPlayerList(String name){
        return pr.getByTeamID(tr.getIDByName(name, Limit.of(1))).stream().collect(Collectors.toList());
    }
    public Team createTeam(TeamDTO dto){
        return tr.save(tmapr.mapDTO(dto,new LinkedList<>()));
    }

    public Team updateTeam(TeamDTO dto){
        return tr.save(tmapr.mapDTO(dto,getPlayerList(dto.getTeam_name())));
    }


    public void deleteTeamByID(Long id){
        tr.deleteByID(id);
    }
    public void addPlayerToTeam(String uname, String team_name){
        tr.save(tr.getByName(team_name).addPlayer(pr.getByUsername(uname)));
    }
    public void removePlayerFromTeam(Long player_id, Long team_id){
        tr.save(tr.getByID(team_id).removePlayer(pr.getByID(player_id)));
    }
    public Player getManager(String teamName){


        return tr.getManagerByTeam(teamName);
    }
    public Team getTeamByPlayerUName(String uname){
        return tr.getTeamByPlayerUname(uname);
    }


}
