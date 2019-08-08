package diary.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import diary.project.model.Note;
import diary.project.service.NoteServiceImpl;

@RestController
public class NoteController {

	private Logger log = LoggerFactory.getLogger(NoteController.class);
	
	@Autowired
	private NoteServiceImpl noteService;
	
	@GetMapping("/note")
	public List<Note> notes(){
		log.info("Getting all notes");
		return this.noteService.getNotes();
	}
	
	@PostMapping("/note")
	public Note newNote(@RequestBody Note note) {
		log.info("Adding new note");
		return this.noteService.addNote(note);
	}
	
	@PutMapping("/note/{id}")
	public Note changeNote(@PathVariable Integer id, @RequestBody Note note) {
		log.info("Changing note");
		return this.noteService.changeNote(id, note);
	}
	
	@DeleteMapping("/note/{id}")
	public void deleteNote(@PathVariable Integer id) {
		this.noteService.deleteNote(id);
	}
}
