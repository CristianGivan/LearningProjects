package P07_OnlineShop;

import P07_OnlineShop.Exceptions.CardNotFound;

// ar merge sa pun un user care sa aiba cateva atribute de la acount
public class ShoppingAccount {

    private Card[] cardList;
    private Address[] addressList;
    private String firstName;
    private String lastname;
    private Card currentPaymentMethod;
    private Address currentBillingAddress;
    private String emailAddress;
    private String password;// it should be 10 characters big small letters numbers, special characters
    private int numberOfCards;
    private int numberOfAddress;


    public ShoppingAccount(Card[] cardList, Address[] addressList, String emailAddress,
                           String password, String firstName, String lastname, Card currentPaymentMethod,
                           Address currentBillingAddress) {
        this.cardList = cardList;
        this.addressList = addressList;
        this.emailAddress = emailAddress;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
        this.currentPaymentMethod = currentPaymentMethod;
        this.currentBillingAddress = currentBillingAddress;
        findNumberOfValidCards();
        findNumberOfValidAddresses();
    }


    // trebuie sa setez by defoult un cad si o addres la initializarea
    public void addPaymentMethod(Card card) {
        // TODO 4 check if the card is not null
        cardList[numberOfCards] = card;
        numberOfCards++;
    }

    public void deletePaymentMethod(int cardIndex) {
        for (int i = cardIndex + 1; i < cardList.length; i++) {
            cardList[i - 1] = cardList[i];
        }
    }

    public void selectPaymentMethod(int cardIndex) {
        this.currentPaymentMethod = cardList[cardIndex];
    }

    public boolean findNumberOfValidCards() {
        int lastNotNull = 0;
        for (int i = 0; i < cardList.length; i++) {
            if (cardList[i] != null) {
                lastNotNull = i;
                numberOfCards++;
            }
        }
        if (numberOfCards == lastNotNull + 1) {
            return true;
        } else {
            numberOfCards = lastNotNull + 1;
            return false;
        }
    }

    public boolean findNumberOfValidAddresses() {
        int lastNotNull = 0;
        for (int i = 0; i < addressList.length; i++) {
            if (addressList[i] != null) {
                lastNotNull = i;
                numberOfAddress++;
            }
        }
        if (numberOfAddress == lastNotNull + 1) {
            return true;
        } else {
            numberOfAddress = lastNotNull + 1;
            return false;
        }
    }

    public int findCardIndex(long cardNumber) throws CardNotFound {
        int numberOfCardFound = -1;
        //todo NullPointerException
        for (int i = 0; i < numberOfCards; i++) {
            if (cardList[i].getCardNumber() == cardNumber) {
                numberOfCardFound = i;
            }
        }
        if (numberOfCardFound == -1) {
            throw new CardNotFound("The card was not found!");
        }
        return numberOfCardFound;
    }

    public Card findCardByNumber(int index) throws CardNotFound {
        int cardNumber = findCardIndex(index);
        return this.getCardList()[findCardIndex(index)];
    }

    public String generateReceipt(int amount) {
        return "Name: " + this.firstName + " " + this.lastname + " payed " + amount +
                "using the card with the number" + currentPaymentMethod.getCardNumber() +
                " with the address str. " + currentBillingAddress.getStreet() + " Nr. " +
                currentBillingAddress.getNumber() + " city " + currentBillingAddress.getCity();
    }

    public void displayAllCardsDetails() {
        int numberOfNullCardsNotDisplayed = 0;
        System.out.println("All available cards are:");
        for (int i = 0; i < numberOfCards; i++) {
            try {
                System.out.println(cardList[i].toString());
            } catch (NullPointerException e) {
                numberOfNullCardsNotDisplayed++;
            }
        }
        if (numberOfNullCardsNotDisplayed > 0) {
            System.out.println("\nThere were " + numberOfNullCardsNotDisplayed +
                    " null cards that wasn't displayed ");
        }
    }

    public void displayAllAddressesDetails() {
        int numberOfNullCardsNotDisplayed = 0;
        System.out.println("All available addresses are:");
        for (int i = 0; i < numberOfAddress; i++) {
            try {
                System.out.println(addressList[i].toString());
            } catch (NullPointerException e) {
                numberOfNullCardsNotDisplayed++;
            }
        }
        if (numberOfNullCardsNotDisplayed > 0) {
            System.out.println("\nThere were " + numberOfNullCardsNotDisplayed +
                    " null addresses that wasn't displayed ");
        }
    }

    //getter/setter
    public Card[] getCardList() {
        return cardList;
    }

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

    public Address getCurrentBillingAddress() {
        return currentBillingAddress;
    }

    public void setCurrentBillingAddress(Address currentBillingAddress) {
        this.currentBillingAddress = currentBillingAddress;
    }


}