package diary.project.service;

import java.util.List;

import diary.project.model.Note;

public interface NoteService {

	List<Note> getNotes();
	Note addNote(Note note);
	Note changeNote(Integer id, Note note);
	void deleteNote(Integer id);
}
