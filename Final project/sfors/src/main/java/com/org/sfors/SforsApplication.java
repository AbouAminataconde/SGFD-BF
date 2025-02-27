package com.org.sfors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.org.sfors.repository")
public class SforsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SforsApplication.class, args);
	}

}
