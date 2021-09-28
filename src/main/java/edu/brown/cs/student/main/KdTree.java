package edu.brown.cs.student.main;

public class KdTree implements ProjectDataStructure { //extends ProjectDataStructure --> see ProjectDataStructure.java

  private int k;

  public KdTree(int k) {
    k = k;
  }

  public boolean containsData() {
    return false;
  }

  public void loadDataSql(String pathToDb) {

  }

  public void loadDataJson(String pathToJson) {

  }

  public void loadFromOnline() {

  }

  public void similarToId(int userId) {

  }

  public void similarToCoords(int weight, int height, int age) {

  }

  public void classifyId(int userId) {
    System.out.println("classifyId" + Integer.toString(userId));
  }

  public void classifyCoords(int weight, int height, int age) {

  }
}
