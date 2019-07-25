package diary.project.controller;


import diary.project.model.Training;
import diary.project.service.TrainingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainingController {

    @Autowired
    TrainingServiceImpl trainingService;

    @GetMapping("/training")
    public List<Training> getTrainings(){
        return this.trainingService.getAll();
    }

    @PostMapping("/training")
    public Training addTraining(@RequestBody Training training){
        System.out.println(training);
        return this.trainingService.addTraining(training);
    }

    @PutMapping("/training/{id}")
    public Training change(@PathVariable Integer id, @RequestBody Training tr){
        System.out.println("Change tr " + id + " to " + tr);
        return this.trainingService.change(id, tr);
    }

    @DeleteMapping("/training/{id}")
    public void delete(@PathVariable Integer id){
        this.trainingService.delete(id);
    }
}
