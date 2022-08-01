package P05_BankingApp;

public abstract class BankAccount {

    private double balance;
    private String accountNumber;

    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public abstract boolean withdraw(double amount);

    public abstract boolean deposit(double amount);

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;

    }

    public String getAccountNumber() {
        return this.accountNumber;

    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


}
