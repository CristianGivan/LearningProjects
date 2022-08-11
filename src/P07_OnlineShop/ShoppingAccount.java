package P07_OnlineShop;

import P07_OnlineShop.Exceptions.CardNotFound;

// ar merge sa pun un user care sa aiba cateva atribute de la acount
public class ShoppingAccount {

    private Card[] cardList;
    private Address[] addressList;
    private String firstName;
    private String lastname;
    private Card currentPaymentMethod;
    private String currentBillingAddress;
    private String emailAddress;
    private String password;// it should be 10 characters big small letters numbers, special characters
    private int numberOfCards;
    private int numberOfAddress;

    public Card[] getCardList() {
        return cardList;
    }

    public ShoppingAccount(Card[] cardList, Address[] addressList, String emailAddress,
                           String password, String firstName, String lastname, Card currentPaymentMethod,
                           String currentBillingAddress) {
        this.cardList = cardList;
        this.addressList = addressList;
        this.emailAddress = emailAddress;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
        this.currentPaymentMethod = currentPaymentMethod;
        this.currentBillingAddress = currentBillingAddress;
        this.numberOfCards = cardList.length;
        this.numberOfAddress = addressList.length;
    }


    // trebuie sa setez by defoult un cad si o addres la initializarea
    public void addPaymentMethod(Card card) {
        // TODO check if the card is not null
        numberOfCards++;
        cardList[numberOfCards] = card;
    }

    public void deletePaymentMethod(long cardNumber) {
        int numberOfCardFound = findCardIndex(cardNumber);
        for (int i = numberOfCardFound + 1; i < cardList.length; i++) {
            cardList[i - 1] = cardList[i];
        }
    }

    public void selectPaymentMethod(Long cardNumber) {
        this.currentPaymentMethod = cardList[findCardIndex(cardNumber)];

    }

    public boolean findNumberOfValidCards() {
        //todo testez cu o gaura intre elemente
        for (int i = 0; i < cardList.length; i++) {
            if (cardList[i] != null) {
                numberOfCards=i;
            }
        }
    }

    public int findCardIndex(long cardNumber) {
        int numberOfCardFound = -1;
        for (int i = 0; i < cardList.length; i++) {
            if (cardList[i].getCardNumber() == cardNumber) {
                numberOfCardFound = i;
            }

        }
        return numberOfCardFound;
    }

    public Card findCardByNumber(int index) throws CardNotFound {
        int cardNumber = findCardIndex(index);
        if (cardNumber == -1) {
            throw new CardNotFound("The card was not found!");
        }
        return this.getCardList()[findCardIndex(index)];
    }


    //similar si la addresslist
    public void generateReceipt(int amount, Card card, Address address) {
        System.out.println(this.firstName + " " + this.lastname + " payed " + amount +
                "using the card with the number" + card.getCardNumber() +
                " with the address str. " + address.getStreet() + " Nr. " + address.getNumber() +
                " city " + address.getCity());
    }

    public void displayAllCardsDetails() {
        System.out.println("All available cards are:");
        for (int i = 0; i < numberOfCards; i++) {
            System.out.println(cardList[i].toString());
        }
    }


    //getter/setter
    public void setCardList(Card[] cardList) {
        this.cardList = cardList;
    }

    public int getNumberOfCards() {
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

    public int getNumberOfAddress() {
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


}