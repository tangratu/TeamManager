package Sports_Manager.TeamManager.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "matches")
@Data
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idmatches;
    @Column
    private String score;
    @Column
    private LocalDateTime start;
    @Column
    private LocalDateTime end;
    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;
    @ManyToOne
    @JoinColumn(name ="host_id")
    private Team host;
    @ManyToOne
    @JoinColumn(name = "away_id")
    private Team away;
    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;
    @ManyToOne
    @JoinColumn(name = "mvp_id")
    private Player mvp;
}
