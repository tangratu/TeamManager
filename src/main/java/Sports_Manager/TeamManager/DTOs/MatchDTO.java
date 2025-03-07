package Sports_Manager.TeamManager.DTOs;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MatchDTO {
    private Long idmatches;
    private String score;
    private LocalDateTime start;
    private LocalDateTime end;
    private String host;
    private String away;
    private String tourney;
    private String venue;

}
