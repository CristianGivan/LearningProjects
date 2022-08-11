package P07_OnlineShop;

import P07_OnlineShop.Exceptions.CardInactive;

/**/
public class Card {

    private boolean isActive;
    private int pin;
    private long cardNumber;
    private String cardHolderName;
    private int cardBalance;

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

    public Card(boolean isActive, int pin, long cardNumber,
                String cardHolderName, int cardBalance) {
        //TODO check if the elements are not null
        this.isActive = isActive;
        this.pin = pin;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cardBalance = cardBalance;
    }

    // ? where shall I insert this method
    public boolean isAuthentified(long cardNumber, int pin) {
        // verify that you are the holder of the card
        // compare the number and the pin with this
        return false;
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


    public void freezCard() throws CardInactive{
        if (!this.isActive){
            throw new CardInactive("Card is already inactive");
        }
        this.setActive(false);
        // authentification
        // change status if needed

    }

    @Override
    public String toString() {
        return "Card{" +
                "isActive=" + isActive +
                ", pin=" + pin +
                ", cardNumber=" + cardNumber +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", cardBalance=" + cardBalance +
                '}';
    }
}


