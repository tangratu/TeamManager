package Sports_Manager.TeamManager.DTOs;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TournamentDTO {
    private String t_name;
    private LocalDateTime begins;
    private LocalDateTime ends;
    private String sport;

}
