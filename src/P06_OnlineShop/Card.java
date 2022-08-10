package P06_OnlineShop;

/**/
public class Card {

  private boolean isActive;
  private short pin;
  private long cardNumber;
  private String cardHolderName;
  private int cardBalance;

  public boolean isActive() {
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

  public Card(boolean isActive, short pin, long cardNumber,
      String cardHolderName, int cardBalance) {
    //TODO check if the elements are not null
    this.isActive = isActive;
    this.pin = pin;
    this.cardNumber = cardNumber;
    this.cardHolderName = cardHolderName;
    this.cardBalance = cardBalance;
  }

  // ? where shall I insert this method
  public boolean isAuthentified(long cardNumber, short pin) {
    // verify that you are the holder of the card
    // compare the number and the pin with this
    return false;
  }

  public boolean isPinCorect (short pin){
    if (pin==this.pin){
      return true;
    }
    return false;
  }
  public void changePin(boolean oldPinChecked, short newPin) {
    // verified that the old pin is ok
    // verified that the new pin is valid PinCardExceptions
    // change the pin
  }

  public void freezCard(boolean cardStatus) {
    // authentification
    // change status if needed

  }

}
