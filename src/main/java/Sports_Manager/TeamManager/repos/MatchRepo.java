package Sports_Manager.TeamManager.repos;

import Sports_Manager.TeamManager.models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepo extends JpaRepository<Match,Integer> {
}
