package com.example.demo.domain;

import java.io.Serializable;

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
	private String status;
	
	public EmployeeBuilder mutate() {
		return Employee.builder()
				.id(id)
				.nombre(nombre)
				.edad(edad)
				.rol(rol)
				.status(status);
	}
	
}
