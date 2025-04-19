package Sports_Manager.TeamManager.repos;

import Sports_Manager.TeamManager.models.Match;
import Sports_Manager.TeamManager.models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepo extends JpaRepository<Tournament,Long> {
    @Query(value = "SELECT t FROM Tournament t WHERE t.t_name=?1")
    public Tournament getByName(String name);
    @Query(value = "SELECT m FROM Match m WHERE m.tournament.t_name=?1")
    public List<Match> getAllMatchesByTournamentName(String name);

}
