package Sports_Manager.TeamManager.mappers;

import Sports_Manager.TeamManager.DTOs.PlayerDTO;
import Sports_Manager.TeamManager.models.Player;
import Sports_Manager.TeamManager.models.Team;
import Sports_Manager.TeamManager.repos.PlayerRepo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface PlayerMapper {


    @Mapping(target = "teamName",expression = "java(player.getTeam().getTeam_name())")
    public PlayerDTO map2DTO(Player player);
    @Mapping(target = "team",source = "t")
    public Player mapDTO(PlayerDTO pdto, Team t);
}
