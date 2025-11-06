package ch1;

class Account{
    private double balance;
    Account(double balance){
        if(balance >= 0.0){
            this.balance = balance;
        }
        else{
            System.out.println("Insufficient balance");
        }
    }
    void Credit(double amount){
        this.balance += amount;
    }
    boolean Debit(double amount){
        if(this.balance < amount){
            System.out.println("Debit amount exceeded account balance");
            return false;
        }
        else{
            this.balance -= amount;
            return true;
        }
    }
    double getBalance(){
        return this.balance;
    }
}
class SavingsAccount extends Account{
    double interestRate;
    SavingsAccount(double balance, double interestRate){
        super(balance);
        this.interestRate = interestRate;
    }
    double CalculateInterest(){
        return super.getBalance() * interestRate;
    }
}
class CheckingAccount extends Account{
    double fee;
    CheckingAccount(double balance,double fee){
        super(balance);
        this.fee = fee;
    }
    void Credit(double amount){
        super.Credit(amount);
        super.Debit(fee);
    }
    boolean Debit(double amount){
        if(super.Debit(amount)){
            return super.Debit(fee);
        }
        else{
            return false;
        }
    }
}
public class ClassAssignment {
    public static void main(String[] args) {

        System.out.println("--- 1. Testing SavingsAccount ---");
        SavingsAccount sa = new SavingsAccount(1000.0, 0.05);
        System.out.println("Initial balance: " + sa.getBalance());

        sa.Credit(500.0);
        System.out.println("Balance after crediting 500: " + sa.getBalance());

        sa.Debit(300.0);
        System.out.println("Balance after debiting 300: " + sa.getBalance());

        sa.Debit(2000.0);
        System.out.println("Balance after failed debit attempt: " + sa.getBalance());

        double interest = sa.CalculateInterest();
        System.out.println("Calculated interest: " + interest);

        sa.Credit(interest);
        System.out.println("Final balance after crediting interest: " + sa.getBalance());


        System.out.println("\n--- 2. Testing CheckingAccount ---");
        CheckingAccount ca = new CheckingAccount(2000.0, 50.0);
        System.out.println("Initial balance: " + ca.getBalance());

        ca.Credit(500.0);
        System.out.println("Balance after crediting 500 (fee applied): " + ca.getBalance());

        ca.Debit(1000.0);
        System.out.println("Balance after debiting 1000 (fee applied): " + ca.getBalance());

        ca.Debit(5000.0);
        System.out.println("Balance after failed debit attempt: " + ca.getBalance());

        ca.Debit(1380.0);
        System.out.println("Balance after debiting 1380 (fee failure): " + ca.getBalance());
    }
}
