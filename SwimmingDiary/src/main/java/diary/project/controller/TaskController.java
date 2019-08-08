package diary.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import diary.project.model.Task;
import diary.project.service.TaskServiceImpl;

@RestController
public class TaskController {

	private Logger log = LoggerFactory.getLogger(TaskController.class);
	
	@Autowired
	private TaskServiceImpl taskService;
	
	@GetMapping("/task")
	public List<Task> tasks(){
		log.info("Getting all tasks");
		return this.taskService.getTasks();
	}
	
	@PostMapping("/task")
	public Task newTask(@RequestBody Task task) {
		log.info("Adding new task");
		return this.taskService.addTask(task);
	}
	
	@PutMapping("/task/{id}")
	public Task changeTask(@PathVariable Integer id, @RequestBody Task task) {
		log.info("Changing task");
		return this.taskService.changeTask(id, task);
	}
	
	@DeleteMapping("/task/{id}")
	public void deleteTask(@PathVariable Integer id) {
		this.taskService.deleteTask(id);
	}
}
