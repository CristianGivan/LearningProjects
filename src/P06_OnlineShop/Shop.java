import P06_OnlineShop.Address;
import P06_OnlineShop.Card;
import P06_OnlineShop.Exceptions.AmountAndOverDraftExecuted;
import P06_OnlineShop.Exceptions.NotEnoughMoneyAvailable;
import P06_OnlineShop.ShoppingAccount;

public class Shop {

    //NotEnoughMone cancel the transaction pay less then tbd(show the maximum amout alowed)
    public static void main(String[] args) {
        ShoppingAccount account = new ShoppingAccount();
        Address address=new Address();
        Card card=new Card();
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
}