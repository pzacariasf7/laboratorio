package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeClientDao;
import com.example.demo.domain.Employee;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.service.EmployeeClientService;

import io.reactivex.Flowable;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeClientServiceImpl implements EmployeeClientService {
	
	private EmployeeClientDao employeeClientDao;

	@Override
	public Flowable<Employee> getEmployees() {
		return employeeClientDao.getEmployees()
				.map(this::map)
				.map(employee -> employee.mutate()
						.status("Active")
						.build());
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
