package P05_BankingApp;

public class SpendingAccount extends BankAccount {
    private double maxWithdrawalAmount;

    public SpendingAccount(double balance, String accountNumber, double maxWithdrawalAmount) {
        super(balance, accountNumber);
        this.maxWithdrawalAmount = maxWithdrawalAmount;
    }

    @Override
    public boolean withdraw(double amount) {
        if (getBalance() + maxWithdrawalAmount > amount) {
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }
    public boolean deposit(double amount){
        setBalance(getBalance()+amount);
        return true;
    }
    public double getMaxWithdrawalAmount(){
        return this.maxWithdrawalAmount;
    }
    public void setMaxWithdrawalAmount(double maxWithdrawalAmount){
        this.maxWithdrawalAmount=maxWithdrawalAmount;
    }

}
