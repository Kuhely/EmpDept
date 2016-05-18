package dao;

import java.util.Map;

import entity.Department;

interface DepartmentDao {

	public boolean insert(Department department);
	public boolean update(Department department);
	public Map<Integer ,Department> getAll();
	public boolean delete(int deptId);
	public Department findById(int deptId);

}
