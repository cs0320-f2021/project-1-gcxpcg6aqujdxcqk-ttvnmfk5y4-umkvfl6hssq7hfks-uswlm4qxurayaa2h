package edu.brown.cs.student.main;

import java.util.LinkedList;
import java.util.List;

public class KdTree implements ProjectDataStructure {

  private int k;
  private Node root;

  /**
   * Constructor for a KdTree object
   * @param k - dimensionality of the tree
   */
  public KdTree(int k) {
    k = k;
    root = new Node(k);
  }


  private void addNode(Node newNode, Node root, int currentLayer) {
    //TODO
  }

  private List<Node> nearestNeighbors(Node target) {
    //TODO
    return new LinkedList<>();
  }


  private void buildTree() {
    //implement later
    //go through json/table and add each row
    //called by loadData methods
  }


  /**
   * Checks if there is data in this KdTree
   * @return whether root is null or not
   */
  public boolean containsData() {
    return root != null;
  }

  public void loadDataSql(String pathToDb) {
    // don't need to do this one
    ProjectErrorHandler.notImplementedError();
  }

  public void loadDataJson(String pathToJson) {
    // implement later
    ProjectErrorHandler.notImplementedError();
  }

  public void loadFromOnline() {
    //implement later
    ProjectErrorHandler.notImplementedError();
  }

  public void similarToId(int userId) {
    //get the coords for this ID and then call similarToCoords
  }

  public void similarToCoords(int weight, int height, int age) {
    //the main functionality is here
    //call kdtree search and print out the list
  }

  public void classifyId(int userId) {
    System.out.println("classifyId" + Integer.toString(userId));
    //get the coords for this ID and then call classifyCoords
  }

  public void classifyCoords(int weight, int height, int age) {
    //the main functionality is here
    //call similartocoords to get a list of IDs
    //and then convert those to horoscopes and print out counts
  }
}
