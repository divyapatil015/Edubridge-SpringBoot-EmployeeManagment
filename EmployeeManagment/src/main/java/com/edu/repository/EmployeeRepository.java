package com.edu.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.dao.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Optional<Employee> findByEmployeephone(String phoneno);
    
	@Query(value ="select * from employee where employeeemail=?",nativeQuery = true)
	Employee getEmployeeByemailid(String employeeemail);

	@Query(value="select * from employee where employeephone=?",nativeQuery = true)
	Employee getEmployeeByphoneno(String employeephone);

	Employee findByEmployeeemailAndEmployeephone(String employeeemail, String employeephone);

	Optional<Employee> findByEmployeeemail(String employeeemail);

	@Transactional
	@Modifying
	@Query(value="delete from employee where employeeemail=?",nativeQuery = true)
	int deleteEmployeeByEmail(String employeeemail);

	@Transactional
	@Modifying
	@Query(value="delete from employee where employeephone=?",nativeQuery = true)
	int deleteEmployeeByPhone(String employeephone);

	@Transactional
	@Modifying
	@Query(value="update employee set employeesalary=?  where employeeid=?",nativeQuery = true)
	int updateEmployeeSalary(float esalary, Integer empid);

}
