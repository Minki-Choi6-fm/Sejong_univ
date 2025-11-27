package data;

public class Course {
    private String courseCode;
    private String courseName;
    private String department;
    private int targetYear;
    private int totalSeats;
    private int interestCount;
    private String courseType;
    private double score;

    public Course(String courseCode, String courseName, String department, int targetYear, int totalSeats, int interestCount, String courseType) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
        this.targetYear = targetYear;
        this.totalSeats = totalSeats;
        this.interestCount = interestCount;
    }
    public void setInterestCount(int interestCount) {
        this.interestCount = interestCount;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public double getScore() {
        return score;
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
    public String getCourseType() {
        return courseType;
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
