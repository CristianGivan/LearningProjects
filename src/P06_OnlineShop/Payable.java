package P06_OnlineShop;

import P06_OnlineShop.Exceptions.AmountAndOverDraftExecuted;
import P06_OnlineShop.Exceptions.MaximTransactionAmountExceeded;
import P06_OnlineShop.Exceptions.NotEnoughMoneyAvailable;

public interface Payable {
  public int pay(int amount) throws AmountAndOverDraftExecuted, NotEnoughMoneyAvailable, MaximTransactionAmountExceeded;
}