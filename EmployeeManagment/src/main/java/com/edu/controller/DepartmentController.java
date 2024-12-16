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

import com.edu.dao.Department;
import com.edu.error.GlobalExceptionHandling;
import com.edu.service.DepartmentService;

@RestController
public class DepartmentController {
//inject the service layer
	@Autowired	
	private DepartmentService departmentService;
	
	//@PostMapping -> save or insert
	//@DeleteMapping -> delete record
	//@PutMapping -> Update record
	//@GetMapping -> fetch the record
	 
	
	    @PostMapping("saveDepartment")
	    public Department saveDepartment(@Valid @RequestBody Department department) {
	        return departmentService.saveDepartment(department);
	    }
	    
	    //Get all Department data
	    
	    @GetMapping("getAllDepartments")
	    public List<Department> getAllDepartments(){
	    	return departmentService.getAllDepartments() ;
	    }
	    
	    // get data by using id
	    @GetMapping("/getDepartmentById/{deptid}")
	    public Department getDepartmentById(@PathVariable("deptid") Integer departmentid)  throws GlobalExceptionHandling {
			return departmentService.getDepartmentById(departmentid);
	    	
	    }
	    
	    //Delete by id
	    /* @DeleteMapping("/deleteDepartmentById/{deptid}")
	     public String deleteDepartmentById(@PathVariable("deptid") Integer departmentid){
			 departmentService.deleteDepartmentById(departmentid);
			 return "Department with id="+departmentid+"is deleted";
	    	 
	     }*/
	    
	    @DeleteMapping("/deleteDepartmentById/{deptid}")
	    public List<Department> deleteDepartmentById(@PathVariable("deptid") Integer departmentid) throws GlobalExceptionHandling{
	    	 return departmentService.deleteDepartmentById(departmentid);
	    	
	    }
	    
	    @PutMapping("/updateDepartmentById/{deptid}")
	    public Department updateDepartmentById(@PathVariable("deptid") Integer departmentid ,@RequestBody Department department)throws GlobalExceptionHandling{
	    	return departmentService.updateDepartmentById(departmentid,department);
	    }
	    
	    //update department id with employee
	    
	    @PutMapping("/updateDepartmentToEmployee/deptid/{deptid}/empid/{empid}")
	    public Department updateDepartmentToEmployee(@PathVariable("deptid") Integer deparmentid, @PathVariable("empid") Integer employeeid) throws GlobalExceptionHandling  {
			return departmentService.updateDepartmentToEmployee(deparmentid,employeeid);}
	    
	  
	    
	     
}

