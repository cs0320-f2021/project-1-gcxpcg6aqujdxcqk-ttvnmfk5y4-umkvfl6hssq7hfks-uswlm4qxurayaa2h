package edu.brown.cs.student.kdtree;

import edu.brown.cs.student.main.ProjectErrorHandler;
import edu.brown.cs.student.recommender.Item;

import java.util.Arrays;
import java.util.List;

import static java.util.Objects.hash;

/**
 * Node that uses the Numbers vector of an Item T as coordinates when comparing
 * @param <T>
 */
public class Node<T extends Item>{
  private final String nodeId;
  private final int dimension;
  private final T item;
  private Node<T> lchild;
  private Node<T> rchild;

  public Node(String id, int k, T it) {
    if (it.getNumberVector().size() != k) {
      ProjectErrorHandler.invalidInputError("coords must be same length as k");
    }
    nodeId = id;
    dimension = k;
    item = it;
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
    return this.nodeId.equals(other.nodeId) && this.getItem().equals(other.getItem());
  }

  @Override
  public final int hashCode() {
    return hash(this.nodeId, this.item);
  }

  public T getItem() {
    return item;
  }

  public Number[] getCoordinates() {
    return this.getItem().getNumberVector().toArray(new Number[0]);
  }

  public Node getLChild() { return lchild; }
  public Node getRChild() { return rchild; }
  public void setLChild(Node n) { lchild = n; }
  public void setRChild(Node n) { rchild = n; }
  public void printNodeId() { System.out.println(nodeId); }

  /**
   * Calculates Euclidean distance from another Node
   * @param otherCoords - other point in space to calculate distance from
   * @return - null if error, otherwise the distance as Double
   * @Exception - calls invalidInputError if otherNode is not same dimension
   */
  public Double getDistanceFrom(Number[] otherCoords) {
    if (otherCoords.length != dimension) {
      ProjectErrorHandler.invalidInputError("otherNode must be of dimension" + dimension);
    } else {
      int sum = 0; Number thisn; Number thatn;
      for (int i = 0; i < dimension; i++) {
        thisn = this.getCoordinates()[i]; thatn = otherCoords[i];
        sum += (thisn.doubleValue() * thisn.doubleValue()) - (thatn.doubleValue() * thatn.doubleValue());
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
    Number[] otherCoords = otherNode.getCoordinates();
    if (otherCoords[dim].doubleValue() <= this.getCoordinates()[dim].doubleValue()) {
      return lchild;
    } else { //if (otherCoords[dim] > coordinates[dim])
      return rchild;
    }
  }

}
