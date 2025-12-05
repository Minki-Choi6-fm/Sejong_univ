package function;

import data.*;
import java.util.*;

public class Calculate {
    private ArrayList<Course> courses;
    private ArrayList<Course> exceptions;

    public Calculate(ArrayList<Course> courses) {
        this.courses = courses;
        this.exceptions = new ArrayList<>();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Course> getExceptions() {
        return exceptions;
    }

    public void calculate_priority(Student student) {
        ArrayList<Course> primaryList = new ArrayList<>();
        ArrayList<Course> exceptionList = new ArrayList<>();

        for(Course c : courses) {
            double totalSeats = c.getTotalSeats();
            double interestCount = c.getInterestCount();

            if (totalSeats == 0) {
                totalSeats = 1;
            }

            double score = interestCount / totalSeats;

            String type = c.getCourseType();
            boolean isDiffMajor = !c.getDepartment().equals(student.getMajor());
            boolean isDiffGrade = c.getTargetYear() != student.getGrade();

            if (type != null) {
                switch(type) {
                    case "전필":
                        score *= 5;
                        break;
                    case "전선":
                        score *= 3;
                        break;
                    case "교필":
                        score *= 4;
                        isDiffMajor = false;
                        break;
                    case "교선":
                        score *= 2.5;
                        isDiffGrade = false;
                        break;
                }
            }

            if (isDiffGrade || isDiffMajor) {
                score = score / 5.0;
                c.setScore(score);
                exceptionList.add(c);
            } else {
                c.setScore(score);
                primaryList.add(c);
            }
        }

        this.courses = primaryList;
        this.exceptions = exceptionList;

        this.courses.sort((c1, c2) -> Double.compare(c2.getScore(), c1.getScore()));
        this.exceptions.sort((c1, c2) -> Double.compare(c2.getScore(), c1.getScore()));
    }
}