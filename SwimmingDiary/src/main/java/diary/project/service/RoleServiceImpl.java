package diary.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diary.project.model.Role;
import diary.project.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public List<Role> getRoles() {
		return this.roleRepository.findAll();
	}

	@Override
	public Role addRole(Role role) {
		return this.roleRepository.saveAndFlush(role);
	}

	@Override
	public Role changeRole(Integer id, Role role) {
		Role old = this.roleRepository.getOne(id);
		old.setName(role.getName());
		return old;
	}

	@Override
	public void deleteRole(Integer id) {
		this.roleRepository.deleteById(id);
	}

}
