package com.project.application.airportapplicationproject.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.application.airportapplicationproject.DTOs.CourseDTO;
import com.project.application.airportapplicationproject.entities.Course;
import com.project.application.airportapplicationproject.exceptions.ResourceNotFoundException;
import com.project.application.airportapplicationproject.repositories.CourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {

	private final CourseRepository courseRepository;
	
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	public Course getCourseById(Long id) {
		return courseRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("CourseService", "id", id));
	}

	public Course createCourse(CourseDTO courseDTO) {
		ModelMapper mapper = new ModelMapper();
		Course course = mapper.map(courseDTO, Course.class);
		return courseRepository.save(course);
	}

	public Course updateCourse(Long id, CourseDTO courseDTO) {
		Course course = courseRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("CourseService", "id", id));
		course.setArrivalDate(courseDTO.getArrivalDate());
		course.setDepartureDate(courseDTO.getDepartureDate());
		course.setAvailablePlaces(courseDTO.getAvailablePlaces());
		return courseRepository.save(course);
	}

	public void deleteCourse(Long id) {
		Course course = courseRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("CourseService", "id", id));
		courseRepository.delete(course);
	}
}
