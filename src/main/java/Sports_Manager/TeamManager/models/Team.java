package Sports_Manager.TeamManager.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "teams")
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idteams;
    @Column
    private String team_name;
    @Column
    private Boolean active;
    @Column
    private Integer ranking;
    @OneToMany(mappedBy = "team")
    private List<Player> players;
    @Column
    private Double base_salary;


    public Team addPlayer(Player p){
        players.add(p);

        p.setTeam(this);
        return this;
    }
    public Team removePlayer(Player p){
        players.remove(p);
        p.setTeam(null);
        return this;
    }
    public String getMName(){
        for (int i = 0; i < players.size(); i++) {
            Player temp = players.get(i);

            if(!Objects.equals(temp.getR(), "player")){
                return temp.getFname()+" "+temp.getLname();
            }
        }
        return "none";
    }

}
