package org.generation.test;

import org.generation.model.Student;
import org.generation.service.StudentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;


public class StudentServiceTest {

    private StudentService studentService;
    private Student student;

    @BeforeEach
    public void setUp() throws ParseException {
        studentService = new StudentService();
        student = new Student("111", "Jean", "jean@gmail.com", new SimpleDateFormat("MM/dd/yyyy").parse("01/01/1991"));
        studentService.subscribeStudent(student);
    }

    @Test
    @DisplayName("Test subscribeStudent and findStudent methods")
    public void testSubscribeStudentAndFindStudent() {
        Student findStudent = studentService.findStudent("111");
        assertEquals(student, findStudent);
    }

    @Test
    @DisplayName("Ensure isSubscribed returns true on valid studentId input and false on invalid studentId input")
    public void testIsSubscribedReturnsTrueFalse() {
        assertTrue(studentService.isSubscribed("111"));
        assertFalse(studentService.isSubscribed("222"));
    }


}
