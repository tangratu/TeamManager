package Sports_Manager.TeamManager.DTOs;

import Sports_Manager.TeamManager.models.Team;

import lombok.Data;

@Data
public class PlayerDTO {


    private String fname;

    private String lname;

    private Integer age;

    private Double salary;

    private String teamName;

    private String role;
}
