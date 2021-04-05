package com.example.demo.dao;

import com.example.demo.entity.EmployeeEntity;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public interface EmployeeClientDao {
	
	public Flowable<EmployeeEntity> getEmployees();

	public Completable updateEmployee(String id, String nombre);

}
