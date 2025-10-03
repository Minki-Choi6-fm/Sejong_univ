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
        return this.complexity;
    }
    String getQuestion(){
        return this.question+" (Level: "+this.complexity+")";
    }
    String getAnswer(){
        return this.answer;
    }
    boolean answerCorrect(String useranswer){
        return useranswer.equalsIgnoreCase(this.answer);
    }
    public String toString(){
        return "Question: " + this.question + "\nAnswer: " + this.answer;
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
        System.out.print("Your answer: ");
        String userAnswer = sc.nextLine();

        if (q.answerCorrect(userAnswer)) {
            System.out.println("yes.");
        } else {
            System.out.println("No, the answer is " + q.getAnswer() + ".");
        }
        sc.close();
    }
}
