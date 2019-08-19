package diary.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diary.project.config.JwtTokenUtil;
import diary.project.model.User;
import diary.project.repository.UserRepository;
import diary.project.service.JwtUserDetailsService;

@RestController
@RequestMapping("/user")
public class UserController {

	private Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private UserRepository userService;

	@GetMapping("/")
	public List<User> getUsers(){
		List<User> users = this.userService.findAll();
		log.info("All users " + users);
		return users;
	}
	
	@PutMapping("/{id}")
	public User changeUser(@PathVariable Integer id, @RequestBody User user) {
		User existing = this.userService.getOne(id);
		existing.setUsername(user.getUsername());
		existing.setPassword(user.getPassword());
		existing.setRole(user.getRole());
		return this.userService.save(existing);
	}
	
	@PostMapping("/register")
	public User register(@Valid @RequestBody User user) {
		log.info("Trying to register new user, " + user.toString());
		return this.userDetailsService.save(user);
	}

	@PostMapping("/authenticate")
	public String createAuthenticationToken(@RequestBody User user) throws Exception {
		log.info("Trying to authenticate user, " + user.toString());
		authenticate(user.getUsername(), user.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return token;
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}
