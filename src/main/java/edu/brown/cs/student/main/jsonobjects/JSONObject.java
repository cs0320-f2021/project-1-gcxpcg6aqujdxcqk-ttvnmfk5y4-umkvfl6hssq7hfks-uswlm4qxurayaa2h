package edu.brown.cs.student.main.jsonobjects;

/**
 * This interface ensures that all JSONObjects have the same essential methods.
 */
public interface JSONObject {
  int getId();

  int[] getUserCoordinates();

  boolean equals(Object o);

  int hashCode();
}
