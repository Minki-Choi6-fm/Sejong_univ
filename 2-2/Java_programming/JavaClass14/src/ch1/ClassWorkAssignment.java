package ch1;

import java.util.Scanner;

interface GeometricObject {
    public double getPerimeter();
    public double getArea();
}

class Circle implements GeometricObject {
    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

interface Resizable{
    abstract double resize(int percentage);
}

class ResizableCircle extends Circle implements Resizable {

    public ResizableCircle(double radius) {
        super(radius);
    }

    public double resize(int percentage){
        radius = radius * (1 + percentage / 100.0);
        return radius;
    }
}

public class ClassWorkAssignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("원의 초기 반지름을 입력하세요: ");
        double initialRadius = sc.nextDouble();

        ResizableCircle circle = new ResizableCircle(initialRadius);

        System.out.println("초기 둘레: " + circle.getPerimeter());
        System.out.println("초기 넓이: " + circle.getArea());

        circle.resize(50);
        System.out.println("--- 50% 크기 증가 후 ---");
        System.out.println("변경된 둘레: " + circle.getPerimeter());
        System.out.println("변경된 넓이: " + circle.getArea());

        sc.close();
    }
}