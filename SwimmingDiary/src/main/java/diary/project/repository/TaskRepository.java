package diary.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diary.project.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
