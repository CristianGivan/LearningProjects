package P07_OnlineShop;

import P07_OnlineShop.Exceptions.*;

import java.util.Scanner;

public class Shop {

    public static void main(String[] args) {
        Menu menu = new Menu();
        toDOInMenu(menu, 1, init());


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
                pay(menu, account);
                break;
            case 4:
                // display all cards of the account
                account.displayAllCardsDetails();
                break;
            case 5:
                //insert a new payment method
                insertNewCard(account);
                break;
            default:
                System.out.println("Unexpected chose, please try again from 0 to " +
                        (menu.getMainMenu().length - 1) + " or type 0 to exit");
                break;
        }
    }

    public static void freezeCard(Menu menu, ShoppingAccount account) {
        String[] menuList = menu.getMenu2();
        Card card;
        System.out.println("You chose to " + menuList[2] + "\n");
        card = selectCardByNumber(account);
        if (cardIsVerifiedSuccessful(card)) {
            try {
                card.freezeCard();
                System.out.println("the card is now inactive");
            } catch (CardInactive e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void changePin(Menu menu, ShoppingAccount account) {

        String[] menuList = menu.getMenu2();
        Card card;
        System.out.println("You chose to " + menuList[1] + "\n");
        int newPin;
        card = selectCardByNumber(account);
        if (cardIsVerifiedSuccessful(card)) {
            System.out.println("insert the new pin");
            newPin = numberTypedByUser();
            card.setPin(newPin);
        } else {
            System.out.println("You inserted the wrong pin to many times");
        }
    }

    public static void pay(Menu menu, ShoppingAccount account) {
        String[] menuList = menu.getMenu2();
        Card card;
        System.out.println("You chose to " + menuList[4] + "\n");
        //todo shopping card creation
        int amount;
        int numberOfTries = 0;
        int selected;
        int amountAdded;
        System.out.println("Specify the amount:");
        amount = numberTypedByUser();
        System.out.println("Select a card from which to pay:");
        card = selectCardByNumber(account);
        DebitCard debitCard = (DebitCard) card;
        CreditCard creditCard = (CreditCard) card;
        do {
            try {
                //System.out.println("The amount before payment is: " + card.getCardBalance());
                card.pay(amount);
                System.out.println("The amount after payment is: " + card.getCardBalance());
                numberOfTries = 0;
            } catch (NotEnoughMoneyAvailable e) {
                System.out.println(e.getMessage());
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
            } catch (AmountAndOverDraftExecuted e) {
                //for the future it can be modified to modify over drift
                //now you can modify oly the balance
                //noinspection DuplicatedCode
                System.out.println(e.getMessage());
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
            } catch (MaximTransactionAmountExceeded e) {
                System.out.println(e.getMessage());
                System.out.println("What do you want to do? You can: ");
                System.out.println("Type 0 to exit\nType 1 to increase maximum amount for a transaction and try again");
                selected = numberTypedByUser();
                if (selected == 0) {
                    numberOfTries = 0;
                    System.out.println("\nBye bye");
                } else if (selected == 1) {
                    //todo decide if is needed to add or to insert de maximum value
                    System.out.println("How much do you want to increase maximum amount for a transaction," +
                            " you need at list " + (amount - debitCard.getMaxTransactionAmount()));
                    amountAdded = numberTypedByUser();
                    int addMax = debitCard.getMaxTransactionAmount() + amountAdded;
                    debitCard.setMaxTransactionAmount(addMax);
                    numberOfTries = 1;
                } else {
                    numberOfTries = 0;
                    System.out.println("\nYour selection is not valid!");
                }
            }
        } while (numberOfTries > 0);
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
                System.out.println("You choose to insert a credit card");
                account.addPaymentMethod(createNewCreditCard());
                break;
            case 2:
                System.out.println("You choose to insert a debit card");
                account.addPaymentMethod(createNewDebitCard());
                break;
            default:
                System.out.println("Your choose is not valid");
                break;
        }
    }

    public static CreditCard createNewCreditCard() {
        //todo verify that the user inserted valid values
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

    public static Card selectCardByNumber(ShoppingAccount account) {
        Card card = new Card(true, 0, 0, "",
                0);
        int cardNumber;
        int numberOfTries = 3;

        do {
            account.displayAllCardsDetails();
            System.out.println("\nType the number of the card that you want to select from the list:");
            cardNumber = numberTypedByUser();
            try {
                card = account.findCardByNumber(cardNumber);
                System.out.println("You selected: " + card.toString());
                numberOfTries = 0;
            } catch (CardNotFound e) {
                numberOfTries--;
                if (numberOfTries == 0) {
                    System.out.println("You tries to many times, you cannot try anymore");
                } else {
                    System.out.println("The card wasn't fond you have " + (numberOfTries)
                            + " more tries.");
                    System.out.println("What do you want to do? You can: ");
                    System.out.println("Type 0 to exit\nType 1 to try again");
                    if (numberTypedByUser() == 0) {
                        numberOfTries = 0;
                        System.out.println("\nBye bye");
                    }
                }
                //todo it could be improve "default card"
                System.out.println("You remain with the the default card");
                System.out.println(card.toString());
            }

        } while (numberOfTries > 0);


        return card;
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
        int maxNumberOfCards=10;
        int maxNumberOfAddresses=10;

        Address address1 = new Address("a1", "s1", "st1", 1);
        Address address2 = new Address("a2", "s2", "st2", 2);
        Address[] addresses = new Address[maxNumberOfAddresses];
        addresses[0]=address1;
        addresses[1]=address2;

        Card card = new Card(true, 1, 1, "Popescu Ioan", 1000);
        CreditCard creditCard = new CreditCard(true, 2, 2, "Test1", 1200, 500);
        DebitCard debitCard = new DebitCard(true, 3, 3, "Test12", 1200, 500);
        Card nullCard = new Card(true, 0, 0, "", 0);
        Card[] cards = new Card[maxNumberOfCards];
        cards[0]=card;
        cards[1]=creditCard;
        cards[2]=debitCard;

        ShoppingAccount account = new ShoppingAccount(cards, addresses, "email1", "password",
                "lastName", "firstName", card, address1.getName());
        return account;
    }
}