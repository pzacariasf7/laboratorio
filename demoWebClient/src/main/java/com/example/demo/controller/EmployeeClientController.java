package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Employee;
import com.example.demo.domain.UpdateEmployeeRequest;
import com.example.demo.service.EmployeeClientService;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/employeesClient")
@AllArgsConstructor
public class EmployeeClientController {

	private EmployeeClientService employeeClientService;
	
	@GetMapping
	public Maybe<ResponseEntity<Flowable<Employee>>> getEmployees() {
		return Maybe.just(ResponseEntity.ok(employeeClientService.getEmployees()));
	}
	
	@PatchMapping("/{id}")
	public Maybe<ResponseEntity<Void>> updateEmployee(@PathVariable("id") String id, @RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
		return employeeClientService.updateEmployee(id, updateEmployeeRequest.getNombre())
				.andThen(Maybe.just(ResponseEntity.noContent().build()));
	}
	
}
