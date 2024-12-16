package com.edu.service;

import java.util.List;

import com.edu.dao.Employee;
import com.edu.error.GlobalExceptionHandling;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(Integer employeeid) throws GlobalExceptionHandling;

	public List<Employee> deleteEmployeeById(Integer employeeid) throws GlobalExceptionHandling;

	public Employee updateEmployeeById(Integer employeeid, Employee employee) throws GlobalExceptionHandling ;

	

	//public List<Employee> getAllEmployees();

	//public Employee getEmployeeById(Integer employeeid);

}
