package diary.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diary.project.model.Week;

@Repository
public interface WeekRepository extends JpaRepository<Week, Integer>{

}
