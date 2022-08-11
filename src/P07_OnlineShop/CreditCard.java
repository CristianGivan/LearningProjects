package P07_OnlineShop;

import P07_OnlineShop.Exceptions.AmountAndOverDraftExecuted;

public class CreditCard extends Card implements Payable {

  private int maxOverDraft;


  public CreditCard(boolean isActive, int pin, long cardNumber, String cardHolderName, int cardBalance, int maxOverDraft) {
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

  @Override
  public String toString() {
    return "CreditCard{" +
            "isActive=" + this.getIsActive() +
            ", cardNumber=" + this.getCardNumber() +
            ", cardHolderName='" + this.getCardHolderName() + '\'' +
            ", cardBalance=" + this.getCardBalance() +
            ", maxOverDraft=" + maxOverDraft +
            '}';
  }
}