package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter
@Setter
public class ApplicationProperties {
	
	@Value("${application.properties.url.demoRestWithSpringDataR2DBC}")
	private String urlDemoRestWithSpringDataR2DBC;

}
