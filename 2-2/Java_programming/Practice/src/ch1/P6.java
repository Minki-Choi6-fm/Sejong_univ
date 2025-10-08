package ch1;

class Employee{
    String firstName;
    String lastName;
    int monthlySalary;
    Employee(String firstName, String lastName, int monthlySalary){
        this.firstName = firstName;
        this.lastName = lastName;
        if(monthlySalary < 0){
            this.monthlySalary = 0;
        }
        else{
            this.monthlySalary = monthlySalary;
        }
    }
    String getFirstName(){
        return this.firstName;
    }
    String getLastName(){
        return this.lastName;
    }
    int getMonthlySalary(){
        return this.monthlySalary;
    }
    void setFirstName(String firstName){
        this.firstName = firstName;
    }
    void setLastName(String lastName){
        this.lastName = lastName;
    }
    void setMonthlySalary(int monthlySalary) {
        if (monthlySalary < 0) {
            this.monthlySalary = 0;
        } else {
            this.monthlySalary = monthlySalary;
        }
    }
}

public class P6 {
    public static void main(String[] args) {
        Employee e1 = new Employee("John", "Smith", 23);
        Employee e2 = new Employee("Steve", "Jobs", 1003);
        System.out.println(e1.getMonthlySalary()*12);
        System.out.println(e2.getMonthlySalary()*12);

        e1.setMonthlySalary((int)(e1.getMonthlySalary()*1.1));
        e2.setMonthlySalary((int)(e2.getMonthlySalary()*1.1));
        System.out.println(e1.getMonthlySalary()*12);
        System.out.println(e2.getMonthlySalary()*12);
    }
}
