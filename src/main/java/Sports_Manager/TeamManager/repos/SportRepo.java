package Sports_Manager.TeamManager.repos;

import Sports_Manager.TeamManager.models.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepo extends JpaRepository<Sport,Long> {
    @Query(value = "SELECT s FROM Sport s WHERE s.s_name = ?1")
    public Sport getByName(String name);
}
