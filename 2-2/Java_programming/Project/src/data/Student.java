package data;

public class Student {
    private String studentId;
    private String name;
    private String major;
    private int currentSemester;

    public Student(String studentId, String name, String major, int currentSemester) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.currentSemester = currentSemester;
    }
    public String getStudentId() {
        return studentId;
    }
    public String getName() {
        return name;
    }
    public String getMajor() {
        return major;
    }
    public int getCurrentSemester() {
        return currentSemester;
    }
}
