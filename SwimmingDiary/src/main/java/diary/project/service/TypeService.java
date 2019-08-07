package diary.project.service;

import java.util.List;

import diary.project.model.Type;

public interface TypeService {
	
	List<Type> getTypes();
	Type addType(Type Type);
	Type changeType(Integer id, Type Type);
	void deleteType(Integer id);
}
