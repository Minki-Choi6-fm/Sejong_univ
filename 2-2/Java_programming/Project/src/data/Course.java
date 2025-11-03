package data;

public class Course {
    private String courseCode;
    private String courseName;
    private String department;
    private int targetYear;
    private int totalSeats;
    private int interestCount;

    public Course(String courseCode, String courseName, String department, int targetYear, int totalSeats, int interestCount) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.department = department;
        this.targetYear = targetYear;
        this.totalSeats = totalSeats;
        this.interestCount = interestCount;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public String getCourseName() {
        return courseName;
    }
    public String getDepartment() {
        return department;
    }
    public int getTargetYear() {
        return targetYear;
    }
    public int getTotalSeats() {
        return totalSeats;
    }
    public int getInterestCount() {
        return interestCount;
    }
}
