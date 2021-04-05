package com.example.demo.domain;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class EmployeePadres implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String dni;
	
	private String nombre;

	private String parentesco;
	
}
