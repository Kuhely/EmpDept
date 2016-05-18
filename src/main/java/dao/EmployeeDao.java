package dao;

import java.util.*;


import entity.Department;
import entity.Employee;

interface EmployeeDao {
	
	public boolean insert(Employee employee);
	public boolean update(Employee employee);
	public Map<Integer ,Employee> getAll();
	public boolean delete(int empId);
	public Employee findById(int empId);

	
	
}


	



