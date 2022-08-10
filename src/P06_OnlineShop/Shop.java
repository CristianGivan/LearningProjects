import P06_OnlineShop.Address;
import P06_OnlineShop.Menu;
import P06_OnlineShop.ShoppingAccount;

import java.util.Scanner;

public class Shop {

    //NotEnoughMone cancel the transaction pay less then tbd(show the maximum amout alowed)
  /*
    public static void main(String[] args) {
        ShoppingAccount account = new ShoppingAccount();
        Address address = new Address();
        Card card = new Card();
        int option = 0;
        do {

            try {

                account.generateReceipt();
            } catch (NotEnoughMoneyAvailable e) {
                System.out.println(e.getMessage());
                "You can chose from following options:"
                "type 0 to cancel the transaction"
                "type 1 to add more money in your bank acount"
                option = console;
                if (option = 0) {
                    "you chuse to..."

                } else if (option = 2) {
                    "you choose to..."
                }
            } catch (NotEnoughMoneyAvailable e) {
                "You can chose from following options:"
                "type 0 to cancel the transaction"
                "type 1 to add more increase the maximum transaction amount"
            } catch (AmountAndOverDraftExecuted e) {
                "You can chose from following options:"
                "type 0 to cancel the transaction"
                "type 1 to add more increase the over Draft amount"
            }
            while (option != 0) ;

        }
    }
*/
    public static void main(String[] args) {
        Menu menu = new Menu();
        init();
        toDOInMenu(menu, 1);

    }

    public static void toDOInMenu(Menu menu, int menuNumber) {
        int choice = 0;
        int previousChose = 0;
        boolean redoAction = false;
        boolean isMenuChanged = false;
        String[] menuList = new String[0];

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
                    choseInMainMenu(menu, choice);
                    break;
                case 2:
                    choseInSecondMenu(menu, choice);
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

    public static void choseInMainMenu(Menu menu, int choice) {
       String[] menuList = menu.getMainMenu();

        switch (choice) {
            case 0:
                System.out.println("You choice to exit, bye!");

                break;
            case 1:
                System.out.println("You chose to " + menuList[1] + "\n");
                toDOInMenu(menu, 2);

                break;
            case 2:
                System.out.println("You chose to " + menuList[2] + "\n");

                break;
            case 3:
                System.out.println("You chose to " + menuList[3] + "\n");

                break;
            default:
                System.out.println("Unexpected chose, please try again from 0 to " +
                        (menu.getMainMenu().length - 1) + " or type 0 to exit");

                break;
        }
    }

    public static void choseInSecondMenu(Menu menu, int choice) {
        String[] menuList = menu.getMenu2();

        switch (choice) {
            case 0:
                System.out.println("You choice to return to the main menu.\n");
                toDOInMenu(menu, 1);
                break;
            case 1:
                System.out.println("You chose to " + menuList[1] + "\n");

                break;
            case 2:
                System.out.println("You chose to " + menuList[2] + "\n");

                break;
            case 3:
                System.out.println("You chose to " + menuList[3] + "\n");

                break;
            default:
                System.out.println("Unexpected chose, please try again from 0 to " +
                        (menu.getMainMenu().length - 1) + " or type 0 to exit");

                break;
        }
    }

    public static void displayMenu(String[] typeIn, String[] menu) {
        System.out.println("Select from 0 to " + (menu.length - 1) + " from the to options: \n");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(typeIn[i] + menu[i]);
        }
    }

    public static String textTypedByUser(Scanner console1) {
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


    public static void init() {
        ShoppingAccount account = new ShoppingAccount();
        Address address = new Address();
        //Card card = new Card();
    }
}