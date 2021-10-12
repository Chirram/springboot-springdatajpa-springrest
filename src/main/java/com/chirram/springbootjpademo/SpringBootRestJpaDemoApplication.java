package com.chirram.springbootjpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SpringBootRestJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestJpaDemoApplication.class, args);
	}

}
