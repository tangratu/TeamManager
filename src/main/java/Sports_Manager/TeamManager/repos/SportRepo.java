package Sports_Manager.TeamManager.repos;

import Sports_Manager.TeamManager.models.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepo extends JpaRepository<Sport,Integer> {
}
