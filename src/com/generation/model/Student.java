package com.generation.model;

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

    private final List<Course> courses = new ArrayList<>();

    private final Map<String, Course> approvedCourses = new HashMap<>();

    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    //We want to add student to an array for course(?)
    //And we want to assign the new courses to the array field for Student object
    public void enrollToCourse( Course course ) {
        if (!isAttendingCourse(course.getCode())) {
            courses.add(course);
        }
    }
    public void registerApprovedCourse( Course course )
    {
        approvedCourses.put( course.getCode(), course );
    }


    public boolean isAttendingCourse( String courseCode ) {
        for(Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                System.out.println("Error! Student is already enrolled in course " + courseCode + "!");
                return true;
            }
        }
        return false;
    }

    @Override
    public double getAverage()
    {
        return average;
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + ", " + courses + "}";
    }
}
