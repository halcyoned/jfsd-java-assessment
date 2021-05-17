package org.generation.java;

import org.generation.model.Course;
import org.generation.model.Student;
import org.generation.service.CourseService;
import org.generation.service.StudentService;
import org.generation.utils.PrinterHelper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{

    public static void main( String[] args )
        throws ParseException
    {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        Scanner scanner = new Scanner( System.in );
        int option = 0;
        do
        {
            PrinterHelper.showMainMenu();
            option = scanner.nextInt();
            switch ( option )
            {
                case 1:
                    registerStudent( studentService, scanner );
                    break;
                case 2:
                    findStudent( studentService, scanner );
                    break;
                case 3:
                    gradeStudent( studentService, scanner );
                    break;
                case 4:
                    enrollStudentToCourse( studentService, courseService, scanner );
                    break;
                case 5:
                    showStudentsSummary( studentService, scanner );
                    break;
                case 6:
                    showCoursesSummary( courseService, scanner );
                    break;
                case 7:
                    getAverageGrade( studentService, courseService, scanner );
                    break;
            }
        }
        while ( option != 8 );
    }


    //Menu Option 7
    private static void getAverageGrade( StudentService studentService, CourseService courseService,
                                         Scanner scanner)
    {
        System.out.println( "Insert course ID" );
        String courseId = scanner.next();
        Course course = courseService.getCourse( courseId );
        if ( course == null )
        {
            System.out.println( "Invalid Course ID" );
            return;
        }
        System.out.println( course );
        double average = courseService.getAverageGrade(courseId);
        System.out.println(String.format("Average grade for this course is: %.1f", average));
    }

    //Menu Option 4
    private static void enrollStudentToCourse( StudentService studentService, CourseService courseService,
                                               Scanner scanner )
    {
        System.out.println( "Insert student ID" );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student == null )
        {
            System.out.println( "Invalid Student ID" );
            return;
        }
        System.out.println( student );
        System.out.println( "Insert course ID" );
        String courseId = scanner.next();
        Course course = courseService.getCourse( courseId );
        if ( course == null )
        {
            System.out.println( "Invalid Course ID" );
            return;
        }
        System.out.println( course );
        courseService.enrollStudent( courseId, student );
        studentService.enrollToCourse( studentId, course );
        System.out.println( "Student with ID: " + studentId + " enrolled successfully to " + courseId );

    }


    //Menu Option 6
    private static void showCoursesSummary( CourseService courseService, Scanner scanner )
    {
        courseService.showSummary();
    }


    //Menu Option 5
    private static void showStudentsSummary( StudentService studentService, Scanner scanner )
    {
        studentService.showSummary();
    }


    //Menu Option 3
    private static void gradeStudent( StudentService studentService, Scanner scanner )
    {
        //TODO implement method (Partially done)
        System.out.println( "Enter student ID: " );
        String studentId = scanner.next();
        Student student = studentService.findStudent(studentId);

        List<Course> courses = student.getApprovedCourses();
        //List<Course> courses = student.getEnrolledCourses();
        System.out.println( "Enrolled courses: " );
        for (Course course : courses) {
            System.out.println("Course: " + course);
        }

        System.out.println("Insert course ID to be graded: ");
        String courseCode = scanner.next();
        for (Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                System.out.println("Insert course grade for: " + course.getName());
                break;
            }
        }

        //TODO implement a method to store grades (DONE???)
        String courseGradeStr = scanner.next();
        int courseGradeInt = Integer.parseInt(courseGradeStr);
        student.setGrade(courseCode, courseGradeInt);
    }


    //Menu Option 2
    private static void findStudent( StudentService studentService, Scanner scanner )
    {
        System.out.println( "Enter student ID: " );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student != null )
        {
            System.out.println( "Student Found: " );
            System.out.println( student );
        }
        else
        {
            System.out.println( "Student with Id = " + studentId + " not found" );
        }
    }


    //Menu Option 1
    private static void registerStudent( StudentService studentService, Scanner scanner )
        throws ParseException
    {
        try
        {
            Student student = PrinterHelper.createStudentMenu( scanner );
            studentService.subscribeStudent( student );
        }
        catch (ParseException e)
        {
            System.out.println("ParseException: " + e.getMessage());
        }

    }
}
