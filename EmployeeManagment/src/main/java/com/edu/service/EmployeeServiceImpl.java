
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
	
	

}
