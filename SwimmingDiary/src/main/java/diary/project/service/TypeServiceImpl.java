package diary.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diary.project.model.Type;
import diary.project.repository.TypeRepository;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	TypeRepository typeRepository;

	@Override
	public List<Type> getTypes() {
		return this.typeRepository.findAll();
	}

	@Override
	public Type addType(Type type) {
		return this.typeRepository.saveAndFlush(type);
	}

	@Override
	public Type changeType(Integer id, Type type) {
		Type old = this.typeRepository.getOne(id);
		old.setDescription(type.getDescription());
		return old;
	}

	@Override
	public void deleteType(Integer id) {
		this.typeRepository.deleteById(id);
	}
	
}
