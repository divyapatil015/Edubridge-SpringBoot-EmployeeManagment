package com.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Department;
import com.edu.dao.Employee;
import com.edu.error.GlobalExceptionHandling;
import com.edu.repository.DepartmentRepository;
import com.edu.repository.EmployeeRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		
		return departmentRepository.save(department);
		
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(Integer departmentid) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Department> deptob = departmentRepository.findById(departmentid);
		if(!deptob.isPresent())
			 throw new GlobalExceptionHandling("Department id="+departmentid+"not exist");
		return departmentRepository.findById(departmentid).get();
		
	}

	@Override
	public List<Department> deleteDepartmentById(Integer departmentid) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Department> deptob = departmentRepository.findById(departmentid);
		if(!deptob.isPresent())
			 throw new GlobalExceptionHandling("Department id="+departmentid+"not exist");
		
		departmentRepository.deleteById(departmentid);
		
		return departmentRepository.findAll();
	}

	@Override
	public Department updateDepartmentById(Integer departmentid, Department department) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		//get the department by id
		Optional<Department> deptob = departmentRepository.findById(departmentid);
		if(!deptob.isPresent())
			 throw new GlobalExceptionHandling("Department id="+departmentid+"not exist");
		Department dept= departmentRepository.findById(departmentid).get();
				if(dept!=null) {
					if(department.getDepartmentname()!=null)
					dept.setDepartmentname(department.getDepartmentname());
					if(department.getDepartmentlocation()!=null)
					dept.setDepartmentlocation(department.getDepartmentlocation());
				}
				return departmentRepository.save(dept);
		
	}

	@Override
	public Department updateDepartmentToEmployee(Integer departmentid, Integer employeeid) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Department> deptob = departmentRepository.findById(departmentid);
		Optional<Employee> empob = employeeRepository.findById(employeeid);
		
			if(!deptob.isPresent() && !empob.isPresent() ) 
			throw new GlobalExceptionHandling("Employee id "+employeeid+" Department id "+departmentid+ "  both are not exist");
			
			else if(!empob.isPresent()) 
				throw new GlobalExceptionHandling("Employee id "+employeeid+" not exist");
			
			else if(!deptob.isPresent())
				throw new GlobalExceptionHandling("Department id "+departmentid+ " not exist");
			
			
		
		
		Department dept= departmentRepository.findById(departmentid).get();
		Employee emp = employeeRepository.findById(employeeid).get();
		
		emp.setDepartment(dept);
		employeeRepository.save(emp);
		return dept;
	}

	

	
	
	}
