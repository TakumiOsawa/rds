package com.sample.aws.rds.config;

import com.sample.aws.rds.domain.service.SampleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RdsApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(RdsApplication.class, args);
		SampleService sampleService = applicationContext.getBean(SampleService.class);

		sampleService.setData();
	}

}
