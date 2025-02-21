package Sports_Manager.TeamManager.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name ="players")
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idplayers;
    @Column
    private String fname;
    @Column
    private String lname;
    @Column
    private Integer age;
    @Column
    private Double salary;
    @JoinColumn(name = "team_id")
    @ManyToOne
    private Team team;
    @JoinColumn(name = "role_id")
    @ManyToOne
    private Role role;

}
