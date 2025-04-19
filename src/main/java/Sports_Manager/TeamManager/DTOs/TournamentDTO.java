package Sports_Manager.TeamManager.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import java.util.Date;


@Data
public class TournamentDTO {
    private String t_name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd:MM:yyyy")
    private Date begins;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd:MM:yyyy")
    private Date ends;
    private String sport;

}
