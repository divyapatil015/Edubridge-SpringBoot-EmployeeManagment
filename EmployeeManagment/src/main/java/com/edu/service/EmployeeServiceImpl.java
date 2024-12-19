
package com.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Employee;
import com.edu.error.GlobalExceptionHandling;
import com.edu.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
      
	@Autowired
	 private EmployeeRepository employeeRepository ;
	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}
	@Override
	public Employee getEmployeeById(Integer employeeid) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Employee> empob = employeeRepository.findById(employeeid);
		if(!empob.isPresent())
			throw new GlobalExceptionHandling("Employee id "+employeeid+" does not exist");
		return employeeRepository.findById(employeeid).get();
	}
	@Override
	public List<Employee> deleteEmployeeById(Integer employeeid) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Employee> empob = employeeRepository.findById(employeeid);
		if(!empob.isPresent())
			throw new GlobalExceptionHandling("Employee id "+employeeid+" does not exist");
		return employeeRepository.findAll();
	}
	@Override
	public Employee updateEmployeeById(Integer employeeid, Employee employee) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Employee> empob = employeeRepository.findById(employeeid);
		if(!empob.isPresent())
			throw new GlobalExceptionHandling("Employee id "+employeeid+" does not exist");
		Employee empid = employeeRepository.findById(employeeid).get()		;
		if(empid!=null) {
			if(employee.getEmployeename()!=null)
				empid.setEmployeename(employee.getEmployeename());
			if(employee.getEmployeeemail()!=null)
				empid.setEmployeeemail(employee.getEmployeeemail());
			if(employee.getEmployeephone()!=null)
				empid.setEmployeephone(employee.getEmployeephone());
			if(employee.getEmployeesalary()!= 0)
				empid.setEmployeesalary(employee.getEmployeesalary());
			if(employee.getEmployeedob()!=null)
				empid.setEmployeedob(employee.getEmployeedob());
			if(employee.getEmployeejoindate()!=null)
				empid.setEmployeejoindate(employee.getEmployeejoindate());
			
		}
		return employeeRepository.save(empid) ;

		
	}
	@Override
	public Employee findByEmployeeemail(String employeeemail) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		//return  employeeRepository.findByEmployeeemail(emailid);
		Optional<Employee> empobj = employeeRepository.findByEmployeeemail(employeeemail);
		if(!empobj.isPresent())
			throw new GlobalExceptionHandling("Employee email id "+employeeemail+"not exist");
		return employeeRepository.findByEmployeeemail(employeeemail).get();
	}
	@Override
	public Employee findByEmployeephone(String employeephone) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Employee> empobj= employeeRepository.findByEmployeephone(employeephone);
		if(!empobj.isPresent())
			throw new GlobalExceptionHandling("Employee Phone no. = "+employeephone+" not exist");
		return employeeRepository.findByEmployeephone(employeephone).get();
	}
	
	@Override
	public Employee findByEmployeeemailAndEmployeephone(String employeeemail, String employeephone) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Employee> empob1 = employeeRepository.findByEmployeeemail(employeeemail);
		Optional<Employee> empob2 = employeeRepository.findByEmployeephone(employeephone);
		if(!empob1.isPresent() || !empob2.isPresent() )
			throw new GlobalExceptionHandling("Employee Phone no. = "+employeephone+" Employee email id "+employeeemail+ " not exist");
		if(!empob1.isPresent() )
			throw new GlobalExceptionHandling(" Employee email id "+employeeemail+ " not exist");
		if(!empob2.isPresent() )
			throw new GlobalExceptionHandling("Employee Phone no. = "+employeephone+" not exist");
		
		
		return employeeRepository.findByEmployeeemailAndEmployeephone(employeeemail,employeephone);
	}
	
	
	@Override
	public Employee getEmployeeByemailid(String employeeemail) throws GlobalExceptionHandling {
		Employee empob = employeeRepository.getEmployeeByemailid(employeeemail);
		if(empob == null)
			throw new GlobalExceptionHandling("Employee email id "+employeeemail+"not exist");
		return (empob);
	}
	@Override
	public Employee getEmployeeByphoneno(String employeephone) throws GlobalExceptionHandling {
		Employee emp= employeeRepository.getEmployeeByphoneno(employeephone);
		if(emp==null)
			throw new GlobalExceptionHandling("Employee Phone no. = "+employeephone+" not exist");
		return (emp);
	}
	/*
	@Override
	public Employee getEmployeeByPhoneAndEmail(String employeeemail, String employeephone) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	@Override
	public int deleteEmployeeByEmail(String employeeemail) {
		// TODO Auto-generated method stub
		return employeeRepository.deleteEmployeeByEmail(employeeemail);
		
	}
	@Override
	public int deleteEmployeeByPhone(String employeephone) {
		// TODO Auto-generated method stub
		return employeeRepository.deleteEmployeeByPhone(employeephone);
	}
	@Override
	public String updateEmployeeSalary(float esalary, Integer empid) {
		int i = employeeRepository.updateEmployeeSalary(esalary,empid);
		if(i>0)
		{
			return "Employee salary Updated";
		}
		else {
			return "Employee salary is not updated";
		}
		
	 /*
		Optional<Employee> empob = employeeRepository.findById(empid);
		if(!empob.isPresent())
			throw new GlobalExceptionHandling("Employee id "+empid+" does not exist");
		Employee empid1 = employeeRepository.findById(empid1).get();
		if(empid1!=null) {
			if(employee.getEmployeesalary()!=0)
				empid1.setEmployeesalary(employee.getEmployeesalary());
			
		}
		*/
		
		
	
	
	}	

}
