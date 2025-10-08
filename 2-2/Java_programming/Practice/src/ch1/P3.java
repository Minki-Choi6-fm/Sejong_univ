package ch1;

import java.util.Scanner;

interface Complexity{
    int getComplexity();
    void setComplexity(int complexity);
}
class Questions implements Complexity{
    String question;
    int complexity;
    String answer;

    Questions(String question, int complexity, String answer){
        this.answer = answer;
        this.complexity = 0;
        this.question = question;
    }
    public void setComplexity(int complexity){
        this.complexity = complexity;
    }
    public int getComplexity(){
        return complexity;
    }
    String getQuestion(){
        return question;
    }
    String getAnswer(){
        return answer;
    }
    boolean answerCorrect(String answer){
        return this.answer.equalsIgnoreCase(answer);
    }
    public String toString(){
        return question + ": " + complexity + " " + answer;
    }
}
public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Set the Question: ");
        String question = sc.nextLine();
        System.out.print("Set the Complexity: ");
        int complexity = sc.nextInt();
        sc.nextLine();
        System.out.print("Set the Answer: ");
        String answer = sc.nextLine();
        Questions q = new Questions(question, complexity, answer);
        q.setComplexity(complexity);

        System.out.println(q.getQuestion()+" (Level: "+q.getComplexity()+"): ");
        String ans=sc.nextLine();
        if(!q.answerCorrect(ans)){
            System.out.println("No. the answer is "+q.getAnswer());
        }else{
            System.out.println("Correct");
        }

    }
}
