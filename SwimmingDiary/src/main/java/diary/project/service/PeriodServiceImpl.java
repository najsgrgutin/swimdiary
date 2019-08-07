package diary.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diary.project.model.Period;
import diary.project.repository.PeriodRepository;

@Service
public class PeriodServiceImpl implements PeriodService {

	@Autowired
	PeriodRepository periodRepository;
	
	@Override
	public List<Period> getPeriods() {
		return this.periodRepository.findAll();
	}

	@Override
	public Period addPeriod(Period period) {
		return this.periodRepository.saveAndFlush(period);
	}

	@Override
	public Period changePeriod(Integer id, Period period) {
		Period old = this.periodRepository.getOne(id);
		old.setTypeId(period.getType());
		return old;
	}

	@Override
	public void deletePeriod(Integer id) {
		this.periodRepository.deleteById(id);
	}

}
