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

import diary.project.model.Period;
import diary.project.service.PeriodServiceImpl;

@RestController
public class PeriodController {

	private Logger log = LoggerFactory.getLogger(PeriodController.class);
	
	@Autowired
	private PeriodServiceImpl periodService;
	
	@GetMapping("/period")
	public List<Period> periods(){
		log.info("Getting all periods");
		return this.periodService.getPeriods();
	}
	
	@PostMapping("/period")
	public Period newPeriod(@RequestBody Period period) {
		log.info("Adding new period");
		return this.periodService.addPeriod(period);
	}
	
	@PutMapping("/period/{id}")
	public Period changePeriod(@PathVariable Integer id, @RequestBody Period period) {
		log.info("Changing period");
		return this.periodService.changePeriod(id, period);
	}
	
	@DeleteMapping("/period/{id}")
	public void deletePeriod(@PathVariable Integer id) {
		this.periodService.deletePeriod(id);
	}
}
