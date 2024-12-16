package com.edu.service;

import java.util.List;

import com.edu.dao.Department;
import com.edu.error.GlobalExceptionHandling;

public interface DepartmentService {

	Department saveDepartment(Department department);

	List<Department> getAllDepartments();

	Department getDepartmentById(Integer departmentid)  throws GlobalExceptionHandling;

	List<Department> deleteDepartmentById(Integer departmentid) throws GlobalExceptionHandling;

	Department updateDepartmentById(Integer departmentid, Department department) throws GlobalExceptionHandling;

	Department updateDepartmentToEmployee(Integer deparmentid, Integer employeeid) throws GlobalExceptionHandling ;
	
	

	

	



	

	
	
}
