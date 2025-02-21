package Sports_Manager.TeamManager.repos;

import Sports_Manager.TeamManager.models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tournament_Repo extends JpaRepository<Tournament,Integer> {
}
