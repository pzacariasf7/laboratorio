package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;

@Configuration
@EnableR2dbcRepositories(basePackages = "com.example.demo.repository")
public class R2DBCConfiguration extends AbstractR2dbcConfiguration {
	
    @Bean
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get(ConnectionFactoryOptions.parse("r2dbc:oracle://localhost:1521/XE")
        		.mutate()
        		.option(ConnectionFactoryOptions.USER, "CGUERRA")
        	    .option(ConnectionFactoryOptions.PASSWORD, "12345678")
        	    .build());
    }
}
