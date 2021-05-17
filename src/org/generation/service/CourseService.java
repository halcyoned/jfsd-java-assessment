package org.generation.service;

import org.generation.model.Course;
import org.generation.model.Module;
import org.generation.model.Student;

import java.util.*;

public class CourseService
{
    private final Map<String, Course> courses = new HashMap<>();

    private final Map<String, List<Student>> enrolledStudents = new HashMap<>();

    private final HashMap<String, ArrayList<Integer>> enrolledStudentsWithGrades = new HashMap<String, ArrayList<Integer>>();

    public CourseService()
    {
        Module moduleComScience = new Module( "INTRO-CS", "Introduction to Computer Science",
                                    "Introductory module for the generation technical programs" );
        registerCourse( new Course( "INTRO-CS-1", "Introduction to Computer Science", 9, moduleComScience ) );
        registerCourse( new Course( "INTRO-CS-2", "Introduction to Algorithms", 9, moduleComScience ) );
        registerCourse( new Course( "INTRO-CS-3", "Algorithm Design and Problem Solving - Introduction ", 9, moduleComScience ) );
        registerCourse( new Course( "INTRO-CS-4", "Algorithm Design and Problem Solving - Advanced", 9, moduleComScience ) );
        registerCourse( new Course( "INTRO-CS-5", "Terminal Fundamentals", 9, moduleComScience ) );
        registerCourse( new Course( "INTRO-CS-6", "Source Control Using Git and Github", 9, moduleComScience ) );
        registerCourse( new Course( "INTRO-CS-7", "Agile Software Development with SCRUM", 9, moduleComScience ) );

        Module moduleWebFundamentals = new Module( "INTRO-WEB", "Web Development Fundamentals",
                                                   "Introduction to fundamentals of web development" );
        registerCourse( new Course( "INTRO-WEB-1", "Introduction to Web Applications", 9, moduleWebFundamentals ) );
        registerCourse( new Course( "INTRO-WEB-2", "Introduction to HTML", 9, moduleWebFundamentals ) );
        registerCourse( new Course( "INTRO-WEB-3", "Introduction to CSS", 9, moduleWebFundamentals ) );
        registerCourse( new Course( "INTRO-WEB-4", "Advanced HTML", 9, moduleWebFundamentals ) );
        registerCourse( new Course( "INTRO-WEB-5", "Advanced CSS", 9, moduleWebFundamentals ) );
        registerCourse( new Course( "INTRO-WEB-6", "Introduction to Bootstrap Framework", 9, moduleWebFundamentals ) );
        registerCourse(
            new Course( "INTRO-WEB-7", "Introduction to JavaScript for Web Development", 9, moduleWebFundamentals ) );

    }

    //Puts new input course into courses HashMap
    public void registerCourse( Course course )
    {
        courses.put( course.getCode(), course );
    }

    //Returns course if code is found, else return null
    public Course getCourse( String code )
    {
        if ( courses.containsKey( code ) )
        {
            return courses.get( code );
        }
        return null;
    }

    //Creates new ArrayList for course if course is not already inside enrolledStudents HashMap
    //Adds student into ArrayList for course in enrolledStudent HashMap
    public void enrollStudent( String courseId, Student student ) {
        if ( !enrolledStudents.containsKey( courseId ) )
        {
            enrolledStudents.put( courseId, new ArrayList<>() );
        }
        enrolledStudents.get( courseId ).add( student );
    }

    //Prints out each student enrolled in a given course
    public void showEnrolledStudents( String courseId )
    {
        if ( enrolledStudents.containsKey( courseId ) )
        {
            List<Student> students = enrolledStudents.get( courseId );
            for ( Student student : students )
            {
                System.out.println( student );
            }
        }
    }

    //Menu Option 6
    //Prints all available courses
    //Prints out courses with students enrolled in them
    //Prints out toString of each student in that course
    public void showSummary()
    {
        System.out.println( "Available Courses:" );
        for ( String key : courses.keySet() )           //iterating through all the keys in courses HashMap (i.e. course ID)
        {
            Course course = courses.get( key );         //saves each course into a new course object
            System.out.println( course );               //prints out each course
        }
        System.out.println( "Enrolled Students" );
        for ( String key : enrolledStudents.keySet() )                          //iterating through all the keys in the enrolledStudents HashMap (i.e. course ID of courses with enrolled students)
        {
            List<Student> students = enrolledStudents.get( key );               //saves each student into a new student list
            System.out.println( "Students on Course " + key + ": " );
            for ( Student student : students )                                  //iterating through each student
            {
                System.out.println( student );                                  //prints out each student enrolled in that course
            }
        }
    }

    public double getAverageGrade(String courseCode)
    {
        List<Student> studentList = enrolledStudents.get(courseCode);
        ArrayList<Integer> gradeList = new ArrayList<>();

        for (Student student : studentList) {
            int grade = student.getGrade(courseCode);
            gradeList.add(grade);
        }

        double totalGrade = 0;
        double averageGrade = 0;
        for (Integer grade : gradeList) {
            totalGrade += grade;
        }
        averageGrade = totalGrade / gradeList.size();
        return averageGrade;

    }
}
