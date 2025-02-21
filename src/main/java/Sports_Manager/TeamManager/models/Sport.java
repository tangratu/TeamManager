package Sports_Manager.TeamManager.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sports")
@Data
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idsports;

    @Column
    private String s_name;
    @Column
    private String ruleset;
    @Column
    private Integer players_per_side;

}
