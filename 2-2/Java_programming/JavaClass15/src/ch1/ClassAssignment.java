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
        if(this.balance <= amount){
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
            if(super.Debit(fee)){
                return true;
            }
            else {
                return false;
            }
        }
        else{
            return false;
        }
    }
}
public class ClassAssignment {
}
