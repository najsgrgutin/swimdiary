package diary.project.service;

import diary.project.model.User;

public interface UserService {

	User findByUsername(String username);
}
