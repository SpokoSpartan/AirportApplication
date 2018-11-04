package com.project.application.airportapplicationproject.services;

import java.util.List;

import com.project.application.airportapplicationproject.DTOs.CourseDTO;
import com.project.application.airportapplicationproject.entities.Course;

public interface CourseService {

	List<Course> getAllCourses();
	
	Course getCourseById(Long id);
	
	Course createCourse(CourseDTO courseDTO);
	
	Course updateCourse(Long id, CourseDTO courseDTO);
	
	void deleteCourse(Long id);
}
