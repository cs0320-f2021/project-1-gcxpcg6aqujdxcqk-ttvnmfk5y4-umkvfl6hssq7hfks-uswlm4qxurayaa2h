package edu.brown.cs.student.jsonobjects;

public interface JSONObject {
  public int getId();
  public int[] getUserCoordinates();
  boolean equals(Object o);
  int hashCode();

}