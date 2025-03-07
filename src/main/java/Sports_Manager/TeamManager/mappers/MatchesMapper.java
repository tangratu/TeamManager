package Sports_Manager.TeamManager.mappers;

import Sports_Manager.TeamManager.DTOs.MatchDTO;
import Sports_Manager.TeamManager.models.Match;
import Sports_Manager.TeamManager.models.Team;
import Sports_Manager.TeamManager.models.Tournament;
import Sports_Manager.TeamManager.models.Venue;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MatchesMapper {
    @Mapping(target = "score",expression = "java(match.getHost_score().toString()+'-'+match.getAway_score().toString())")
    @Mapping(target = "host",expression = "java(match.getHost().getTeam_name())")
    @Mapping(target = "away",expression = "java(match.getAway().getTeam_name())")
    @Mapping(target = "venue",expression = "java(match.getVenue().getV_name())")
    @Mapping(target = "tourney",expression = "java(match.getTName())")
    public MatchDTO map2DTO(Match match);
    @Mapping(target = "host_score",source = "host_s")
    @Mapping(target = "away_score",source = "away_s")
    @Mapping(target = "host",source = "h")
    @Mapping(target = "away",source = "a")
    @Mapping(target = "tournament",source = "t")
    @Mapping(target = "venue",source = "v")
    public Match mapDTO(MatchDTO mdto, Integer host_s, Integer away_s, Team h, Team a, Tournament t, Venue v);
}
