package diary.project.service;

import diary.project.model.Training;
import diary.project.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingRepository trainRepo;

    @Override
    public List<Training> getAll() {
        return this.trainRepo.findAll();
    }

    @Override
    public Training addTraining(Training training) {
        return this.trainRepo.saveAndFlush(training);
    }

    @Override
    public Training change(Integer id, Training tr) {
        Training old = this.trainRepo.getOne(id);
        old.setDate(tr.getDate());
        old.setLength(tr.getLength());
        return old; 
    }

    @Override
    public void delete(Integer id) {
        this.trainRepo.deleteById(id);
    }
}
