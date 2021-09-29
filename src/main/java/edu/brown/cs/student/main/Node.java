package edu.brown.cs.student.main;

public class Node {
  private int[] coordinates;
  private Node parent;
  private Node lchild;
  private Node rchild;

  public Node(int k) {
    coordinates = new int[k];
    parent = null;
    lchild = null;
    rchild = null;
  }

  public int[] getCoordinates() {
    return coordinates;
  }

  //euclidean distance
  public Double getDistanceFrom(Node otherNode) {
    int[] otherCoords = otherNode.getCoordinates();
    if (otherCoords.length != coordinates.length) {
      //TODO
    }
    return 0.0;
  }

  //function that compares to another node and returns correct child

}
