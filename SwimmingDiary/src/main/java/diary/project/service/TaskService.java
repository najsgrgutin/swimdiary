package diary.project.service;

import java.util.List;

import diary.project.model.Task;

public interface TaskService {

	List<Task> getTasks();
	Task addTask(Task Task);
	Task changeTask(Integer id, Task Task);
	void deleteTask(Integer id);
}
