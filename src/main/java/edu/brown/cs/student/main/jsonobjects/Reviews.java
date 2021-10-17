package edu.brown.cs.student.main.jsonobjects;

import java.util.Objects;

/**
 * This is the Reviews class, which holds the data read from the JSON file.
 */
public class Reviews implements JSONObject {
  private final String review_text;
  private final String review_summary;
  private final String review_date;
  private final Integer id;

  /**
   * This is the constructor for the Clothing class.
   *
   * @param review_text of the review
   * @param review_summary of the review
   * @param review_date of the review
   * @param id of the review
   */
  public Reviews(String review_text, String review_summary,
                 String review_date, Number id) {
    this.review_text = review_text;
    this.review_summary = review_summary;
    this.review_date = review_date;
    this.id = id.intValue();
  }

  /**
   * Gets the ID.
   *
   * @return id of review
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
    Reviews reviews = (Reviews) o;
    return Objects.equals(review_text, reviews.review_text)
        && Objects.equals(review_summary, reviews.review_summary)
        && Objects.equals(review_date, reviews.review_date)
        && Objects.equals(id, reviews.id);
  }

  /**
   * hashCode() method ensures proper hashing.
   *
   * @return integer hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(review_text, review_summary, review_date, id);
  }
}
