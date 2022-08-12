package P07_OnlineShop;

import P07_OnlineShop.Exceptions.MaximTransactionAmountExceeded;
import P07_OnlineShop.Exceptions.NotEnoughMoneyAvailable;

public class DebitCard extends Card implements Payable {


    private int maxTransactionAmount;


    public DebitCard(boolean isActive, int pin, long cardNumber, String cardHolderName,
                     int cardBalance, int maxTransactionAmount) {
        super(isActive, pin, cardNumber, cardHolderName, cardBalance);
        this.maxTransactionAmount = maxTransactionAmount;
    }

    public int getMaxTransactionAmount() {
        return this.maxTransactionAmount;
    }

    public void setMaxTransactionAmount(int maxTransactionAmount) {
        this.maxTransactionAmount = maxTransactionAmount;
    }

    public int pay(int amount) throws NotEnoughMoneyAvailable, MaximTransactionAmountExceeded {
        int amountAvailable = 0;
        if (amount > this.getCardBalance()) {
            //treat the exception in Shop
            amountAvailable = this.getCardBalance();
            throw new NotEnoughMoneyAvailable("Not enough money!");// this masage is check if
        }
        //todo fara else
        if (amount > this.maxTransactionAmount) {
            //treat the exception in Shop
            amountAvailable = this.maxTransactionAmount;
            throw new MaximTransactionAmountExceeded("The maximum amount for a transaction was excceded!");
        }
        this.setCardBalance(this.getCardBalance() - amount);
        return amountAvailable;
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "isActive=" + this.getIsActive() +
                ", cardNumber=" + this.getCardNumber() +
                ", cardHolderName='" + this.getCardHolderName() + '\'' +
                ", cardBalance=" + this.getCardBalance() +
                ", maxTransactionAmount=" + maxTransactionAmount +
                '}';
    }
}