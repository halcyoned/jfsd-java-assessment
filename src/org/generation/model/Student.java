package org.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student
    extends Person
    implements Evaluation
{
    private double average;

    private final List<Course> enrolledCourses = new ArrayList<>();

    private final Map<String, Course> approvedCourses = new HashMap<>();

    private final Map<String, Integer> courseGrades = new HashMap<>();

    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    //Adds course into enrolledCourses ArrayList
    public void enrollToCourse( Course course )
    {
        //TODO implement this method (DONE???)
        enrolledCourses.add(course);
        approvedCourses.put(course.getCode(), course);
        courseGrades.put(course.getCode(), 0);
    }

    //Returns enrolledCourses ArrayList
    //public List<Course> getEnrolledCourses() { return enrolledCourses; }

    //Puts course code into key and course object into value for approvedCourses HashMap
    public void registerApprovedCourse( Course course )
    {
        approvedCourses.put( course.getCode(), course );
    }

    //Checks if input courseCode is found within approvedCourses HashMap
    public boolean isCourseApproved( String courseCode )
    {
        //TODO implement this method (DONE???)
        return approvedCourses.containsKey(courseCode);
    }

    public int getGrade(String courseCode)
    {
        return courseGrades.get(courseCode);
    }

    public void setGrade(String courseCode, int grade)
    {
        courseGrades.put(courseCode, grade);
        System.out.println(courseGrades);
    }

    // CHALLENGE IMPLEMENTATION: Read README.md to find instructions on how to solve.
    //Assumption is that user decides what is the passing grade and hence what course the student passes
    public List<Course> findPassedCourses( Course course )
    {
        //TODO implement this method (DONE???)
        List<Course> passedCourses = new ArrayList<>();
        passedCourses.add(course);
        return passedCourses;
    }

    //Checks whether input course is within enrolledCourses ArrayList
    public boolean isAttendingCourse( String courseCode )
    {
        //TODO implement this method (DONE???)
        boolean isCourse = false;
        for (int i=0; i<enrolledCourses.size(); i++)
        {
            Course course = enrolledCourses.get(i);
            if (course.getCode().equals(courseCode)) {
                isCourse = true;
                break;
            }
        }
        return isCourse;
    }

    @Override
    public double getAverage()
    {
        return average;
    }

    //Returns an ArrayList of courses containing all values of approvedCourses HashMap
    @Override
    public List<Course> getApprovedCourses()
    {
        //TODO implement this method (DONE???)
        List<Course> allApprovedCourses = new ArrayList<>();
        for (String key : approvedCourses.keySet())
        {
            Course course = approvedCourses.get(key);
            allApprovedCourses.add(course);
        }
        return allApprovedCourses;
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }
}
