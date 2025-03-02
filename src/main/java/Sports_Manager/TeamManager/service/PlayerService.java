package Sports_Manager.TeamManager.service;

import Sports_Manager.TeamManager.DTOs.PlayerDTO;
import Sports_Manager.TeamManager.mappers.PlayerMapper;
import Sports_Manager.TeamManager.models.Player;
import Sports_Manager.TeamManager.repos.PlayerRepo;
import Sports_Manager.TeamManager.repos.RoleRepo;
import Sports_Manager.TeamManager.repos.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class PlayerService {
    private PlayerRepo pr;
    private PlayerMapper pmapr;
    private TeamRepo tr;
    private RoleRepo rr;
    @Autowired
    public PlayerService(PlayerRepo p, TeamRepo t,PlayerMapper pm,RoleRepo rore){
        pr =p;
        tr =t;
        pmapr =pm;
        rr =rore;

    }
    public Player createPlayer(PlayerDTO pdto){
         return pr.save(pmapr.mapDTO(pdto,tr.getByName(pdto.getTeamName()),rr.getByName(pdto.getRole())));
    }
    public PlayerDTO getPlayerById(Long id){
        return pmapr.map2DTO(pr.getByID(id));
    }
    public Player updatePlayer(PlayerDTO pdto){

        return pr.save(pmapr.mapDTO(pdto,tr.getByName(pdto.getTeamName()),rr.getByName(pdto.getRole())));
    }
    public void deleteById(Long id){
        pr.deleteByID(id);
    }
    public List<PlayerDTO> getAllPlayers(){
        return pr.findAll().stream().map(pmapr::map2DTO).collect(Collectors.toList());
    }
    public PlayerDTO getPlayerByName(String name){
        return pmapr.map2DTO(pr.getByName(name.split(" ")[0],name.split(" ")[1]));
    }
    public List<PlayerDTO> getPlayersByTeamID(Long id){
        return pr.getByTeamID(id).stream().map(pmapr::map2DTO).collect(Collectors.toList());
    }
}
