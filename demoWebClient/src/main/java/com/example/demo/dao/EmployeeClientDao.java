package com.example.demo.dao;

import com.example.demo.entity.EmployeeEntity;

import io.reactivex.Flowable;

public interface EmployeeClientDao {
	
	public Flowable<EmployeeEntity> getEmployees();

}
