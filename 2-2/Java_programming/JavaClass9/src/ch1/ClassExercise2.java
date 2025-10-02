package ch1;
import java.util.*;

interface Complexity {
    void setComplexity(int level);
    int getComplexity();
}
class Questions implements Complexity {
    private String question;
    private String answer;
    private int complexity;
    Questions(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.complexity = 1;
    }
    public void setComplexity(int level){
        this.complexity = level;
    }
    public int getComplexity(){
        return complexity;
    }
    String getQuestion(){
        return question+" (Level: "+complexity+")";
    }
    String getAnswer(){
        return null;
    }
    boolean answerCorrect(String useranswer){
        return false;
    }
    public String toString(){
        return null;
    }
}
public class ClassExercise2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Set the Question: ");
        String question = sc.nextLine();
        System.out.print("Set the Complexity level: ");
        int complexity = sc.nextInt();
        sc.nextLine();
        System.out.print("Set the Answer: ");
        String answer = sc.nextLine();
        Questions q = new Questions(question, answer);
        q.setComplexity(complexity);
        System.out.println(q.getQuestion());
    }
}
//대체 문제에서 정확히 뭘 만들라고 하는지 모르겠음. 입력예시도 중구난방이고 출력예시도 이상함....