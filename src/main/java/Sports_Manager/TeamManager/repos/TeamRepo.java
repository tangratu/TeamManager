package Sports_Manager.TeamManager.repos;

import Sports_Manager.TeamManager.models.Player;
import Sports_Manager.TeamManager.models.Team;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface TeamRepo extends JpaRepository<Team,Long> {
    @Query(value = "SELECT t FROM Team t WHERE t.team_name = ?1")
    Team getByName(String name);
    @Query(value = "SELECT t FROM Team t WHERE t.idteams =?1")
    Team getByID(Long id);
    @Query(value = "DELETE FROM Team t WHERE t.idteams =?1")
    public void deleteByID(Long id);
    @Query(value = "SELECT t.idteams FROM Team t WHERE t.team_name =?1")
    public Long getIDByName(String name, Limit limit);
    @Query(value="SELECT p FROM Player p WHERE p.team.team_name=?1 AND p.role.name = 'manager' ")
    public Player getManagerByTeam(String name);
    @Query(value = "SELECT p.team FROM Player p Where p.username =?1")
    public Team getTeamByPlayerUname(String uname);
}
