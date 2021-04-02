package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeService;

import io.reactivex.Flowable;
import io.reactivex.observers.TestObserver;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTests {

	@InjectMocks
	EmployeeController employeeController;

	@Mock
	EmployeeService employeeService;

	@Test
	public void whenGetEmployeesThenReturnSuccessful() {
		when(employeeService.getEmployees())
				.thenReturn(Flowable.just(Employee.builder().id(1).nombre("Erika").edad(28).rol("Analista").build()));

		TestObserver<ResponseEntity<Flowable<Employee>>> test = employeeController.getEmployees().test();

		test.awaitTerminalEvent();
		test.assertComplete();
		test.assertNoErrors();
		assertEquals(1, test.valueCount());
	}

}
