package org.generation.service;

import org.generation.model.Course;
import org.generation.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    //Menu Option 1
    //Puts student ID as key and student object as value into students HashMap
    public void subscribeStudent( Student student )
    {
        students.put( student.getId(), student );
    }

    //Returns student details if student HashMap contains input studentId as key
    public Student findStudent( String studentId )
    {
        if ( students.containsKey( studentId ) )
        {
            return students.get( studentId );
        }
        return null;
    }

    //Checks whether input student exists within students Hashmap
    public boolean isSubscribed( String studentId )
    {
        //TODO implement this method (DONE???)
        return students.containsKey(studentId);
    }

    //Menu Option 5
    //Prints out the toString of each student object in the students HashMap
    public void showSummary()
    {
        //TODO implement (DONE)
        for (String key : students.keySet()) {
            Student student = students.get(key);
            System.out.println(student);
        }
    }

    //Menu Option 4
    public void enrollToCourse( String studentId, Course course )
    {
        if ( students.containsKey( studentId ) )
        {
            students.get( studentId ).enrollToCourse( course );
        }
    }


}
