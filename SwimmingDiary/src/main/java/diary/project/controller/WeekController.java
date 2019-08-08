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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diary.project.model.Week;
import diary.project.service.WeekServiceImpl;

@RestController
@RequestMapping("/week")
public class WeekController {

	private Logger log = LoggerFactory.getLogger(WeekController.class);
	
	@Autowired
	private WeekServiceImpl weekService;
	
	@GetMapping
	public List<Week> weeks(){
		log.info("Getting all weeks");
		return this.weekService.getWeeks();
	}
	
	@PostMapping
	public Week newWeek(@RequestBody Week week) {
		log.info("Adding new week");
		return this.weekService.addWeek(week);
	}
	
	@PutMapping("/{id}")
	public Week changeWeek(@PathVariable Integer id, @RequestBody Week week) {
		log.info("Changing week");
		return this.weekService.changeWeek(id, week);
	}
	
	@DeleteMapping("/{id}")
	public void deleteWeek(@PathVariable Integer id) {
		this.weekService.deleteWeek(id);
	}
}
