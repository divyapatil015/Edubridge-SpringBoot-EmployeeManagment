package com.edu.dao;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeid;
	
	@NotEmpty
	@NotBlank(message = "Employee name should not contain whitespace")
	@Column(nullable = false , length=50)
	private String employeename;
	
	@Min(value=10000, message="Minimum should be 10000")
	@Max(value=100000, message="Maximum should be 100000")
	private float employeesalary;
	
	@Email(regexp = "[a-z0-9A-Z0-9._%+-]+@[A-Z0-9a-z0-9.-]+\\.[a-z]{2,3}", message = "invalid Email")
	@Column(unique = true)
	@NotEmpty(message="Enter email id")
	private String employeeemail;
	
	@Pattern(regexp = "^[6-9]\\d{0,9}$")
	@Column(length = 10,unique = true)
	@NotEmpty(message="Enter Phone number")
	private String employeephone;
	
	@Future(message="joining date should be future date")
	private Date employeejoindate;
	
	@Past(message="Date of birth should be past date")
	private Date employeedob;
	
	//MayToOne
	
		@JsonIgnore
		@ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name="departmentid" , referencedColumnName = "departmentid")
		Department department;
		
		//
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String employeename, float employeesalary, String employeeemail, String employeephone,
			Date employeejoindate, Date employeedob) {
		super();
		this.employeename = employeename;
		this.employeesalary = employeesalary;
		this.employeeemail = employeeemail;
		this.employeephone = employeephone;
		this.employeejoindate = employeejoindate;
		this.employeedob = employeedob;
	}
	
	public Integer getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public float getEmployeesalary() {
		return employeesalary;
	}
	public void setEmployeesalary(float employeesalary) {
		this.employeesalary = employeesalary;
	}
	public String getEmployeeemail() {
		return employeeemail;
	}
	public void setEmployeeemail(String employeeemail) {
		this.employeeemail = employeeemail;
	}
	public String getEmployeephone() {
		return employeephone;
	}
	public void setEmployeephone(String employeephone) {
		this.employeephone = employeephone;
	}
	public Date getEmployeejoindate() {
		return employeejoindate;
	}
	public void setEmployeejoindate(Date employeejoindate) {
		this.employeejoindate = employeejoindate;
	}
	public Date getEmployeedob() {
		return employeedob;
	}
	public void setEmployeedob(Date employeedob) {
		this.employeedob = employeedob;
	}
	
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", employeename=" + employeename + ", employeesalary="
				+ employeesalary + ", employeeemail=" + employeeemail + ", employeephone=" + employeephone
				+ ", employeejoindate=" + employeejoindate + ", employeedob=" + employeedob + "]";
	}
	
}
