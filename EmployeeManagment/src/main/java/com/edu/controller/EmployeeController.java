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
	 
	 //findByEmployeeemail
	 @GetMapping("/findByEmployeeemail/{emailid}")
	 public Employee findByEmployeeemail(@PathVariable("emailid") String employeeemail)throws GlobalExceptionHandling {
		 
		 return employeeService.findByEmployeeemail(employeeemail);
	 }
	 
	 @GetMapping("/findByEmployeephone/{phoneno}")
	 public Employee findByEmployeephone(@PathVariable("phoneno") String employeephone) throws GlobalExceptionHandling{
		return employeeService.findByEmployeephone(employeephone);
		 
	 }
	 
	//findByEmployeeemailAndEmployeephone
	 @GetMapping("/findByEmployeeemailAndEmployeephone/emailid/{emailid}/phoneno/{phoneno}")
	 public Employee findByEmployeeemailAndEmployeephone(@PathVariable("emailid") String employeeemail , @PathVariable("phoneno") String employeephone) throws GlobalExceptionHandling {
		 return  employeeService.findByEmployeeemailAndEmployeephone(employeeemail,employeephone);
		 
	 }
	
	 //find employee by sing email @Query method
	 @GetMapping("/getEmployeeByemailid/{emailid}")
	 public Employee getEmployeeByemailid(@PathVariable("emailid") String employeeemail)throws GlobalExceptionHandling {
		 return employeeService.getEmployeeByemailid(employeeemail);
	 }
	 
	 //find Employee by phone no using @Query method
	 @GetMapping("/getEmployeeByphoneno/{phoneno}")
	 public Employee getEmployeeByphoneno(@PathVariable("phoneno") String employeephone)throws GlobalExceptionHandling{
		 return employeeService.getEmployeeByphoneno(employeephone);
	 }
	 
	 /*
	 //findByEmployeeemailAndEmployeephone using @Query
	 @GetMapping("/getEmployeeByEmailAndPhone/emailid/{emailid}/phoneno/{phoneno")
	 public Employee getEmployeeByPhoneAndEmail(@PathVariable("emailid") String employeeemail , @PathVariable("phoneno") String employeephone) {
		 
		 return employeeService.getEmployeeByPhoneAndEmail(employeeemail,employeephone);
	 }
	 */
	 
	 //delete the record using @Query
	 @DeleteMapping("/deleteEmployeeByEmail/{emailid}")
	 public String deleteEmployeeByEmail(@PathVariable("emailid") String employeeemail) {
		 int i = employeeService.deleteEmployeeByEmail(employeeemail);
			if(i>0)
				return "Employee is deleted";
			else
				return "Employee not deleted";
	 }
	 
	 @DeleteMapping("/deleteEmployeeByPhone/{phoneno}")
	 public String deleteEmployeeByPhone(@PathVariable("phoneno") String employeephone) {
		 int i = employeeService.deleteEmployeeByPhone(employeephone);
		 if(i>0)
			 return " Employee is deleted";
		 else
			 return "Employee is not deleted";
	 }
	 
	 //update salary based on employeeid
	 @PutMapping("/updateEmployeeSalary/esalary/{esalary}/empid/{empid}")
	 public String updateEmployeeSalary(@PathVariable("esalary") float esalary, @PathVariable("empid") Integer empid) {
		 return employeeService.updateEmployeeSalary(esalary,empid);
	 }
}

