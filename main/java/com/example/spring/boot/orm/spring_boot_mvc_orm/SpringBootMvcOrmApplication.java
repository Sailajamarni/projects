package com.example.spring.boot.orm.spring_boot_mvc_orm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.spring.boot.orm")
@EnableJpaRepositories(basePackages = "com.example.spring.boot.orm.repositories")
@EntityScan(basePackages = "com.example.spring.boot.orm.model")
public class SpringBootMvcOrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcOrmApplication.class, args);
	}

}
