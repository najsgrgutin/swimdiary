package diary.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import diary.project.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(value = "select * from users u where u.username = :username", nativeQuery = true)
	User findByUsername(@Param("username") String username);
}
