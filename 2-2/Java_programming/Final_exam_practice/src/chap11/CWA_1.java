package chap11;

//Chapter 11,p.39~40

class Account{
    private double balance;
    Account(double balance) {
        if(balance>=0.0){
            this.balance = balance;
        }
        else{
            System.out.println("Balance is not valid.");
        }
    }
    public void Credit(double amount){
        this.balance += amount;
    }
    public boolean Debit(double amount){
        try{
            if(amount>this.balance)throw new Exception("Debit amount exceeded account balance.");
            this.balance -= amount;
            return true;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    double getBalance(){
        return this.balance;
    }
}
class SavingsAccount extends Account {
    private double interestRate;
    SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }
    public double CalculateInterest(){
        return interestRate*getBalance();
    }
    public double getInterestRate(){
        return interestRate;
    }
}
class CheckingAccount extends Account {
    private double fee;
    CheckingAccount(double balance, double fee) {
        super(balance);
        this.fee = fee;
    }
    public void Credit(double amount){
        super.Credit(amount);
        super.Debit(fee);
    }
    public boolean Debit(double amount){
        boolean success = super.Debit(amount);
        if(success){
            super.Debit(fee);
        }
        return success;
    }
}

public class CWA_1 {
    public static void main(String[] args) {
        System.out.println("=== Checking Account Test ===");
        CheckingAccount cAccount = new CheckingAccount(100.0, 1.0); // 잔액 100, 수수료 1
        System.out.println("Initial Balance: " + cAccount.getBalance());

        System.out.println("\n[Deposit 50.0]");
        cAccount.Credit(50.0); // 100 + 50 - 1(수수료) = 149
        System.out.println("Balance: " + cAccount.getBalance());

        System.out.println("\n[Withdraw 40.0]");
        cAccount.Debit(40.0);  // 149 - 40 - 1(수수료) = 108
        System.out.println("Balance: " + cAccount.getBalance());

        System.out.println("\n[Withdraw 500.0 (Fail Case)]");
        cAccount.Debit(500.0); // 실패 -> 수수료 안 떼임 -> 그대로 108
        System.out.println("Balance: " + cAccount.getBalance());
    }
}