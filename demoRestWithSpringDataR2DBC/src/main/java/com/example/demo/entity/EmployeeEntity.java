package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Table("TB_EMPLEADOS")
public class EmployeeEntity {
	
	@Id
	@Column("EMP_ID")
	private Integer id;
	
	@Column("EMP_NOMBRE")
	private String nombre;
	
	@Column("EMP_EDAD")
	private Integer edad;
	
	@Column("EMP_ROL")
	private String rol;
	
}
