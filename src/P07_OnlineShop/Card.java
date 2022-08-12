package P07_OnlineShop;

import P07_OnlineShop.Exceptions.AmountAndOverDraftExecuted;
import P07_OnlineShop.Exceptions.CardInactive;
import P07_OnlineShop.Exceptions.MaximTransactionAmountExceeded;
import P07_OnlineShop.Exceptions.NotEnoughMoneyAvailable;

public class Card implements Payable {

    private boolean isActive;
    private int pin;
    private long cardNumber;
    private String cardHolderName;
    private int cardBalance;


    public Card(boolean isActive, int pin, long cardNumber,
                String cardHolderName, int cardBalance) {
        //TODO 4 check if the elements are not null
        this.isActive = isActive;
        this.pin = pin;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cardBalance = cardBalance;
    }

    public boolean isPinCorect(int pin) {
        if (pin == this.pin) {
            return true;
        }
        return false;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void freezeCard() throws CardInactive {
        if (!this.isActive) {
            throw new CardInactive("Card is already inactive");
        }
        this.setActive(false);
    }

    // todo 1 is necessarily?
    @Override
    public int pay(int amount) throws AmountAndOverDraftExecuted,
            NotEnoughMoneyAvailable, MaximTransactionAmountExceeded {
        this.cardBalance = this.cardBalance - amount;
        return 0;
    }

    //getter setter
    public boolean getIsActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(int cardBalance) {
        this.cardBalance = cardBalance;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    @Override
    public String toString() {
        return "Card{" +
                "isActive=" + isActive +
                ", cardNumber=" + cardNumber +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", cardBalance=" + cardBalance +
                '}';
    }
}


