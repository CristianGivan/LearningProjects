package P07_OnlineShop;

import P07_OnlineShop.Exceptions.*;

import java.util.Scanner;
import java.util.SortedMap;

public class Shop {

    public static void main(String[] args) {
        Menu menu = new Menu();
        //test(init());
        toDOInMenu(menu, 1, init());
    }

    public static void test(ShoppingAccount account) {
        Card card;
        DebitCard debitCard;
        CreditCard creditCard;
        int select;
        do {
            System.out.println("\n Select the card:");
            select = numberTypedByUser();
            card = account.getCardList()[select];
            //debitCard = (DebitCard) card;
            //creditCard = (CreditCard) card;
            //debug
            if (card instanceof DebitCard) {
                System.out.println("is a debit card");
                debitCard = (DebitCard) card;
            }
            if (card instanceof CreditCard) {
                System.out.println("is a credit card");
                creditCard = (CreditCard) card;
            }
            if (card instanceof Card) {
                System.out.println("is a Card");
            }

        } while (select != 0);
    }

    public static void toDOInMenu(Menu menu, int menuNumber, ShoppingAccount account) {
        int choice = 0;
        int previousChose = 0;
        boolean redoAction = false;
        boolean isMenuChanged = false;
        String[] menuList = new String[0];
        Card card = new Card(true, 1111, 12344321, "Popescu Ioan", 1000);
        do {
            if (!redoAction) {
                switch (menuNumber) {
                    case 1:
                        menuList = menu.getMainMenu();
                        break;
                    case 2:
                        menuList = menu.getMenu2();
                        break;
                    default:
                        System.out.println("error");
                        break;
                }
                displayMenu(menu.getTypeIn(), menuList);
                System.out.println("\nYour chose is:");
                choice = numberTypedByUser();
            }
            switch (menuNumber) {
                case 1:
                    choseInMainMenu(menu, choice, account);
                    break;
                case 2:
                    choseInSecondMenu(menu, choice, account);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            previousChose = choice;
            System.out.println("\nType " + previousChose + " to redo the action" +
                    ", type 0 to exit from current manu" +
                    " or type any other number to return to the manu!\n");
            choice = numberTypedByUser();
            if (choice == 0 & menuNumber != 0) {
                choice = -1;
                menuNumber = 1;
                redoAction = false;

            } else {
                if (choice == previousChose) {
                    redoAction = true;
                } else {
                    redoAction = false;
                }
            }
        } while (choice != 0);
    }

    // login meniu
    public static void choseInMainMenu(Menu menu, int choice, ShoppingAccount account) {
        String[] menuList = menu.getMainMenu();

        switch (choice) {
            case 0:
                System.out.println("You choice to exit, bye!");
                break;
            case 1:
                System.out.println("You chose to " + menuList[1] + "\n");
                toDOInMenu(menu, 2, account);
                break;
            default:
                System.out.println("Unexpected chose, please try again from 0 to " +
                        (menu.getMainMenu().length - 1) + " or type 0 to exit");
                break;
        }
    }

    public static void choseInSecondMenu(Menu menu, int choice, ShoppingAccount account) {
        String[] menuList = menu.getMenu2();
        Card card;

        switch (choice) {
            case 0:
                System.out.println("You choice to return to the main menu.\n");
                toDOInMenu(menu, 1, account);
                break;
            case 1:
                // Change PIN
                changePin(menu, account);
                break;
            case 2:
                //frez the card
                freezeCard(menu, account);
                break;
            case 3:
                //pay
                System.out.println("You chose to " + menuList[3] + "\n");
                pay(menu, account, paymentAmount());
                break;
            case 4:
                // display all cards of the account
                account.displayAllCardsDetails();
                break;
            case 5:
                //display all addresses of the account
                account.displayAllAddressesDetails();
                break;
            case 6:
                //insert a new payment method
                insertNewCard(account);
                break;
            case 7:
                //delete a card from card list
                //todo test the second deletion
                deleteTheCardByNumber(account);
                break;
            case 8:
                //display the payment method
                displayPaymentMethod(menu, account);
                break;
            case 9:
                //select the payment method
                try {
                    selectPaymentMethod(menu, account);
                } catch (CardNotFound e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 10:
                // generate invoice
                generateInvoice(menu, account);
                break;
            case 11:
                test(account);
                break;

            default:
                System.out.println("Unexpected chose, please try again from 0 to " +
                        (menu.getMainMenu().length - 1) + " or type 0 to exit");
                break;
        }
    }

    public static void generateInvoice(Menu menu, ShoppingAccount account) {
        String[] menuList = menu.getMenu2();
        System.out.println("You chose to " + menuList[10] + "\n");
        int amount = paymentAmount();
        pay(menu, account, amount);
        System.out.println(account.generateReceipt(amount));
    }

    public static void displayPaymentMethod(Menu menu, ShoppingAccount account) {
        String[] menuList = menu.getMenu2();
        System.out.println("You chose to " + menuList[8] + "\n");
        System.out.println("The current payment method is:");
        System.out.println(account.getCurrentPaymentMethod().toString());
    }

    public static void selectPaymentMethod(Menu menu, ShoppingAccount account) throws CardNotFound {
        Card card;
        String[] menuList = menu.getMenu2();
        System.out.println("You chose to " + menuList[8] + "\n");
        account.selectPaymentMethod(findIndexOfCardByNumber(account));
        System.out.println("The payment method was change the current payment method is:");
        System.out.println(account.getCurrentPaymentMethod().toString());

        //todo also the case below coud be relevant bat not in this case
       /* try {
            account.selectPaymentMethod(findIndexOfCardByNumber(account));
            System.out.println("The payment method was change the current payment method is:");
            System.out.println(account.getCurrentPaymentMethod().toString());
        } catch (CardNotFound e) {
            //todo am facut bine ca am si tratat err dar am si dat-o mai departe
            //ar trebui sa sterg de aici try catch
            throw new CardNotFound("The card wasn't found!");
        }*/
    }

    public static void freezeCard(Menu menu, ShoppingAccount account) {
        String[] menuList = menu.getMenu2();
        Card card;
        System.out.println("You chose to " + menuList[2] + "\n");
        try {
            card = selectCardByNumber(account);
            if (cardIsVerifiedSuccessful(card)) {
                try {
                    card.freezeCard();
                    System.out.println("the card is now inactive");
                } catch (CardInactive e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (CardNotFound e) {
            System.out.println("The card wasn't found!");
        }
    }

    public static void changePin(Menu menu, ShoppingAccount account) {

        String[] menuList = menu.getMenu2();
        Card card;
        System.out.println("You chose to " + menuList[1] + "\n");
        int newPin;
        try {
            card = selectCardByNumber(account);
            if (cardIsVerifiedSuccessful(card)) {
                System.out.println("insert the new pin");
                newPin = numberTypedByUser();
                card.setPin(newPin);
            } else {
                System.out.println("You inserted the wrong pin to many times");
            }
        } catch (CardNotFound e) {
            System.out.println("The card wasn't found!");
        }
    }

    public static int paymentAmount() {
        int amount;
        System.out.println("Specify the amount:");
        amount = numberTypedByUser();
        return amount;
    }

    public static void pay(Menu menu, ShoppingAccount account, int amount) {

        Card card;
        CreditCard creditCard = null;
        DebitCard debitCard = null;
        int numberOfTries = 0;
        int selected;
        int amountAdded;

        try {
            System.out.println("Do you want to use the current payment methode or do you want to use " +
                    "other payment method");
            System.out.println("Type 1 to change the current payment method");
            System.out.println("Type 2 or other number to use the current payment method");
            selected = numberTypedByUser();
            if (selected == 1) {
                selectPaymentMethod(menu, account);
            }
            card = account.getCurrentPaymentMethod();

            //debug
            if (card instanceof DebitCard) {
                debitCard = (DebitCard) card;
            }
            if (card instanceof CreditCard) {
                creditCard = (CreditCard) card;
            }
            do {
                try {
                    //System.out.println("The amount before payment is: " + card.getCardBalance());
                    card.pay(amount);
                    System.out.println("The amount after payment is: " + card.getCardBalance());
                    numberOfTries = 0;
                } catch (NotEnoughMoneyAvailable e) {
                    System.out.println(e.getMessage());
                    catchNotEnoughMoneyAvailable(amount, card);
                } catch (AmountAndOverDraftExecuted e) {
                    //for the future it can be modified to modify over drift
                    //now you can modify oly the balance
                    System.out.println(e.getMessage());
                    catchMaximTransactionAmountExceeded(amount, creditCard);
                } catch (MaximTransactionAmountExceeded e) {
                    System.out.println(e.getMessage());
                    catchMaximTransactionAmountExceeded(amount, debitCard);
                }
            } while (numberOfTries > 0);
        } catch (CardNotFound e) {
            System.out.println("The card wasn't found!");
        }
    }

    public static int catchMaximTransactionAmountExceeded(int amount, DebitCard debitCard) {
        int selected;
        int amountAdded;
        int numberOfTries;

        System.out.println("What do you want to do? You can: ");
        System.out.println("Type 0 to exit\nType 1 to increase maximum amount for" +
                " a transaction and try again");
        selected = numberTypedByUser();
        if (selected == 0) {
            numberOfTries = 0;
            System.out.println("\nBye bye");
        } else if (selected == 1) {
            //todo decide if is needed to add or to insert de maximum value
            System.out.println("How much do you want to increase maximum amount " +
                    "for a transaction," + " you need at list " +
                    (amount - debitCard.getMaxTransactionAmount()));
            amountAdded = numberTypedByUser();
            int addMax = debitCard.getMaxTransactionAmount() + amountAdded;
            debitCard.setMaxTransactionAmount(addMax);
            numberOfTries = 1;
        } else {
            numberOfTries = 0;
            System.out.println("\nYour selection is not valid!");
        }

        return numberOfTries;
    }

    public static int catchMaximTransactionAmountExceeded(int amount, CreditCard creditCard) {
        int selected;
        int amountAdded;
        int numberOfTries;

        System.out.println("What do you want to do? You can: ");
        System.out.println("Type 0 to exit\nType 1 to add money in balance and try again");
        selected = numberTypedByUser();
        if (selected == 0) {
            numberOfTries = 0;
            System.out.println("\nBye bye");
        } else if (selected == 1) {
            System.out.println("How much do you want to add to your balance," +
                    " you need at list " + (amount - creditCard.getCardBalance()));
            amountAdded = numberTypedByUser();
            creditCard.setCardBalance(creditCard.getCardBalance() + amountAdded);
            numberOfTries = 1;
        } else {
            numberOfTries = 0;
            System.out.println("\nYour selection is not valid!");
        }
        return numberOfTries;
    }

    public static int catchNotEnoughMoneyAvailable(int amount, Card card) {
        int selected;
        int amountAdded;
        int numberOfTries;

        System.out.println("What do you want to do? You can: ");
        System.out.println("Type 0 to exit\nType 1 to add money in balance and try again");
        selected = numberTypedByUser();
        if (selected == 0) {
            numberOfTries = 0;
            System.out.println("\nBye bye");
        } else if (selected == 1) {
            System.out.println("How much do you want to add to your balance," +
                    " you need at list " + (amount - card.getCardBalance()));
            amountAdded = numberTypedByUser();
            card.setCardBalance(card.getCardBalance() + amountAdded);
            numberOfTries = 1;
        } else {
            numberOfTries = 0;
            System.out.println("\nYour selection is not valid!");
        }
        return numberOfTries;
    }

    public static void insertNewCard(ShoppingAccount account) {
        int selected;
        System.out.println("Do you want to include a credit card or a debit card");
        System.out.println("Type 0 to exit");
        System.out.println("Type 1 to insert a credit card");
        System.out.println("Type 2 to insert a debit card");
        selected = numberTypedByUser();
        switch (selected) {
            case 0:
                System.out.println("\nBye bye");
                break;
            case 1:
                //todo treat ArrayIndexOutOfBoundsException
                System.out.println("You choose to insert a credit card");
                account.addPaymentMethod(createNewCreditCard());
                break;
            case 2:
                //todo treat ArrayIndexOutOfBoundsException
                System.out.println("You choose to insert a debit card");
                account.addPaymentMethod(createNewDebitCard());
                break;
            default:
                System.out.println("Your choose is not valid");
                break;
        }
    }

    public static CreditCard createNewCreditCard() {
        //todo verify that the values inserted by user are valide
        long cardNumber;
        int pin;
        int balance;
        int maxOverDraft;
        String cardHolderName;

        System.out.println("To insert a new credit card you have to specify:");
        //todo the card number can be randomly generated
        System.out.println("\nInsert the card number:");
        cardNumber = numberTypedByUser();
        System.out.println("\nInsert a pin for the card:");
        pin = numberTypedByUser();
        System.out.println("\nInsert the card holder name:");
        cardHolderName = textTypedByUser();
        System.out.println("\nInsert the balance for this card:");
        balance = numberTypedByUser();
        System.out.println("\nInsert the maximum over draft");
        maxOverDraft = numberTypedByUser();

        // all the cards are active by default
        CreditCard creditCard = new CreditCard(true, pin, cardNumber, cardHolderName, balance,
                maxOverDraft);
        return creditCard;
    }

    public static DebitCard createNewDebitCard() {
        //todo verify that the user inserted valid values
        long cardNumber;
        int pin;
        int balance;
        int maxTransactionAmount;
        String cardHolderName;

        System.out.println("To insert a new credit card you have to specify:");
        //todo the card number can be randomly generated
        System.out.println("\nInsert the card number:");
        cardNumber = numberTypedByUser();
        System.out.println("\nInsert a pin for the card:");
        pin = numberTypedByUser();
        System.out.println("\nInsert the card holder name:");
        cardHolderName = textTypedByUser();
        System.out.println("\nInsert the balance for this card:");
        balance = numberTypedByUser();
        System.out.println("\nInsert the maximum over draft");
        maxTransactionAmount = numberTypedByUser();

        // all the cards are active by default
        DebitCard debitCard = new DebitCard(true, pin, cardNumber, cardHolderName, balance,
                maxTransactionAmount);
        return debitCard;
    }

    public static void deleteTheCardByNumber(ShoppingAccount account) {
        int cardIndex = 0;
        try {
            cardIndex = findIndexOfCardByNumber(account);
            account.deletePaymentMethod(cardIndex);
            System.out.println("The card number " + cardIndex + " was deleted");
        } catch (CardNotFound e) {
            //System.out.println(e.getMessage());
            System.out.println("The card wasn't found!");
        }
    }

    public static Card selectCardByNumber(ShoppingAccount account) throws CardNotFound {
        int cardIndex = 0;
        try {
            cardIndex = findIndexOfCardByNumber(account);
            return account.getCardList()[cardIndex];
        } catch (CardNotFound e) {
            throw new CardNotFound("The card wasn't found!");
        }
    }

    public static int findIndexOfCardByNumber(ShoppingAccount account) throws CardNotFound {
        int numberOfTries = 3;
        int cardIndex = -1;
        long cardNumber;

        do {
            account.displayAllCardsDetails();
            System.out.println("\nType the number of the card that you want to select from the list:");
            cardNumber = numberTypedByUser();
            //todo is this the best plice for try catch?
            try {
                cardIndex = account.findCardIndex(cardNumber);
                System.out.println("You selected the card with the index: " + cardIndex);
                numberOfTries = 0;
            } catch (CardNotFound e) {
                numberOfTries--;
                if (numberOfTries == 0) {
                    System.out.println("You tries to many times, you cannot try anymore");
                    throw new CardNotFound("Card not found");
                } else {
                    System.out.println("The card wasn't fond, you have " + (numberOfTries)
                            + " more tries.");
                    System.out.println("What do you want to do? You can: ");
                    System.out.println("Type 0 to exit\nType 1 to try again");
                    //todo treat the values <> 0 1

                    if (numberTypedByUser() == 0) {
                        numberOfTries = 0;
                        System.out.println("\nBye bye");
                        throw new CardNotFound("The card wasn't found!");
                    }
                }
            }

        } while (numberOfTries > 0);
        return cardIndex;
    }

    public static boolean cardIsVerifiedSuccessful(Card card) {
        int pin;

        int numberOfTries = 3;
        while (numberOfTries > 0) {
            System.out.println("insert the pin for verification");
            pin = numberTypedByUser();

            if (card.isPinCorect(pin)) {
                return true;
            } else {
                if (numberOfTries == 0) {
                    break;
                }
                numberOfTries--;
                System.out.println("you inserted the wrong pin, you can retry " + numberOfTries + " more times\n");
            }
        }
        return false;
    }

    public static void displayMenu(String[] typeIn, String[] menu) {
        System.out.println("Select from 0 to " + (menu.length - 1) + " from the to options: \n");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(typeIn[i] + menu[i]);
        }
    }

    public static String textTypedByUser() {
        //todo treat exceptions
        Scanner console = new Scanner(System.in);
        return console.nextLine();
    }

    public static int numberTypedByUser() {
        Scanner console = new Scanner(System.in);
        int numberTyped = -1;
        int numberOfTries = 3;
        do {
            try {
                numberTyped = Integer.parseInt(console.nextLine());
                numberOfTries = 0;
            } catch (NumberFormatException e) {
                numberOfTries--;
                if (numberOfTries == 0) {
                    System.out.println("You tried to many time, bye");
                } else {
                    System.out.println("You didn't typed a number, you have " + numberOfTries + " to type the desired number");
                }
            }
        } while (numberOfTries != 0);
        //console.close();
        return numberTyped;
    }

    public static ShoppingAccount init() {
        int maxNumberOfCards = 10;
        int maxNumberOfAddresses = 10;

        Address address1 = new Address("a1", "s1", "st1", 1);
        Address address2 = new Address("a2", "s2", "st2", 2);
        Address address3 = new Address("a3", "s3", "st3", 3);
        Address address4 = new Address("a4", "s4", "st4", 4);
        Address address5 = new Address("a5", "s5", "st5", 5);


        Address[] addresses = new Address[maxNumberOfAddresses];
        addresses[0] = address1;
        addresses[1] = address2;
        addresses[3] = address4;
        addresses[4] = address5;
        addresses[2] = address3;

        Card card = new Card(true, 1, 1, "Popescu Ioan", 1000);
        Card card1 = new Card(true, 5, 5, "Pop", 1000);
        CreditCard creditCard = new CreditCard(true, 2, 2, "Test1", 1200, 500);
        DebitCard debitCard = new DebitCard(true, 3, 3, "Test12", 1200, 500);
        Card nullCard = new Card(true, 0, 0, "", 0);
        Card[] cards = new Card[maxNumberOfCards];
        cards[0] = card;
        cards[1] = creditCard;
        cards[3] = debitCard;
        cards[4] = nullCard;
        cards[2] = card1;

        ShoppingAccount account = new ShoppingAccount(cards, addresses, "email1", "password",
                "Prenume", "Nume", card, address1);
        return account;
    }
}