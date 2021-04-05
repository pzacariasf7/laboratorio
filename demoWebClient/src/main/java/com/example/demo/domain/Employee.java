package com.example.demo.domain;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private Integer edad;
	private String rol;
	private List<EmployeePadres> padres;
	private String status;
	
	public EmployeeBuilder mutate() {
		return Employee.builder()
				.id(id)
				.nombre(nombre)
				.edad(edad)
				.rol(rol)
				.padres(padres)
				.status(status);
	}
	
}
