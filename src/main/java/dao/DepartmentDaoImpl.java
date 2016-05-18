package dao;

import java.util.Map;

import db.Database;
import entity.Department;

public class DepartmentDaoImpl implements DepartmentDao {

	public boolean insert(Department department) {
		try {
			Database.departments.put(department.getDeptId(), department);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Department department) {
		try {
			Database.departments.put(department.getDeptId(), department);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int deptId) {
		try
		{
		Database.departments.remove(deptId);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public Department findById(int deptId) {
		return Database.departments.get(deptId);
	}

	public Map<Integer, Department> getAll() {
		return Database.departments;
	}

}
