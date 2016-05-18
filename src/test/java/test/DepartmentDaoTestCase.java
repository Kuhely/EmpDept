package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import dao.DepartmentDaoImpl;
import db.Database;
import entity.Department;

public class DepartmentDaoTestCase {
	
	
	Department department,department1,department2;
	DepartmentDaoImpl departmentdaoimpl;

	public void DepartmentInitiation()
	{
		
		department=new Department();
		department.setDeptId(1);
		department.setDeptName("cse");	
		department1=new Department();
		department1.setDeptId(2);
		department1.setDeptName("ece");
		department2=new Department();
		department2.setDeptId(3);
		department2.setDeptName("it");
		
	}
	
	@Test
	public void testDepartmentInsertMethodTrue() {
		
		DepartmentInitiation();
		departmentdaoimpl=new DepartmentDaoImpl();
		
		assertTrue(departmentdaoimpl.insert(department));
		assertTrue(departmentdaoimpl.insert(department1));
		assertTrue(departmentdaoimpl.insert(department2));
		
		assertEquals(3,Database.departments.size());
		assertEquals("cse",Database.departments.get(1).getDeptName());
		assertEquals("ece",Database.departments.get(2).getDeptName());
		assertEquals("it",Database.departments.get(3).getDeptName());
		
	}

	
	@Test
	public void testDepartmentUpdateMethodTrue() {
		
		departmentdaoimpl=new DepartmentDaoImpl();
		DepartmentInitiation();
		departmentdaoimpl.insert(department);
		departmentdaoimpl.insert(department1);
		departmentdaoimpl.insert(department2);
		
		Department departmentmod = Database.departments.get(3);
		
		departmentmod.setDeptName("aie");
		assertTrue(departmentdaoimpl.update(departmentmod));
		assertEquals("aie",Database.departments.get(3).getDeptName());
		assertEquals(3,Database.departments.size());

		
	}
	
	@Test
	public void testDepartmentDeleteMethodTrue() {
		
		departmentdaoimpl=new DepartmentDaoImpl();
		DepartmentInitiation();
		departmentdaoimpl.insert(department);
		departmentdaoimpl.insert(department1);
		departmentdaoimpl.insert(department2);
		
		assertTrue(departmentdaoimpl.delete(1));
		assertEquals(2,Database.departments.size());
		assertNull(Database.departments.get(1));
	
	}
	
	@Test
	public void testDepartmentFindByIdMethodTrue() {
		
		departmentdaoimpl=new DepartmentDaoImpl();
		DepartmentInitiation();
		departmentdaoimpl.insert(department);
		departmentdaoimpl.insert(department1);
		departmentdaoimpl.insert(department2);
		
		
		assertEquals(3,departmentdaoimpl.findById(3).getDeptId());
	
	}

	@Test
	//@Ignore
	public void testDepartmentGetAllMethodTrue() {
		
		departmentdaoimpl=new DepartmentDaoImpl();
		DepartmentInitiation();
		departmentdaoimpl.insert(department);
		departmentdaoimpl.insert(department1);
		departmentdaoimpl.insert(department2);

		assertEquals(3,departmentdaoimpl.getAll().size());
		
	}

	
}
