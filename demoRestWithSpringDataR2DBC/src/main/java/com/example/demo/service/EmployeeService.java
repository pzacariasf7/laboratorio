package com.example.demo.service;

import com.example.demo.domain.Employee;

import io.reactivex.Flowable;

public interface EmployeeService {

	public Flowable<Employee> getEmployees();
	
}
