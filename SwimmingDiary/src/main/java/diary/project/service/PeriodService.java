package diary.project.service;

import java.util.List;

import diary.project.model.Period;

public interface PeriodService {
	
	List<Period> getPeriods();
	Period addPeriod(Period Period);
	Period changePeriod(Integer id, Period Period);
	void deletePeriod(Integer id);
}
