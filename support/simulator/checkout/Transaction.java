package simulator.checkout;

import simulator.shopper.Shopper;

/**
 * A {@link Transaction} contains a receipt for a shopper and the amount.
 * of time it took to complete a transaction
 * @author jcollard, jddevaug
 *
 */
public final class Transaction {

  /**
   * The receipt associated with this {@link Transaction}.
   */
  private final AbstractReceipt receipt;
  /**
   * The shopper associated with this {@link Transaction}.
   */
  private final Shopper shopper;
  /**
   * The time when this {@link Transaction} was created.
   */
  private final int startTime;
  /**
   * The number of time steps to complete this {@link Transaction}.
   */
  private final int timeSteps;

  /**
   * Creates a {@link Transaction} for with the specified receipt at the
   * specified startTime for the specified shopper taking the specified time of transaction.
   * @param receipt the receipt associated with this {@link Transaction}
   * @param shopper the shopper associated with this {@link Transaction}
   * @param startTime the time when this {@link Transaction} was created
   * @param timeSteps the number of time steps to complete this {@link Transaction}
   * @throws NullPointerException if {@code receipt} or {@code shopper} are {@code null}
   * @throws IllegalArgumentException if {@code time} is less than 1.
   */
  public Transaction(final AbstractReceipt receipt, final Shopper shopper, 
      int startTime, int timeSteps) {
    if (receipt == null || shopper == null) {
      throw new NullPointerException("Receipt and Shopper must be non-null");
    }
    if (timeSteps < 1) {
      throw new IllegalArgumentException("Cannot perform transaction in less than 1 time step.");
    }
    this.receipt = receipt;
    this.shopper = shopper;
    this.startTime = startTime;
    this.timeSteps = timeSteps;
  }

  /**
   * Returns the {@link AbstractReceipt} for this {@link Transaction}.
   * @return the {@link AbstractReceipt} for this {@link Transaction}
   */
  public AbstractReceipt getReceipt() {
    return receipt;
  }

  /**
   * Returns the {@link Shopper} associated with this {@link Transaction}.
   * @return the {@link Shopper} associated with this {@link Transaction}
   */
  public Shopper getShopper() {
    return shopper;
  }

  /**
   * Returns the number of time steps required to complete this transaction. This number will
   * be greater than or equal to 1.
   * @return the number of time steps required to complete this transaction.
   */
  public int getTimeSteps() {
    return timeSteps;
  }

  /**
   * Returns the time when this {@link Transaction} was created.
   * @return the time when this {@link Transaction} was created.
   */
  public int getStartTime() {
    return startTime;
  }

}
