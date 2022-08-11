package P07_OnlineShop;

// ar merge sa pun un user care sa aiba cateva atribute de la acount
public class ShoppingAccount {

  private Card[] cardList;
  private short numberOfCards;
  private Address[] addressList;
  private short numberOfAddress;
  private String emailAddress;
  private String password;// ar trebui sa aiba mini 10 caractere litere si cifre si elemente
  private String firstName;
  private String lastname;
  private Card currentPaymentMethod;

  private String currentBillingAddress;

  public Card[] getCardList() {
    return cardList;
  }

  public void setCardList(Card[] cardList) {
    this.cardList = cardList;
  }

  public short getNumberOfCards() {
    return numberOfCards;
  }

  public void setNumberOfCards(short numberOfCards) {
    this.numberOfCards = numberOfCards;
  }

  public Address[] getAddressList() {
    return addressList;
  }

  public void setAddressList(Address[] addressList) {
    this.addressList = addressList;
  }

  public short getNumberOfAddress() {
    return numberOfAddress;
  }

  public void setNumberOfAddress(short numberOfAddress) {
    this.numberOfAddress = numberOfAddress;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public Card getCurrentPaymentMethod() {
    return currentPaymentMethod;
  }

  public void setCurrentPaymentMethod(Card currentPaymentMethod) {
    this.currentPaymentMethod = currentPaymentMethod;
  }

  public String getCurrentBillingAddress() {
    return currentBillingAddress;
  }

  public void setCurrentBillingAddress(String currentBillingAddress) {
    this.currentBillingAddress = currentBillingAddress;
  }

  // trebuie sa setez by defoult un cad si o addres la initializarea
  public void addPaymantMethod(Card card){
  // TODO check if the card is not null
  cardList[numberOfCards+1]=card;
    }
  public int findCardIndex(long cardNumber){
    int numberOfCardFound=-1;
    for (int i=0; i<cardList.length; i++){
      if (cardList[i].getCardNumber() == cardNumber){
        numberOfCardFound=i;
      }

    }
    return numberOfCardFound;
  }
  public void deletePaymantMethod(long cardNumber){
    int numberOfCardFound=findCardIndex(cardNumber);
    for (int i=numberOfCardFound+1;i<cardList.length;i++){
      cardList[i-1]=cardList[i];
    }
  }
  public void selectPaymentMethod(Long cardNumber){
    this.currentPaymentMethod=cardList[findCardIndex(cardNumber)];
  }
//similar si la addresslist
  public void generateReceipt(int amount, Card card, Address address){
    System.out.println(this.firstName+" " + this.lastname+ " payed " + amount+
            "using the card with the number"+ card.getCardNumber()+
            " with the address str. "+ address.getStreet()+" Nr. "+address.getNumber()+
            " city "+address.getCity());
  }

  
}