package main;

import DB.Repository;
import data.Course;
import data.Student;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // 1. Create a Repository instance
        // 클래스명 변경
        Repository repo = new Repository();

        // 2. Load the student from DB
        System.out.println("--- Loading Student Data ---");
        Student student = repo.getStudentById("20231001");

        if (student != null) {
            System.out.println("Student Name: " + student.getName());
            System.out.println("Major: " + student.getMajor());
            System.out.println("Current Semester: " + student.getCurrentSemester());
        } else {
            System.err.println("Student with ID '20231001' not found.");
            return;
        }

        // 3. Load all courses from DB
        System.out.println("\n--- Loading Course Data ---");
        ArrayList<Course> allCourses = repo.getAllCourses();

        if (!allCourses.isEmpty()) {
            System.out.println("Successfully loaded " + allCourses.size() + " courses.");

            Course firstCourse = allCourses.get(0);
            System.out.println("Sample Course: " + firstCourse.getCourseName());
            System.out.println("Department: " + firstCourse.getDepartment());
        } else {
            System.err.println("No courses found in database.");
        }
    }
}