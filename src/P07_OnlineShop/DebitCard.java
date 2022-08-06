package P07_OnlineShop;

import P07_OnlineShop.Card;
import P07_OnlineShop.Exceptions.MaximTransactionAmountExceeded;
import P07_OnlineShop.Exceptions.NotEnoughMoneyAvailable;
import P07_OnlineShop.Payable;

public class DebitCard extends Card implements Payable {


  private int maxTransactionAmount;
  private int getCardBalace;

  public DebitCard (boolean isActive, short pin, long cardNumber, String cardHolderName,
                    int cardBalance, int maxTransactionAmount) {
    super(isActive, pin, cardNumber, cardHolderName, cardBalance);
    this.maxTransactionAmount=maxTransactionAmount;
  }

  public int getMaxTransactionAmount() {
    return maxTransactionAmount;
  }

  public void setMaxTransactionAmount(int newMaxTransactionAmount) {

  }

  public int pay(int amount) throws NotEnoughMoneyAvailable, MaximTransactionAmountExceeded {
    int amountAvailable = 0;
    if(amount>this.getCardBalace) {
      //treat the exception in Shop
      amountAvailable = this.getCardBalace;
      throw new NotEnoughMoneyAvailable("Not enough money!");// this masage is check if

    }
    else if (amount>this.maxTransactionAmount){
      //treat the exception in Shop
      amountAvailable=this.maxTransactionAmount;
      throw new MaximTransactionAmountExceeded("The maximum amount for a transaction was excceded!");

    } 
    this.setCardBalance(this.getCardBalance()-amount);
    return amountAvailable;
  }

}