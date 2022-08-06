package P07_OnlineShop;

import P07_OnlineShop.Exceptions.AmountAndOverDraftExecuted;
import P07_OnlineShop.Exceptions.MaximTransactionAmountExceeded;
import P07_OnlineShop.Exceptions.NotEnoughMoneyAvailable;

public interface Payable {
  public int pay(int amount) throws AmountAndOverDraftExecuted, NotEnoughMoneyAvailable, MaximTransactionAmountExceeded;
}