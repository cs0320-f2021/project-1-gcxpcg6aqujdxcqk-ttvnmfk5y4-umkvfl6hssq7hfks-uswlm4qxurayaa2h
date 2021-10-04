package edu.brown.cs.student.main;

import java.util.Arrays;

import static java.util.Objects.hash;

public class Node {
  private int nodeId;
  private int dimension;
  private int[] coordinates;
  private Node parent;
  private Node lchild;
  private Node rchild;

  public Node(int id, int k, int[] coords) {
    if (coordinates.length != k) {
      ProjectErrorHandler.invalidInputError("coords must be same length as k");
    }
    nodeId = id;
    dimension = k;
    coordinates = coords;
    parent = null;
    lchild = null;
    rchild = null;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Node))
      return false;
    Node other = (Node)o;
    return this.nodeId == other.nodeId && Arrays.equals(this.coordinates, other.coordinates);
  }

  @Override
  public final int hashCode() {
    return hash(this.nodeId, this.coordinates);
  }

  public int[] getCoordinates() {
    return coordinates;
  }

  public Node getLChild() { return lchild; }
  public Node getRChild() { return rchild; }

  /**
   * Calculates Euclidean distance from another Node
   * @param otherCoords - other point in space to calculate distance from
   * @return - null if error, otherwise the distance as Double
   * @Exception - calls invalidInputError if otherNode is not same dimension
   */
  public Double getDistanceFrom(int[] otherCoords) {
    if (otherCoords.length != dimension) {
      ProjectErrorHandler.invalidInputError("otherNode must be of dimension" + dimension);
    } else {
      int sum = 0; int thisn; int thatn;
      for (int i = 0; i < dimension; i++) {
        thisn = coordinates[i]; thatn = otherCoords[i];
        sum += (thisn * thisn) - (thatn * thatn);
      }
      return Math.sqrt(sum);
    }
    return null;
  }

  /**
   * Returns child of this node acc to otherNode as if you were searching through the tree
   * @param otherNode - node you want to compare to this node
   * @param dim - the dimension to compare based on
   * @return - the lchild of this node (null or Node) if otherNode[dim] <= thisNode[dim]
   *           the rchild of this node (null or Node) if otherNode[dim] > thisNode[dim]
   */
  public Node compareAndGetChild(Node otherNode, int dim) {
    int[] otherCoords = otherNode.getCoordinates();
    if (otherCoords[dim] <= coordinates[dim]) {
      return lchild;
    } else { //if (otherCoords[dim] > coordinates[dim])
      return rchild;
    }
  }

}
