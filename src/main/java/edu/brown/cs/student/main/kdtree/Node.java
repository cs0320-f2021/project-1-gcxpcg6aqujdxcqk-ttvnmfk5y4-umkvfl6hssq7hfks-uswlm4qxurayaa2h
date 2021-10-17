package edu.brown.cs.student.main.kdtree;

import edu.brown.cs.student.main.ProjectErrorHandler;
import java.util.Arrays;

import static java.util.Objects.hash;

/**
 * This is the Node class, which makes a node using the given coordinates.
 */
public class Node {
  private final int nodeId;
  private final int dimension;
  private final int[] coordinates;
  private Node lchild;
  private Node rchild;

  /**
   * Constructor of the Node class.
   *
   * @param id of the node
   * @param k number of dimensions
   * @param coords of the node
   */
  public Node(int id, int k, int[] coords) {
    if (coords.length != k) {
      ProjectErrorHandler.invalidInputError("coords must be same length as k");
    }
    nodeId = id;
    dimension = k;
    coordinates = coords;
    lchild = null;
    rchild = null;
  }

  /**
   * Overrides equals to ensure proper comparison.
   *
   * @param o object to compare to
   * @return boolean
   */
  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Node)) {
      return false;
    }
    Node other = (Node) o;
    return this.nodeId == other.nodeId && Arrays.equals(this.coordinates, other.coordinates);
  }

  /**
   * hashCode() method ensures proper hashing.
   *
   * @return integer hashcode
   */
  @Override
  public final int hashCode() {
    return hash(this.nodeId, this.coordinates);
  }

  /**
   * Gets the coordinates of the node.
   *
   * @return coordinates
   */
  public int[] getCoordinates() {
    return coordinates;
  }

  /**
   * Gets the left child of the node.
   *
   * @return left child
   */
  public Node getLChild() {
    return lchild;
  }

  /**
   * Gets the right child of the node.
   *
   * @return right child
   */
  public Node getRChild() {
    return rchild;
  }

  /**
   * Sets the left child of the node.
   *
   * @param n node to be the left child
   */
  public void setLChild(Node n) {
    lchild = n;
  }

  /**
   * Sets the right child of the node.
   *
   * @param n node to be the right child
   */
  public void setRChild(Node n) {
    rchild = n;
  }

  /**
   * Prints the node id to the terminal.
   */
  public void printNodeId() {
    System.out.println(nodeId);
  }

  /**
   * Calculates Euclidean distance from another Node.
   *
   * @param otherCoords - other point in space to calculate distance from
   * @return - null if error, otherwise the distance as Double
   * @Exception - calls invalidInputError if otherNode is not same dimension
   */
  public Double getDistanceFrom(int[] otherCoords) {
    if (otherCoords.length != dimension) {
      ProjectErrorHandler.invalidInputError("otherNode must be of dimension" + dimension);
      return null;
    } else {
      int sum = 0;
      int thisn;
      int thatn;
      for (int i = 0; i < dimension; i++) {
        thisn = coordinates[i];
        thatn = otherCoords[i];
        sum += Math.pow((thisn - thatn), 2);
      }
      return Math.sqrt(sum);
    }
  }

  /**
   * Returns child of this node acc to otherNode as if you were searching through the tree.
   *
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
