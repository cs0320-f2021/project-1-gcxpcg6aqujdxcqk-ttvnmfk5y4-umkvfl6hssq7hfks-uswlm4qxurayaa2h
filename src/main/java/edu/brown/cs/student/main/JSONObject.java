package edu.brown.cs.student.main;

public interface JSONObject {
  public int getId();
  public int[] getCoordinates();
  boolean equals(Object o);
  int hashCode();

}