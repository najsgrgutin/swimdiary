package diary.project.service;

import diary.project.model.Training;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TrainingService {

    List<Training> getAll();
    Training addTraining(Training training);
    Training change(Integer id, Training tr);
    void delete(Integer id);
}
