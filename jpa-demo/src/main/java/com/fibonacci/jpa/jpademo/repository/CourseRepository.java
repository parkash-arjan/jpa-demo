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
}
