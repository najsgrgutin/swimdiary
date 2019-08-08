package diary.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diary.project.model.Note;
import diary.project.repository.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	NoteRepository noteRepository;
	
	@Override
	public List<Note> getNotes() {
		return this.noteRepository.findAll();
	}

	@Override
	public Note addNote(Note note) {
		return this.noteRepository.saveAndFlush(note);
		
	}

	@Override
	public Note changeNote(Integer id, Note note) {
		Note old = this.noteRepository.getOne(id);
		old.setText(note.getText());
		return this.noteRepository.saveAndFlush(old);
	}

	@Override
	public void deleteNote(Integer id) {
		this.noteRepository.deleteById(id);
	}

}
