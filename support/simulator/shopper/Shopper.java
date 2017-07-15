package simulator.shopper;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import simulator.checkout.CheckoutLineInterface;
import simulator.grocery.GroceryInterface;

/**
 * A {@link Shopper} contains a list of {@link GroceryInterface} items that they
 * wish to purchase from a store.
 * 
 * @author jcollard, jddevaug
 * 
 */
public class Shopper {

  private static int nextID;
  private final int time;
  private final int uniqueID;
  private final List<GroceryInterface> groceries;

  /**
   * Creates a new {@link Shopper} that has a unique ID that no previously
   * created {@link Shopper} has. The created {@link Shopper}'s shopping list
   * will be a copy of the list specified.
   * 
   * @param groceries
   *            the shoppers grocery list
   * @param time
   *            the time this {@link Shopper} entered the store
   * @throws NullPointerException
   *             if {@code groceries} is {@code null}
   */
  public Shopper(List<GroceryInterface> groceries, int time) {
    if (groceries == null) {
      throw new NullPointerException();
    }
    this.uniqueID = nextID++;
    this.time = time;
    this.groceries = Collections
        .unmodifiableList(new LinkedList<GroceryInterface>(groceries));
  }

  /**
   * Returns a uniquely identifying integer for this {@link Shopper}.
   * 
   * @return a uniquely identifying integer for this {@link Shopper}
   */
  public final int getUniqueID() {
    return uniqueID;
  }

  /**
   * Returns an immutable {@link List} containing this {@link Shopper}'s
   * grocery items.
   * 
   * @return an immutable {@link List} containing this {@link Shopper}'s
   *         grocery items
   */
  public final List<GroceryInterface> getShoppingList() {
    return groceries;
  }

  /**
   * Returns the time this {@link Shopper} entered the store.
   * @return the time this {@link Shopper} entered the store
   */
  public final int getTime() {
    return time;
  }

  /**
   * Given a {@link List} of {@link CheckoutLineInterface}'s, this
   * {@link Shopper} may choose to add itself to the line. This method returns
   * {@code true} if the {@link Shopper} entered a line and {@code false} if
   * the shopper did not select a line.
   * 
   * @param lines the {@link List} of {@link CheckoutLineInterface} for the store
   * @return whether or not the shopper entered a line
   */
  public boolean selectLine(List<CheckoutLineInterface> lines) {
    for (CheckoutLineInterface line : lines) {
      if (line.canEnterLine(this)) {
        line.enqueue(this);
        return true;
      }
    }
    return false;
  }

}
