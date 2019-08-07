package diary.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diary.project.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
