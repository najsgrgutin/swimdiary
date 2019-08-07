package diary.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diary.project.model.Task;
import diary.project.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;
	
	@Override
	public List<Task> getTasks() {
		return this.taskRepository.findAll();
	}

	@Override
	public Task addTask(Task task) {
		return this.taskRepository.saveAndFlush(task);
	}

	@Override
	public Task changeTask(Integer id, Task task) {
		Task old = this.taskRepository.getOne(id);
		old.setDescription(task.getDescription());
		old.setNote(task.getNote());
		old.setTraining(task.getTrainings());
		old.setType(task.getType());
		return old;
	}

	@Override
	public void deleteTask(Integer id) {
		this.taskRepository.deleteById(id);
	}

}
