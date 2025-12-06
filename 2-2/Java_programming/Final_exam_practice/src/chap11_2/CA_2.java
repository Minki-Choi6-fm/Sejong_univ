package chap11_2;

class Account {
    private double balance;

    Account(double balance) {
        if (balance >= 0.0) {
            this.balance = balance;
        } else {
            System.out.println("Balance is not valid.");
            this.balance = 0.0;
        }
    }

    public void Credit(double amount) {
        try {
            if (amount < 1000) {
                throw new Exception("Cannot deposit less than $1000.");
            }
            this.balance += amount;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("[Update] Current Balance: " + this.balance);
        }
    }

    public boolean Debit(double amount) {
        boolean success = false;
        try {
            if (amount < 1000) {
                throw new Exception("Cannot withdraw less than $1000.");
            }
            if (amount > this.balance) {
                throw new Exception("Debit amount exceeded account balance.");
            }

            this.balance -= amount;
            success = true;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            success = false;
        } finally {
            System.out.println("[Update] Current Balance: " + this.balance);
        }
        return success;
    }

    double getBalance() {
        return this.balance;
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    public double CalculateInterest() {
        return interestRate * getBalance();
    }

    public double getInterestRate() {
        return interestRate;
    }
}

class CheckingAccount extends Account {
    private double fee;

    CheckingAccount(double balance, double fee) {
        super(balance);
        this.fee = fee;
    }

    @Override
    public void Credit(double amount) {
        super.Credit(amount);
        if(amount >= 1000) {
            System.out.println("Transaction fee ($" + fee + ") charged.");
            super.Debit(fee);
        }
    }

    @Override
    public boolean Debit(double amount) {
        boolean success = super.Debit(amount);
        if (success) {
            System.out.println("Transaction fee ($" + fee + ") charged.");
            super.Debit(fee);
        }
        return success;
    }
}

public class CA_2 {
    public static void main(String[] args) {
        System.out.println("=== Checking Account Test ===");
        CheckingAccount cAccount = new CheckingAccount(2000.0, 10.0);

        System.out.println("\n[Deposit 500.0]");
        cAccount.Credit(500.0);

        System.out.println("\n[Deposit 1500.0]");
        cAccount.Credit(1500.0);

        System.out.println("\n[Withdraw 500.0]");
        cAccount.Debit(500.0);

        System.out.println("\n[Withdraw 1200.0]");
        cAccount.Debit(1200.0);

        System.out.println("\n\n=== Savings Account Test ===");
        SavingsAccount sAccount = new SavingsAccount(5000.0, 0.05);

        double interest = sAccount.CalculateInterest();
        System.out.println("Calculated Interest: " + interest);

        System.out.println("[Crediting Interest...]");
        sAccount.Credit(interest);
    }
}