package diary.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diary.project.model.Period;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Integer> {

}
