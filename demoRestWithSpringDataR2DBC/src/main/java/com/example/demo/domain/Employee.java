package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Employee {
	
	private Integer id;
	private String nombre;
	private Integer edad;
	private String rol;
	
}
