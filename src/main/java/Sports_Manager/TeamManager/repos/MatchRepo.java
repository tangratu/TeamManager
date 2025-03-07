package Sports_Manager.TeamManager.repos;

import Sports_Manager.TeamManager.models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepo extends JpaRepository<Match,Long> {
    @Query(value = "SELECT m FROM Match m WHERE m.idmatches = ?1")
    public Match getByID(Long id);
}
