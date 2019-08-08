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

import diary.project.model.Role;
import diary.project.service.RoleServiceImpl;

@RestController
public class RoleController {

	private Logger log = LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
	private RoleServiceImpl roleService;
	
	@GetMapping("/role")
	public List<Role> roles(){
		log.info("Getting all roles");
		return this.roleService.getRoles();
	}
	
	@PostMapping("/role")
	public Role newRole(@RequestBody Role role) {
		log.info("Adding new role");
		return this.roleService.addRole(role);
	}
	
	@PutMapping("/role/{id}")
	public Role changeRole(@PathVariable Integer id, @RequestBody Role role) {
		log.info("Changing role");
		return this.roleService.changeRole(id, role);
	}
	
	@DeleteMapping("/role/{id}")
	public void deleteRole(@PathVariable Integer id) {
		this.roleService.deleteRole(id);
	}
}
