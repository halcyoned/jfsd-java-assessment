package org.generation.test;

import org.generation.model.Course;
import org.generation.model.Module;
import org.generation.service.CourseService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CourseServiceTest {

    private CourseService courseService;
    private Course course;

    @BeforeEach
    public void setUp() {
        courseService = new CourseService();
        Module module = new Module("INTRO-CS", "Introduction to Computer Science",
                "Introductory module for the generation technical programs");
        course = new Course("INTRO-CS-8", "Example Computer Science Course", 10, module);
        courseService.registerCourse(course);
    }

    @Test
    @DisplayName("Testing registerCourse and getCourse methods")
    public void testRegisterCourseAndGetCourse() {
        Course getCourse = courseService.getCourse("INTRO-CS-8");
        assertEquals(course, getCourse);
    }

    @Test
    @DisplayName("Testing getCourse method returns null if invalid course code entered")
    public void testGetCourseReturnsNullOnInvalidId() {
        assertNull(courseService.getCourse("INTRO-CS-9"));
    }



}
