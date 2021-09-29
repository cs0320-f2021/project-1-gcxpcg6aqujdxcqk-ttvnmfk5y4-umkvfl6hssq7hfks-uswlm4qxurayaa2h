package edu.brown.cs.student.main;

public class Node {
  private int dimension;
  private int[] coordinates;
  private Node parent;
  private Node lchild;
  private Node rchild;

  public Node(int k) {
    dimension = k;
    coordinates = new int[k];
    parent = null;
    lchild = null;
    rchild = null;
  }

  public int[] getCoordinates() {
    return coordinates;
  }

  /**
   * Calculates Euclidean distance from another Node
   * @param otherNode - other node to calculate distance from
   * @return - null if error, otherwise the distance as Double
   * @Exception - calls invalidInputError if otherNode is not same dimension
   */
  public Double getDistanceFrom(Node otherNode) {
    int[] otherCoords = otherNode.getCoordinates();
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
