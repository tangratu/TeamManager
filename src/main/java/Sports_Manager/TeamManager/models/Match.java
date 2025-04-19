package Sports_Manager.TeamManager.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "matches")
@Data
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idmatches;
    @Column
    private String desig;
    @Column
    private Integer host_score;
    @Column
    private Integer away_score;
    @Column
    private Date start;
    @Column
    private Date end;
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
    public String getTName(){
        if(tournament == null){
            return "none";
        }
        return tournament.getT_name();
    }

}
