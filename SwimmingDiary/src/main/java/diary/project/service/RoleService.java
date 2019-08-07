package diary.project.service;

import java.util.List;

import diary.project.model.Role;

public interface RoleService {
	
	List<Role> getRoles();
	Role addRole(Role Role);
	Role changeRole(Integer id, Role Role);
	void deleteRole(Integer id);
}
