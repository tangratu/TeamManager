package Sports_Manager.TeamManager.repos;

import Sports_Manager.TeamManager.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    @Query(value="SELECT r FROM Role r WHERE r.name=?1")
    public Role getByName(String name);
}
