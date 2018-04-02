package com.fibonacci.jpa.jpademo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fibonacci.jpa.jpademo.entity.Course;

@Repository
@Transactional
public class CourseRepository {
	@Autowired
	EntityManager entityManager;

	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}

	public Course save(Course course) {
		if (course == null) {
			entityManager.persist(course);
		} else {
			entityManager.merge(course);
		}
		return course;
	}

	public void deleteById(Long id) {
		Course course = findById(id);
		entityManager.remove(course);
	}

	public void playWithEntityManager() {
		Course course1 = new Course("This is new Java Course");
		entityManager.persist(course1);
		// Will be tracked by entity manager
		course1.setName("This is new Java Course - Updated");
		Course course2 = new Course("This is new Python Course");
		entityManager.persist(course2);
		course2.setName("This is new Python Course - Updated");
		// Save changes of course1 and course2 into the database
		entityManager.flush();
		// detach will stop tracking of the passed object
		// entityManager.detach(course1);
		// entityManager.detach(course2);
		// clear will stop tracking of all objects
		// entityManager.clear();
	}
}
