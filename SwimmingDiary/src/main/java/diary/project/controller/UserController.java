package diary.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import diary.project.model.User;

@RestController
public class UserController {
	
	@PostMapping("/registration")
	public void register(@RequestBody User user) {
		System.out.println("Registracija");
	}
	

}
