package com.example.demo.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.config.ApplicationProperties;
import com.example.demo.dao.EmployeeClientDao;
import com.example.demo.domain.UpdateEmployeeBody;
import com.example.demo.entity.EmployeeEntity;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.adapter.rxjava.RxJava2Adapter;
import reactor.core.publisher.Mono;

@Slf4j
@Repository
@AllArgsConstructor
public class EmployeeClientDaoImpl implements EmployeeClientDao {
	
	ApplicationProperties applicationProperties;
	
	@Override
	public Flowable<EmployeeEntity> getEmployees() {
		return RxJava2Adapter
				.fluxToFlowable(
						WebClient.create(applicationProperties.getUrlDemoRestWithSpringDataR2DBC())
						.get()
						.uri("/employees")
						.retrieve()
						.bodyToFlux(EmployeeEntity.class))
				.subscribeOn(Schedulers.io())
				.doOnSubscribe(disposable -> log.debug("Consultando getEmployees de servicio externo demoRestWithSpringDataR2DBC"));
	}

	@Override
	public Completable updateEmployee(String id, String nombre) {
		return RxJava2Adapter
				.monoToCompletable(
						WebClient.create(applicationProperties.getUrlDemoRestWithSpringDataR2DBC())
						.patch()
						.uri(String.join("/", "/employees", id))
						.body(Mono.just(UpdateEmployeeBody.builder().nombre(nombre).build()), UpdateEmployeeBody.class)
						.retrieve()
						.bodyToMono(Void.class))
				.subscribeOn(Schedulers.io())
				.doOnSubscribe(disposable -> log.debug("Consultando updateEmployee de servicio externo demoRestWithSpringDataR2DBC"));
	}

}
