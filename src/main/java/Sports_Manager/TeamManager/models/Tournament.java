package Sports_Manager.TeamManager.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tournaments")
@Data
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idtournaments;
    @Column
    private String t_name;
    @Column
    private float rating_weight;
    @Column
    private int rating_min;
    @Column
    private LocalDateTime begins;
    @Column
    private LocalDateTime ends;
    @JoinColumn(name = "sport_id")
    @ManyToOne
    private Sport sport;
    @OneToMany(mappedBy = "tournament")
    private List<Match> matches;
}
