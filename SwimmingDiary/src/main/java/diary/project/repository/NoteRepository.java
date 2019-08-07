package diary.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diary.project.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer>{

}
