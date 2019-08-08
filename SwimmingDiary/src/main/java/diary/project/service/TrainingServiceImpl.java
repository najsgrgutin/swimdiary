package diary.project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diary.project.model.Training;
import diary.project.repository.TrainingRepository;

@Service
public class TrainingServiceImpl implements TrainingService {

	private Logger logger = LoggerFactory.getLogger(TrainingServiceImpl.class);
	
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
        logger.info("Old training " + old.toString());
        logger.info("New training " + tr.toString());
        old.setDate(tr.getDate());
        old.setLength(tr.getLength());
        old.setNote(tr.getNote());
        old.setType(tr.getType());
        old.setWeek(tr.getWeeks());
        return this.trainRepo.saveAndFlush(old);
    }

    @Override
    public void delete(Integer id) {
        this.trainRepo.deleteById(id);
    }
}
