package diary.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diary.project.model.Week;
import diary.project.repository.WeekRepository;

@Service
public class WeekServiceImpl implements WeekService {

	@Autowired
	WeekRepository weekRepository;
	
	@Override
	public List<Week> getWeeks() {
		return this.weekRepository.findAll();
	}

	@Override
	public Week addWeek(Week week) {
		return this.weekRepository.saveAndFlush(week);
	}

	@Override
	public Week changeWeek(Integer id, Week week) {
		Week old = this.weekRepository.getOne(id);
		old.setLength(week.getLength());
		old.setNote(week.getNote());
		old.setOrdinal(week.getOrdinal());
		old.setPeriod(week.getPeriod());
		old.setType(week.getType());
		return old;
	}

	@Override
	public void deleteWeek(Integer id) {
		this.weekRepository.deleteById(id);
	}

}
