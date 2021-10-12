package com.chirram.springbootjpademo.dao;

import java.util.List;

import com.chirram.springbootjpademo.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	Employee findById(int id);

	void save(Employee employee);

	void deleteById(int id);

}
