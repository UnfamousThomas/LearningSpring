package com.unfamousthomas.learning;

import com.unfamousthomas.learning.models.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class LearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningApplication.class, args);
	}

	@GetMapping(path = "/api/tsau")
	public String hEADaega() {
		return "Head aega!";
	}

	@GetMapping(path = "api/person")
	public Person person() {
		return new Person(123121414125L, "Mihkel", "police");
	}
}
