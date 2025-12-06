package chap9;

// Chapter 9, Page 28~29: Quadrilateral Inheritance Hierarchy

class Quadrilateral {
    private int x1, y1, x2, y2, x3, y3, x4, y4;

    public Quadrilateral(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        this.x1 = x1; this.y1 = y1;
        this.x2 = x2; this.y2 = y2;
        this.x3 = x3; this.y3 = y3;
        this.x4 = x4; this.y4 = y4;
    }

    public int getX1() { return x1; } public int getY1() { return y1; }
    public int getX2() { return x2; } public int getY2() { return y2; }
    public int getX3() { return x3; } public int getY3() { return y3; }
    public int getX4() { return x4; } public int getY4() { return y4; }

    public double getDistance(int xA, int yA, int xB, int yB) {
        return Math.sqrt(Math.pow(xB - xA, 2) + Math.pow(yB - yA, 2));
    }
}

class Parallelogram extends Quadrilateral {
    public Parallelogram(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    public double getArea() {
        double base = getDistance(getX1(), getY1(), getX2(), getY2());
        double height = Math.abs(getY1() - getY4());
        return base * height;
    }
}

class Rectangle extends Parallelogram {
    public Rectangle(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    public double getArea() {
        double width = getDistance(getX1(), getY1(), getX2(), getY2());
        double length = getDistance(getX1(), getY1(), getX4(), getY4());

        return width * length;
    }
}

class Square extends Rectangle {
    public Square(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    public double getArea() {
        double side = getDistance(getX1(), getY1(), getX2(), getY2());
        return Math.pow(side, 2);
    }
}

public class CWE2_9 {
    public static void main(String[] args) {
        Parallelogram p = new Parallelogram(0, 5, 10, 5, 12, 0, 2, 0);
        System.out.println("평행사변형 면적 (Base * Height): " + p.getArea());

        Rectangle r = new Rectangle(0, 10, 20, 10, 20, 0, 0, 0);
        System.out.println("직사각형 면적 (Width * Length): " + r.getArea());

        Square s = new Square(0, 10, 10, 10, 10, 0, 0, 0);
        System.out.println("정사각형 면적 (Side^2): " + s.getArea());
    }
}