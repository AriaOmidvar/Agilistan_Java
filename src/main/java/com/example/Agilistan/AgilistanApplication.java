package com.example.Agilistan;

import com.example.Agilistan.controller.ContentController;
import com.example.Agilistan.repository.ContentRepository;
import com.example.Agilistan.repository.PersonRepository;
import com.example.Agilistan.service.ContentService;
import com.example.Agilistan.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {
		ContentController.class,
		com.example.Agilistan.entity.Content.class,
		com.example.Agilistan.entity.Person.class,
		ContentRepository.class,
		PersonRepository.class,
		ContentService.class,
		PersonService.class})
public class AgilistanApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgilistanApplication.class, args);
	}
}
