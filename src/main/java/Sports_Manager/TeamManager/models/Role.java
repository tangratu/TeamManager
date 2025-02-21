package Sports_Manager.TeamManager.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "teams")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idteams;
    @Column
    private String role_name;
}
