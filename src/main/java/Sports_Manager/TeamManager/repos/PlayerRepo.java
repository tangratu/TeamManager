package Sports_Manager.TeamManager.repos;

import Sports_Manager.TeamManager.models.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepo extends JpaRepository<Player,Long> {

    @Query(value = "SELECT p FROM Player p WHERE p.fname=?1 AND p.lname = ?2")
    public Player getByName(String fname, String lname);
    @Query(value = "SELECT p FROM Player p WHERE p.idplayers=?1")
    public Player getByID(Long id);
    @Query(value = "SELECT p FROM Player p WHERE p.team.idteams=?1")
    public List<Player> getByTeamID(Long id);
    @Query(value = "DELETE FROM Player p WHERE p.idplayers=?1")
    public void deleteByID(Long id);
    @Query(value = "SELECT p FROM Player p WHERE p.username = ?1 AND p.password = ?2")
    public Player getByUsernamePassword(String username, String password);
    @Query(value = "SELECT p FROM Player p WHERE p.username = ?1 ")
    public Player getByUsername(String username);
}
