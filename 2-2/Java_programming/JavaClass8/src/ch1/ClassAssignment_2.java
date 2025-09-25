package ch1;

class Employee{
    String first_name;
    String last_name;
    int monthly_salary;
    Employee(String first_name, String last_name, int monthly_salary) {
        this.first_name = first_name;
        this.last_name = last_name;
        if (monthly_salary > 0) {
            this.monthly_salary = monthly_salary;
        }
    }
}
public class ClassAssignment_2 {
    public static void main(String[] args) {
    Employee e1 = new Employee("John", "Smith", 23);
    Employee e2 = new Employee("Elton", "John", 46);

    System.out.println(e1.monthly_salary*12);
    System.out.println(e2.monthly_salary*12);
    }
}
