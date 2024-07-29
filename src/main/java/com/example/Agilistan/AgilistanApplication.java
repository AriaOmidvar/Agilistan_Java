package com.example.Agilistan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {
		com.example.Agilistan.controller.BookController.class,
		com.example.Agilistan.entity.Book.class,
		com.example.Agilistan.repository.BookRepository.class,
		com.example.Agilistan.service.BookService.class})
public class AgilistanApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgilistanApplication.class, args);
	}
}
