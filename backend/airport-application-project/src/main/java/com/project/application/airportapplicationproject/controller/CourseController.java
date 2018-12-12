package com.project.application.airportapplicationproject.controller;

import com.project.application.airportapplicationproject.DTOs.CourseDTO;
import com.project.application.airportapplicationproject.entities.Course;
import com.project.application.airportapplicationproject.services.CourseService;
import com.project.application.airportapplicationproject.utils.Mappings;
import com.project.application.airportapplicationproject.utils.MessageInfo;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Mappings.API_VERSION + Mappings.COURSE)
public class CourseController {

    private final CourseService courseService;

    @GetMapping(Mappings.GET_ALL)
    public ResponseEntity getAllCourse(){
        List<Course> courses = courseService.getAllCourses();
        for(Course course : courses){
            Hibernate.initialize(course.getAllocations());
            Hibernate.initialize(course.getEndAirport());
            Hibernate.initialize(course.getStartAirport());
            Hibernate.initialize(course.getPlane());
        }
        return ResponseEntity.ok().body(new MessageInfo(courses, true, Arrays.asList("List of courses")));
    }

    @GetMapping(Mappings.GET_ONE)
    public ResponseEntity getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        Hibernate.initialize(course.getAllocations());
        Hibernate.initialize(course.getEndAirport());
        Hibernate.initialize(course.getStartAirport());
        Hibernate.initialize(course.getPlane());
        return ResponseEntity.ok().body(new MessageInfo(course, true, Arrays.asList("Course of ID = " + id.toString())));
    }

    @PostMapping(Mappings.CREATE)
    public ResponseEntity createCourse(@RequestBody @Valid CourseDTO courseDTO, BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return ResponseEntity.badRequest().body(errors);
        return ResponseEntity.ok().body(new MessageInfo(courseService.createCourse(courseDTO), true,
                Arrays.asList("Course created successfully")));
    }

    @PostMapping(Mappings.UPDATE)
    public ResponseEntity updateCourse(@PathVariable Long id, @RequestBody @Valid CourseDTO courseDTO,
                                    BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return ResponseEntity.badRequest().body(errors);
        return ResponseEntity.ok().body(new MessageInfo(courseService.updateCourse(id, courseDTO), true,
                Arrays.asList("Course with id = " + id.toString() + " updated successfully")));
    }

    @DeleteMapping(Mappings.REMOVE)
    public ResponseEntity deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok().body(new MessageInfo(null, true,
                Arrays.asList("Course with id = " + id.toString() + "removed succesfully")));
    }
}
