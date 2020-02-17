package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDAO {

	void insert(Department obj);
	
	void update(Department obj);
	
	void delete(Integer codigo);
	
	Department findById(Integer codigo);
	
	List<Department> findAll();
}
