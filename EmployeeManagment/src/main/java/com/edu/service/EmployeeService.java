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

	public Employee findByEmployeeemail(String employeeemail) throws GlobalExceptionHandling;

	public Employee findByEmployeephone(String employeephone) throws GlobalExceptionHandling;
  
	//public Employee findByEmployeeemailAndEmployeephone(String employeeemail, String employeephone);
	
	public Employee getEmployeeByemailid(String employeeemail) throws GlobalExceptionHandling;

	public Employee getEmployeeByphoneno(String employeephone) throws GlobalExceptionHandling;

	Employee findByEmployeeemailAndEmployeephone(String employeeemail, String employeephone)throws GlobalExceptionHandling;

	//public Employee getEmployeeByPhoneAndEmail(String employeeemail, String employeephone);

	public int deleteEmployeeByEmail(String employeeemail);

	public int deleteEmployeeByPhone(String employeephone);

	public String updateEmployeeSalary(float esalary, Integer empid);
			



	

}
