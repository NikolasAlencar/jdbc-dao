package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {
	
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
	
	Department department = null;
	
	System.out.println("\n=== TEST 1: department insert ====");
	Department newDepartment = new Department(5, "Footwear");
	departmentDao.insert(newDepartment);
	if (newDepartment.getId() == null) {
		System.out.println("Id auto incremented");
	}
	else {
		System.out.println("Inserted! New id = " + newDepartment.getId());
	}
	
	System.out.println("\n=== TEST 2: seller findAll ====");
	List<Department> list = departmentDao.findAll();
	for (Department obj : list) {
		System.out.println(obj);
	}
	
	System.out.println("\n=== TEST 3: department update ====");
	department = departmentDao.findById(12);
	department.setName("Petshop");
	departmentDao.update(department);
	System.out.println("Update completed");
	
	System.out.println("\n=== TEST 4: seller delete ====");
	System.out.println("Enter id for delete test: ");
	int id = sc.nextInt();
	departmentDao.deleteById(id);
	System.out.println("Delete completed");
	}
}
