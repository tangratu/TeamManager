package Sports_Manager.TeamManager.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class MatchDTO {
    private String desig;
    private String score;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd:MM:yyyy")
    private Date start;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd:MM:yyyy")
    private Date end;
    private String host;
    private String away;
    private String tourney;
    private String venue;

}
