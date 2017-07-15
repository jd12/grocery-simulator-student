package simulator.checkout;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import simulator.grocery.GroceryInterface;
import simulator.shopper.Shopper;

/**
 * <p>
 * A {@link AbstractRegister} is used to process {@link Shopper}s. A
 * {@link AbstractRegister} has a running cost associated with it. Each time a
 * {@link Shopper} is processed, a {@link AbstractRegister} will produce a
 * {@link Transaction}. The running cost of a register is associated with the
 * skill level of the employee working at the register. That means, the faster
 * the employee is able to process a transaction, the higher the running cost
 * will be.
 * </p>
 * <p>
 * To implement a {@link AbstractRegister} one must implement the
 * {@link AbstractRegister#createTransaction(Shopper)} method.
 * </p>
 * 
 * @author jcollard, jddevaug
 * 
 */
public abstract class AbstractRegister {

  private double runningCost = 0;
  private int runningTime = 0;
  private final List<Transaction> transactions = new LinkedList<Transaction>();

  /**
   * Processes a {@link Shopper} producing a {@link Transaction}. In addition
   * to processing the {@link Shopper} the running cost is increased relative
   * to the speed and difficulty of the groceries purchased by the
   * {@link Shopper}
   * 
   * @param s
   *            the shopper to process
   * @return a {@link Transaction} for this customer
   */
  public final Transaction processShopper(Shopper s) {
    if (s == null) {
      throw new NullPointerException();
    }

    checkRunningTime(s);
    Transaction t = createTransaction(s);

    if (t.getStartTime() != runningTime) {
      throw new IllegalStateException("The start time of the transaction does not match.");
    }

    double difficulty = 0.0;

    for (GroceryInterface g : t.getReceipt().getGroceries()) {
      difficulty += g.getHandlingRating();
    }

    // The faster the processing is completed, the more expensive
    // it is to run the register
    runningCost += (difficulty * 100)
        / (t.getTimeSteps() * t.getTimeSteps());

    // The base cost for running a register is 1 per timestep
    runningCost += t.getTimeSteps();

    runningTime += t.getTimeSteps();

    transactions.add(t);
    return t;
  }

  /**
   * Checks to see if this registers runningTime is less than the time
   * the specified shopper arrived. If it is, it advances to that time step.
   * @param s the shopper the register checks against
   */
  private final void checkRunningTime(Shopper s) {
    assert s != null;
    int difference = s.getTime() - runningTime;
    if (difference > 0) {
      runningTime += difference;
      // The base running cost for a register is 1 per timestep 
      runningCost += difference;
    }
  }

  /**
   * Returns the total running cost of this {@link AbstractRegister}.
   * 
   * @return the total running cost of this {@link AbstractRegister}
   */
  public final double getRunningCost() {
    return runningCost;
  }

  /**
   * Returns the running time of this {@link AbstractRegister}.
   * 
   * @return the running time of this {@link AbstractRegister}.
   */
  public final int getRunningTime() {
    return runningTime;
  }

  /**
   * Returns a {@link List} containing all transactions processed by this
   * {@link AbstractRegister}. The returned list is an immutable view.
   * 
   * @return a {@link List} containing all transactions processed by this
   *         {@link AbstractRegister}.
   */
  public final List<Transaction> getTransactions() {
    return Collections.unmodifiableList(transactions);
  }

  /**
   * This method determines how a {@link Transaction} is created when a
   * {@link Shopper} is processed.
   * 
   * @param s
   *            the shopper being processed
   * @return a {@link Transaction} for the shopper
   */
  protected abstract Transaction createTransaction(Shopper s);

}
