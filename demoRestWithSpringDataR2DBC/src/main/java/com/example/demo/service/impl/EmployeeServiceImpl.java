package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Employee;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

import io.reactivex.Flowable;
import lombok.AllArgsConstructor;
import reactor.adapter.rxjava.RxJava2Adapter;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Override
	public Flowable<Employee> getEmployees() {
		return RxJava2Adapter.fluxToFlowable(employeeRepository.findAll())
				.map(this::map);
	}
	
	private Employee map(EmployeeEntity employeeEntity) {
		return Employee.builder()
				.id(employeeEntity.getId())
				.nombre(employeeEntity.getNombre())
				.edad(employeeEntity.getEdad())
				.rol(employeeEntity.getRol())
				.build();
	}	

}
