package dao;

import java.util.Map;
		

import db.Database;
import entity.Department;
import entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	public boolean insert(Employee employee) {
		try {
			Database.employees.put(employee.getEmpId(), employee);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Employee employee) {
		try {
			Database.employees.put(employee.getEmpId(), employee);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Map<Integer, Employee> getAll() {
		return Database.employees;
		
	}

	public boolean delete(int empId) {
		try
		{
		Database.employees.remove(empId);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}

	public Employee findById(int empId) {
		return Database.employees.get(empId);
				
		
	}

	
	
}
