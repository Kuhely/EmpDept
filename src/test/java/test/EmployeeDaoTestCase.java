package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import dao.DepartmentDaoImpl;
import dao.EmployeeDaoImpl;
import db.Database;
import entity.Department;
import entity.Employee;

public class EmployeeDaoTestCase {
	
	
	Department department,department1;
	DepartmentDaoImpl departmentdaoimpl;
	Employee employee,employee1,employee2,employee3;
	EmployeeDaoImpl employeedaoimpl;

	@Before
	public void setUp() {
		
		departmentdaoimpl=new DepartmentDaoImpl();
		
		department=new Department();
		department1=new Department();
		
		department.setDeptId(1);
		department.setDeptName("cse");
		departmentdaoimpl.insert(department);
		
		
		department1.setDeptId(2);
		department1.setDeptName("ece");
		departmentdaoimpl.insert(department1);
			
	}

	public void EmployeeInitiation()
	{
		employee=new Employee();
		employee1=new Employee();
		
		employee.setEmpId(1);
		employee.setEmpName("A");
		employee.setAddress("Behala");
		employee.setSex('f');
		employee.setPhNo(123456);
		employee.setSalary(20000);
		employee.setEmpDeptId(1);
		employee.setEmpDeptName(Database.departments.get(employee.getEmpDeptId()).getDeptName());
		
		employee1.setEmpId(2);
		employee1.setEmpName("B");
		employee1.setAddress("Garia");
		employee1.setSex('m');
		employee1.setPhNo(345678);
		employee1.setSalary(20000);
		employee1.setEmpDeptId(2);
		employee1.setEmpDeptName(Database.departments.get(employee1.getEmpDeptId()).getDeptName());
				
	}
	
	
	@Test
	public void testDepartmentInsertMethodTrue() {
		
		EmployeeInitiation();
		employeedaoimpl=new EmployeeDaoImpl();
		
		
		
		assertTrue(employeedaoimpl.insert(employee));
		assertTrue(employeedaoimpl.insert(employee1));
		
		
		assertEquals(2,Database.employees.size());
		
		assertEquals("A",Database.employees.get(1).getEmpName());
		assertEquals("B",Database.employees.get(2).getEmpName());
		
		assertEquals("cse",Database.employees.get(1).getEmpDeptName());
		assertEquals("ece",Database.employees.get(2).getEmpDeptName());
		
	}

	
	@Test
	public void testDepartmentUpdateMethodTrue() {
		
		EmployeeInitiation();
		employeedaoimpl=new EmployeeDaoImpl();
		
		employeedaoimpl.insert(employee);
		employeedaoimpl.insert(employee1);
		
		Employee employeemod = Database.employees.get(1);
		
		employeemod.setEmpName("Kuhely");
		assertTrue(employeedaoimpl.update(employeemod));
		
		assertEquals("Kuhely",Database.employees.get(1).getEmpName());
		assertEquals(2,Database.employees.size());

		
	}
	
	@Test
	public void testDepartmentDeleteMethodTrue() {
		
		EmployeeInitiation();
		employeedaoimpl=new EmployeeDaoImpl();
		
		employeedaoimpl.insert(employee);
		employeedaoimpl.insert(employee1);
		
		assertTrue(employeedaoimpl.delete(1));
		assertEquals(1,Database.employees.size());
		assertNull(Database.employees.get(1));
	
	}
	
	@Test
	public void testDepartmentFindByIdMethodTrue() {
		
		EmployeeInitiation();
		employeedaoimpl=new EmployeeDaoImpl();
		
		
		employeedaoimpl.insert(employee);
		employeedaoimpl.insert(employee1);
		
		
		assertEquals(1,employeedaoimpl.findById(1).getEmpId());
		assertEquals("cse",employeedaoimpl.findById(1).getEmpDeptName());
	
	}

	@Test
	@Ignore
	public void testDepartmentGetAllMethodTrue() {
		
		EmployeeInitiation();
		
		employeedaoimpl=new EmployeeDaoImpl();
		
		employeedaoimpl.insert(employee);
		employeedaoimpl.insert(employee1);
		
		
		
		assertEquals(2,departmentdaoimpl.getAll().size());
		
		
		
		
	}
	

}
