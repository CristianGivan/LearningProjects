package P06_OnlineShop;

import P06_OnlineShop.Exceptions.AmountAndOverDraftExecuted;

public class CreditCard extends Card implements Payable {

  private int maxOverDraft;


  public CreditCard(boolean isActive, short pin, long cardNumber, String cardHolderName, int cardBalance, int maxOverDraft) {
    super(isActive, pin, cardNumber, cardHolderName, cardBalance);
    this.maxOverDraft=maxOverDraft;
  }

  public int getMaxOverDraft() {
    return maxOverDraft;
  }

  public void setMaxOverDraft(int maxOverDraft) {
    this.maxOverDraft = maxOverDraft;
  }

  public void setMaxTransactionAmount(int newMaxTransactionAmount){
  
}
  
  public int pay(int amount) throws AmountAndOverDraftExecuted {
    if (amount>this.maxOverDraft+this.getCardBalance()){
      //treat the exception in Shop
      throw new AmountAndOverDraftExecuted("Not enough money! Also the overdraft amount was exceeded ");
    }
    this.setCardBalance(this.getCardBalance()-amount);
    return this.maxOverDraft+this.getCardBalance();
  }























}