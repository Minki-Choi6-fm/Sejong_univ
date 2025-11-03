package DB;

import data.Course;
import data.Student;

import java.sql.*;
import java.util.*;

public class Repository {
    public Student getStudentById(String studentId) {
        String sql = "SELECT * FROM students WHERE student_id = ?";
        Student student = null;

        try (Connection conn = Utilize.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, studentId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    student = new Student(
                            rs.getString("student_id"),
                            rs.getString("name"),
                            rs.getString("major"),
                            rs.getInt("current_semester")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL Error in getStudentById: " + e.getMessage());
            e.printStackTrace();
        }
        return student;
    }

    public ArrayList<Course> getAllCourses() {
        String sql = "SELECT * FROM courses";
        ArrayList<Course> courseList = new ArrayList<>();

        // Utilize 클래스 사용
        try (Connection conn = Utilize.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Course course = new Course(
                        rs.getString("course_code"),
                        rs.getString("course_name"),
                        rs.getString("department"),
                        rs.getInt("target_year"),
                        rs.getInt("total_seats"),
                        rs.getInt("interest_count")
                );
                courseList.add(course);
            }
        } catch (SQLException e) {
            System.err.println("SQL Error in getAllCourses: " + e.getMessage());
            e.printStackTrace();
        }
        return courseList;
    }
}