package com.fibonacci.jpa.jpademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fibonacci.jpa.jpademo.entity.Course;
import com.fibonacci.jpa.jpademo.repository.CourseRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
	Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = courseRepository.findById(10001L);
		LOGGER.info("Course {}", course);
		// courseRepository.deleteById(10001L);
		courseRepository.save(new Course("Design & Analysis of Algorithms"));
	}
}
