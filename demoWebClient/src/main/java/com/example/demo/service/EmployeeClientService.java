package com.example.demo.service;

import com.example.demo.domain.Employee;

import io.reactivex.Flowable;

public interface EmployeeClientService {
	
	public Flowable<Employee> getEmployees();

}
