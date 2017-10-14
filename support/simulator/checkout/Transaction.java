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
  private final int timesteps;

  /**
   * Creates a {@link Transaction} for with the specified receipt at the
   * specified startTime for the specified shopper taking the specified time of transaction.
   * @param r the receipt associated with this {@link Transaction}
   * @param s the shopper associated with this {@link Transaction}
   * @param st the time when this {@link Transaction} was created
   * @param ts the number of time steps to complete this {@link Transaction}
   * @throws NullPointerException if {@code receipt} or {@code shopper} are {@code null}
   * @throws IllegalArgumentException if {@code time} is less than 1.
   */
  public Transaction(final AbstractReceipt r, final Shopper s, final int st, final int ts) {
    if (r == null || s == null) {
      throw new NullPointerException("Receipt and Shopper must be non-null");
    }
    if (ts < 1) {
      throw new IllegalArgumentException("Cannot perform transaction in less than 1 time step.");
    }
    this.receipt = r;
    this.shopper = s;
    this.startTime = st;
    this.timesteps = ts;
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
    return timesteps;
  }

  /**
   * Returns the time when this {@link Transaction} was created.
   * @return the time when this {@link Transaction} was created.
   */
  public int getStartTime() {
    return startTime;
  }

}
