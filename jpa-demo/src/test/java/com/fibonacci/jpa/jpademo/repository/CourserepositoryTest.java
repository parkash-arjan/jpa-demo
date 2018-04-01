package com.fibonacci.jpa.jpademo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.fibonacci.jpa.jpademo.JpaDemoApplication;
import com.fibonacci.jpa.jpademo.entity.Course;

//Launch Spring Context
@RunWith(SpringRunner.class)
// JpaDemoApplication class has @SpringBootApplication annotation
@SpringBootTest(classes = JpaDemoApplication.class)
public class CourserepositoryTest {
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository courseRepository;

	@Test
	public void findById_basic() {
		Course course = courseRepository.findById(10001L);
		assertEquals("JPA", course.getName());
	}

	@Test
	@DirtiesContext
	public void deleteById_basic() {
		courseRepository.deleteById(10001L);
		Course course = courseRepository.findById(10001L);
		assertNull(course);
	}

	@Test
	@DirtiesContext
	public void save_basic() {
		Course course = courseRepository.findById(10001L);
		course.setName("VALUE UPDATED");
		courseRepository.save(course);
		course = courseRepository.findById(10001L);
		assertEquals("VALUE UPDATED", course.getName());
	}
}
