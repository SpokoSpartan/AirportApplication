package com.project.application.airportapplicationproject.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
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
		List<Course> courses = courseRepository.findAll();
		List<Course> initailizedCourse = new ArrayList<>();
		for(Course course: courses) {
			initailizedCourse.add(initialize(course));
		}
		return initailizedCourse;
	}

	public Course getCourseById(Long id) {
		Course course = courseRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("course"));
		course = initialize(course);
		return course;
	}

	public Course createCourse(CourseDTO courseDTO) {
		ModelMapper mapper = new ModelMapper();
		Course course = mapper.map(courseDTO, Course.class);
		return courseRepository.save(course);
	}

	public Course updateCourse(Long id, CourseDTO courseDTO) {
		Course course = courseRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("course"));
		course.setArrivalDate(courseDTO.getArrivalDate());
		course.setDepartureDate(courseDTO.getDepartureDate());
		course.setAvailablePlaces(courseDTO.getAvailablePlaces());
		course.setPlane(courseDTO.getPlane());
		course.setStartAirport(courseDTO.getStartAirport());
		course.setEndAirport(courseDTO.getEndAirport());
		course.setAllocations(courseDTO.getAllocations());
		return courseRepository.save(course);
	}

	public void deleteCourse(Long id) {
		Course course = courseRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("course"));
		courseRepository.delete(course);
	}

	private Course initialize(Course course) {
		Hibernate.initialize(course.getAllocations());
		Hibernate.initialize(course.getEndAirport());
		Hibernate.initialize(course.getStartAirport());
		Hibernate.initialize(course.getTickets());
		Hibernate.initialize(course.getPlane());
		return course;
	}
}
