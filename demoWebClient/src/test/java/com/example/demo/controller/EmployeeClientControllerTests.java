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
import com.example.demo.service.EmployeeClientService;

import io.reactivex.Flowable;
import io.reactivex.observers.TestObserver;

@ExtendWith(MockitoExtension.class)
public class EmployeeClientControllerTests {
	
	@InjectMocks
	EmployeeClientController employeeClientController;
	
	@Mock
	EmployeeClientService employeeClientService;
	
	@Test
	public void whenGetEmployeesThenReturnSuccesful() {
		when(employeeClientService.getEmployees())
		.thenReturn(Flowable.just(Employee.builder().id(1).nombre("Erika").edad(28).rol("Analista").status("Active").build()));
		
		TestObserver<ResponseEntity<Flowable<Employee>>> test = employeeClientController.getEmployees().test();
		
		test.awaitTerminalEvent();
		test.assertComplete();
		test.assertNoErrors();
		assertEquals(1, test.valueCount());
	}

}
