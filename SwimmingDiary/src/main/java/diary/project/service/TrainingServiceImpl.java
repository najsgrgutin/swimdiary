package diary.project.service;

import diary.project.model.Training;
import diary.project.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    TrainingRepository trainRepo;

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
        Training curTr = this.trainRepo.getOne(id);
        curTr.setDate(tr.getDate());
        curTr.setLength(tr.getLength());
        return this.trainRepo.save(curTr);
    }

    @Override
    public void delete(Integer id) {
        this.trainRepo.deleteById(id);
    }
}
