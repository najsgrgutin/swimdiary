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

import diary.project.model.Training;
import diary.project.service.TrainingServiceImpl;

@RestController
public class TrainingController {

	private Logger log = LoggerFactory.getLogger(TrainingController.class);
	
    @Autowired
    TrainingServiceImpl trainingService;

    @GetMapping("/training")
    public List<Training> getTrainings(){
        return this.trainingService.getAll();
    }

    @PostMapping("/training")
    public Training addTraining(@RequestBody Training training){
        log.info("New training " + training.toString());
        return this.trainingService.addTraining(training);
    }

    @PutMapping("/training/{id}")
    public Training change(@PathVariable Integer id, @RequestBody Training tr){
        log.info("Change training");
        return this.trainingService.change(id, tr);
    }

    @DeleteMapping("/training/{id}")
    public void delete(@PathVariable Integer id){
        this.trainingService.delete(id);
    }
}
