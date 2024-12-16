package com.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.Employee;
import com.edu.error.GlobalExceptionHandling;
import com.edu.service.EmployeeService;

@RestController
public class EmployeeController {
	// EmployeeService
	@Autowired
	private EmployeeService employeeService;

	// add employee

	// http:/localhost:8080/saveEmployee
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);

	}

	// Get All Employee list
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployees();
	}

	// Get particular Employee with id
	@GetMapping("/getEmployeeById/{empid}")
	public Employee getEmployeeById(@PathVariable("empid") Integer employeeid)throws GlobalExceptionHandling {
		return employeeService.getEmployeeById(employeeid);
	}

	// Delete Employee by Id
	@DeleteMapping("deleteEmployeeById/{empid}")
	public List<Employee> deleteEmployeeById(@PathVariable("empid") Integer employeeid) throws GlobalExceptionHandling{
		return employeeService.deleteEmployeeById(employeeid);
	}
	
	 @PutMapping("/updateEmployeeById/{empid}")
	 public Employee updateEmployeeById(@PathVariable("empid") Integer employeeid , @RequestBody Employee employee) throws GlobalExceptionHandling  {
		 return employeeService.updateEmployeeById(employeeid,employee);
	 }

}

