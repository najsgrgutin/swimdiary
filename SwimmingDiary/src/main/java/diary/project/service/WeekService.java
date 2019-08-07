package diary.project.service;

import java.util.List;

import diary.project.model.Week;

public interface WeekService {

	List<Week> getWeeks();
	Week addWeek(Week Week);
	Week changeWeek(Integer id, Week Week);
	void deleteWeek(Integer id);
}
