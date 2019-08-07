package diary.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diary.project.model.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer>{

}
