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

import diary.project.model.Type;
import diary.project.service.TypeServiceImpl;

@RestController
public class TypeController {

	private Logger log = LoggerFactory.getLogger(TypeController.class);
	
	@Autowired
	private TypeServiceImpl typeService;
	
	@GetMapping("/type")
	public List<Type> types(){
		log.info("Getting all types");
		return this.typeService.getTypes();
	}
	
	@PostMapping("/type")
	public Type newType(@RequestBody Type type) {
		log.info("Adding new type");
		return this.typeService.addType(type);
	}
	
	@PutMapping("/type/{id}")
	public Type changeType(@PathVariable Integer id, @RequestBody Type type) {
		log.info("Changing type");
		return this.typeService.changeType(id, type);
	}
	
	@DeleteMapping("/type/{id}")
	public void deleteType(@PathVariable Integer id) {
		this.typeService.deleteType(id);
	}
}
