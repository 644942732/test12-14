package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@SpringBootApplication
public class Springboot20171128Application {

	@Autowired
	private CounterService counterService;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Springboot20171128Application.class, args);
		FooProperties bean = context.getBean(FooProperties.class);
		System.out.println(bean);
	}

	@Bean
	public ApplicationListener<ApplicationEvent> helloListener() {
		final String HELLO_URL = "/xyz";

		return (ApplicationEvent event) -> {
			if (event instanceof ServletRequestHandledEvent) {
				ServletRequestHandledEvent e = (ServletRequestHandledEvent) event;
				if (e.getRequestUrl().equals(HELLO_URL))
					counterService.increment("xyz.hits");

			}
		};
	}

	@Bean
	public HealthIndicator healthIndicator() {
		return () -> {
			int errorCode = 200;
			if (errorCode != 0) {
				return Health.down().withDetail("Error Code", errorCode).build();
			}
			return Health.up().build();
		};
	}
}
