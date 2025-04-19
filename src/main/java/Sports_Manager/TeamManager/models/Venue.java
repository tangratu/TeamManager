package Sports_Manager.TeamManager.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "venues")
@Data
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idvenues;
    @Column
    private String v_name;
    @Column
    private String location;

}
