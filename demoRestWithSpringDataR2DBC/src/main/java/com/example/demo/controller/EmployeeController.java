package com.example.demo.controller;

import io.reactivex.Maybe;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeService;

import io.reactivex.Flowable;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@GetMapping
	public Maybe<ResponseEntity<Flowable<Employee>>> getEmployees() {
		return Maybe.just(ResponseEntity.ok(employeeService.getEmployees()));
	}

}
