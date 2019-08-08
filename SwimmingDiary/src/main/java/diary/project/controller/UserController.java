package diary.project.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diary.project.model.User;
import diary.project.service.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/registration")
	public User register(@Valid @RequestBody User user) {
		log.info("Trying to register new user.");
		return user;
	}
	

}
