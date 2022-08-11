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
        findNumberOfValidCards();
        findNumberOfValidAddresses();
    }


    // trebuie sa setez by defoult un cad si o addres la initializarea
    public void addPaymentMethod(Card card) {
        // TODO check if the card is not null

        //todo cred ca trebuie dupa ce adaug
        cardList[numberOfCards] = card;
        numberOfCards++;
    }

    public void deletePaymentMethod(int cardIndex) {
        //int cardIndex = findCardIndex(cardNumber);
        for (int i = cardIndex + 1; i < cardList.length; i++) {
            cardList[i - 1] = cardList[i];
        }
    }

    public void selectPaymentMethod(int cardIndex)  {
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
        //todo sa verific unde trebuie sa pun +1
        if (numberOfCards == lastNotNull+1) {
            return true;
        } else {
            numberOfCards = lastNotNull+1;
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
        if (numberOfAddress == lastNotNull+1) {
            return true;
        } else {
            numberOfAddress = lastNotNull+1;
            return false;
        }
    }
    public int findCardIndex(long cardNumber) throws CardNotFound{
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

    //similar si la addresslist
    public void generateReceipt(int amount, Card card, Address address) {
        System.out.println(this.firstName + " " + this.lastname + " payed " + amount +
                "using the card with the number" + card.getCardNumber() +
                " with the address str. " + address.getStreet() + " Nr. " + address.getNumber() +
                " city " + address.getCity());
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