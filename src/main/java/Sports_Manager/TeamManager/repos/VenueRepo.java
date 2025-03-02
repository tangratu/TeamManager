package Sports_Manager.TeamManager.repos;

import Sports_Manager.TeamManager.models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepo extends JpaRepository<Venue,Long> {
}
