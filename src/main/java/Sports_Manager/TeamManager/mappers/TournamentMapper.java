package Sports_Manager.TeamManager.mappers;

import Sports_Manager.TeamManager.DTOs.TournamentDTO;
import Sports_Manager.TeamManager.models.Match;
import Sports_Manager.TeamManager.models.Sport;
import Sports_Manager.TeamManager.models.Tournament;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TournamentMapper {
    @Mapping(target = "sport",expression = "java(tournament.getSport().getS_name())")
    public TournamentDTO map2DTO(Tournament tournament);
    @Mapping(target = "sport",source = "s")
    @Mapping(target = "matches",source = "m")
    public Tournament mapDTO(TournamentDTO tdto, Sport s, List<Match> m);
}
