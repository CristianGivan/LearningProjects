package P05_BankingApp;

public class StudentAccount extends BankAccount {

    private final double maxDepositAmount;

    public StudentAccount(double balance, String accountNumber, double maxDepositAmount) {
        super(balance, accountNumber);
        this.maxDepositAmount = maxDepositAmount;
    }

    public boolean withdraw(double amount) {
        if (getBalance() > amount) {
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }

    @Override
    public boolean deposit(double amount) {
        if (getBalance() + amount < maxDepositAmount) {
            setBalance(getBalance() + amount);
            return true;
        }

        return false;
    }

    public double getMaxDepositAmount(){
        return this.maxDepositAmount;
    }
}
