package edu.brown.cs.student.main.jsonobjects;

import java.util.Objects;

/**
 * This is the Clothing class, which holds the data read from the JSON file.
 */
public class Clothing implements JSONObject {
  private final String fit;
  private final int user_id;
  private final int item_id;
  private final String rating;
  private final String rented_for;
  private final String category;
  private final int size;
  private final int id;

  /**
   * This is the constructor for the Clothing class.
   *
   * @param fit of the item
   * @param user_id of the customer
   * @param item_id of the customer
   * @param rating of the customer
   * @param category of the customer
   * @param size of the customer
   * @param id of the customer
   */
  public Clothing(String fit, int user_id, int item_id, String rating, String rented_for,
                  String category, int size, int id) {
    this.fit = fit;
    this.user_id = user_id;
    this.item_id = item_id;
    this.rating = rating;
    this.rented_for = rented_for;
    this.category = category;
    this.size = size;
    this.id = id;
  }

  /**
   * Gets the ID.
   *
   * @return id of Clothing
   */
  public int getId() {
    return id;
  }

  /**
   * Gets the three coordinates we're interested in in an array.
   *
   * @return null because this is not a User
   */
  public int[] getUserCoordinates() {
    return new int[]{};
  }

  /**
   * Equals method to ensure that hashset works properly.
   *
   * @param o object to compare to
   * @return boolean
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Clothing clothing = (Clothing) o;
    return user_id == clothing.user_id && item_id == clothing.item_id
        && size == clothing.size && id == clothing.id
        && Objects.equals(fit, clothing.fit)
        && Objects.equals(rating, clothing.rating)
        && Objects.equals(category, clothing.category);
  }

  /**
   * hashCode() method ensures proper hashing.
   *
   * @return integer hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(fit, user_id, item_id, rating, category, size, id);
  }
}
