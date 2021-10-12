package com.chirram.springbootjpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chirram.springbootjpademo.dao.EmployeeService;
import com.chirram.springbootjpademo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee employee = employeeService.findById(employeeId); 
		if(employee == null) {
			throw new RuntimeException("Employee not found with id = " + employeeId);
		}
		
		return employee; 
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		employee.setId(0);
		employeeService.save(employee);

		return employee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee){
		employeeService.save(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee employee = employeeService.findById(employeeId); 
		if(employee == null) {
			throw new RuntimeException("Employee not found with id = " + employeeId);
		}

		employeeService.deleteById(employeeId);
		
		return "Deleted employee id = " + employeeId;
	}
	
}
