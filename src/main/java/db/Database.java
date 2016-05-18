package db;


import java.util.HashMap;

import java.util.Map;

import entity.Department;
import entity.Employee;

public class Database {

	public static final Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
	public static final Map<Integer, Department> departments = new HashMap<Integer, Department>();

}
