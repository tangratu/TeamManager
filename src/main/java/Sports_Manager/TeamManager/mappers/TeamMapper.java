package Sports_Manager.TeamManager.mappers;

import Sports_Manager.TeamManager.DTOs.TeamDTO;
import Sports_Manager.TeamManager.models.Player;
import Sports_Manager.TeamManager.models.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    public TeamDTO map2DTO(Team team);
    @Mapping(target = "players",source = "lplayers" )
    public Team mapDTO(TeamDTO dto, List<Player> lplayers);
}
