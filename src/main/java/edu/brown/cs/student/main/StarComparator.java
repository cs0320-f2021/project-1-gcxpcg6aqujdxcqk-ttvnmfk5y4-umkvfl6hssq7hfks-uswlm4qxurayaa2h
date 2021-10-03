package edu.brown.cs.student.main;

public class StarComparator implements java.util.Comparator<Star> {
  static final double SPLIT = 0.5; //ensures even split when using Math.random()

  /**
   * This method compares the distance of two stars. If two stars have the same
   * distance, then they are randomly assigned an order using Math.random().
   * @param star1 to be compared
   * @param star2 to be compared
   * @return integer to determine comparison
   */
  public int compare(Star star1, Star star2) {
    if (star1.getDistance() < star2.getDistance()) {
      return -1;
    } else if (star1.getDistance() > star2.getDistance()) {
      return 1;
    } else {
      double random = Math.random();
      if (random < SPLIT) {
        return -1;
      } else {
        return 1;
      }
    }
  }
}
