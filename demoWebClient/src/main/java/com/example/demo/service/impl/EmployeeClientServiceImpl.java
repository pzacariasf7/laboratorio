package com.example.demo.service.impl;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeClientDao;
import com.example.demo.domain.Employee;
import com.example.demo.domain.EmployeePadres;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.service.EmployeeClientService;

import io.reactivex.Completable;
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
				.padres(employeeEntity.getPadres()
						.stream()
						.map(padre -> EmployeePadres.builder()
								.dni(padre.getDni())
								.nombre(padre.getNombre())
								.parentesco(padre.getParentesco())
								.build())
						.collect(Collectors.toList()))
				.build();
	}

	@Override
	public Completable updateEmployee(String id, String nombre) {
		return employeeClientDao.updateEmployee(id, nombre);
	}

}
