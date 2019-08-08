package diary.project.service;

import diary.project.model.User;

public interface UserService {

	User register(User user);
	User findByUsername(String username);
}
