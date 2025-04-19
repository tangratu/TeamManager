package Sports_Manager.TeamManager.repos;

import Sports_Manager.TeamManager.models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepo extends JpaRepository<Venue,Long> {
    @Query(value = "SELECT v FROM Venue v WHERE v.v_name=?1")
    public Venue getByName(String name);
}
