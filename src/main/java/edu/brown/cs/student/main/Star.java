package edu.brown.cs.student.main;

public class Star {
  private int starID;
  private String properName;
  private double x;
  private double y;
  private double z;
  private double distance;

  /**
   * This is the constructor for the Star class. It takes in values for
   * the star and assigns them to variables to be accessed later.
   * @param id of the star
   * @param name of the star (Proper)
   * @param x coordinate of the star
   * @param y coordinate of the star
   * @param z coordinate of the star
   */
  public Star(int id, String name, double x, double y, double z) {
    this.starID = id;
    this.properName = name;
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * This method gets the ID of the star.
   * @return star ID
   */
  public int getStarID() {
    return this.starID;
  }

  /**
   * This method gets the proper name of the star.
   * @return proper name
   */
  public String getProperName() {
    return this.properName;
  }

  /**
   * This method gets the x coordinate of the star.
   * @return x coordinate
   */
  public double getX() {
    return this.x;
  }

  /**
   * This method gets the y coordinate of the star.
   * @return y coordinate
   */
  public double getY() {
    return this.y;
  }

  /**
   * This method gets the z coordinate of the star.
   * @return z coordinate
   */
  public double getZ() {
    return this.z;
  }

  /**
   * This method sets the distance of the star.
   * @param distance of the star
   */
  public void setDistance(double distance) {
    this.distance = distance;
  }

  /**
   * This method gets the distance of the star.
   * @return distance of the star.
   */
  public double getDistance() {
    return this.distance;
  }

}
