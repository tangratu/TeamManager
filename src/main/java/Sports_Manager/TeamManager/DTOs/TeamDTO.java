package Sports_Manager.TeamManager.DTOs;

import lombok.Data;

@Data
public class TeamDTO {



    private String team_name;

    private Boolean active;

    private Integer ranking;

    private Double base_salary;
}
