package diary.project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diary.project.model.User;
import diary.project.repository.RoleRepository;
import diary.project.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
    private UserRepository userRepository;
    
//	@Autowired
//    private RoleRepository roleRepository;
	
	@Override
	public User findByUsername(String username) {
		User existing = null;
		try {
        	existing = this.userRepository.findByUsername(username);
        } catch(Exception e) {
        	log.error(e.getMessage());
        }
		return existing;
    }
}
