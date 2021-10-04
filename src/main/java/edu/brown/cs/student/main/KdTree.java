package edu.brown.cs.student.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KdTree implements ProjectDataStructure {

  private int k;
  private Node root;

  /**
   * Constructor for a KdTree object
   * @param dimension - dimensionality of the tree
   */
  public KdTree(int dimension) {
    k = dimension;
    root = null;
  }


  private void addNode(Node newNode, Node addTo, int currentLayer) {
    if (newNode.getCoordinates().length != k) {
      ProjectErrorHandler.wrongDimensionError();
    }
    int currentDimension = currentLayer % k;
    if (root.equals(null)){
      this.root = newNode;}
    else {
      if(newNode.getCoordinates()[currentDimension] <= addTo.getCoordinates()[currentDimension]){
        addNode(newNode, addTo.getLChild(),currentLayer + 1);
      }
      else{
        addNode(newNode, addTo.getRChild(),currentLayer + 1);
      }
    }
  }

  /**
   * Helper function that returns the entry with the max possible value in the HashMap
   * @param hm - HashMap to get the max possible entry of
   * @return Entry<Node, Double> that has the max value
   */
  // TODO make this general it's so not general right now :(
  private Map.Entry<Node, Double> getMaxEntry(HashMap<Node, Double> hm) {
    Map.Entry<Node, Double> maxEntry = null;
    for (Map.Entry<Node, Double> entry : hm.entrySet()) {
      if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
      { maxEntry = entry; }
    }
    return maxEntry;
  }

  /**
   * Performs kNearestNeighbors search starting from node current.
   * @param current - node to start searching from
   * @param targetCoords - coords we are getting nearest neighbors to
   * @param nn - current HashMap of Nodes that are nearest neighbors -> their distances
   * @param numNeighbors - the number of neighbors to look for
   * @param currentLayer - current layer searching from (start at 0)
   * @return nn, HashMap of Nodes that are nearest neighbors -> their distances
   */
  private HashMap<Node, Double> nearestNeighbors(Node current, int[] targetCoords, HashMap<Node, Double> nn, int numNeighbors, int currentLayer) {
    // Make sure that targetCoords is the right length
    if (targetCoords.length != k) {
      ProjectErrorHandler.invalidInputError("similarToCoords targetCoords must be"+k+"dimensions");
    }

    // Get the current dimension, distance from current to targetCoords
    int currentDim = currentLayer % k;
    Double d = current.getDistanceFrom(targetCoords);

    if (nn.size() < numNeighbors) {
      nn.put(current, d);
      nearestNeighbors(current.getLChild(), targetCoords, nn, numNeighbors, currentLayer+1);
      nearestNeighbors(current.getRChild(), targetCoords, nn, numNeighbors, currentLayer+1);
    } else {
      // get the furthest node from targetCoords in nn right now
      // if there are multiple with the same value, just returns the first one
      Map.Entry<Node, Double> furthestEntry = getMaxEntry(nn);

      // if current is closer than the furthest, replace and recalculate furthestEntry again
      if (furthestEntry.getValue() > d) {
        nn.remove(furthestEntry.getKey());
        nn.put(current, d);
        furthestEntry = getMaxEntry(nn);
      }

      int axisDistance = targetCoords[currentDim] - current.getCoordinates()[currentDim];

      if (furthestEntry.getKey().getDistanceFrom(targetCoords) > axisDistance) {
        nearestNeighbors(current.getLChild(), targetCoords, nn, numNeighbors, currentLayer+1);
        nearestNeighbors(current.getRChild(), targetCoords, nn, numNeighbors, currentLayer+1);
      } else {
        if (targetCoords[currentDim] <= current.getCoordinates()[currentDim]) {
          nearestNeighbors(current.getLChild(), targetCoords, nn, numNeighbors, currentLayer+1);
        } else {
          nearestNeighbors(current.getRChild(), targetCoords, nn, numNeighbors, currentLayer+1);
        }
      }
    }
    return nn;
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

  public void similarToId(int numNeighbors, int userId) {
    //get the coords for this ID and then call similarToCoords
  }

  //the main functionality is here
  // targetCoords instead of (int weight, int height, int age)
  public void similarToCoords(int numNeighbors, int[] targetCoords) {
    // Call kdtree search and print out the list
    HashMap<Node, Double> nn = new HashMap<>();
    nearestNeighbors(root, targetCoords, nn, numNeighbors, 0);
    assert (numNeighbors == nn.size());

    // make this more generic?
    List<Map.Entry<Node, Double>> nnlist = new ArrayList<>(nn.entrySet());
    nnlist.sort(Map.Entry.comparingByValue());
    for (Map.Entry<Node, Double> entry: nnlist) {
      System.out.println(entry.getKey());
    }
  }

  public void classifyId(int numNeighbors, int userId) {
    System.out.println("classifyId" + Integer.toString(userId));
    //get the coords for this ID and then call classifyCoords
  }

  //the main functionality is here
  public void classifyCoords(int numNeighbors, int[] targetCoords) {
    //call similartocoords to get a list of IDs
    //and then convert those to horoscopes and print out counts
  }
}