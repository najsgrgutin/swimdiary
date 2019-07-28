package diary.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import diary.project.repository.UserRepository;

@SpringBootApplication
public class SwimmingDiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwimmingDiaryApplication.class, args);
	}
	
	@Autowired
	public void authenticationManger(AuthenticationManagerBuilder builder, UserRepository repo) throws Exception {
		builder.userDetailsService(new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				return new CustomUserDetails(repo.findByUsername(username));
			}
			
		});
	}

}
