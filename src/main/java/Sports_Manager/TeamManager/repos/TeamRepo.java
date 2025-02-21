package Sports_Manager.TeamManager.repos;

import Sports_Manager.TeamManager.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface TeamRepo extends JpaRepository<Team,Integer> {
    @Query(value = "SELECT t FROM Team t WHERE t.team_name = ?1")
    Team getByName(String name);
    @Query(value = "SELECT t FROM Team t WHERE t.idteams =?1")
    Team getByID(Long id);
    @Query(value = "DELETE FROM Team t WHERE t.idteams =?1")
    public void deleteByID(Long id);
}
