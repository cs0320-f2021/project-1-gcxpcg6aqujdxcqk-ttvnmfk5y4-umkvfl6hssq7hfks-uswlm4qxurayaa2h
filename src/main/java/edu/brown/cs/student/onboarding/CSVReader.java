package edu.brown.cs.student.onboarding;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
  private List<Star> stars;

  /**
   * Default constructor.
   */
  public CSVReader() {

  }

  /**
   * This method gets the star data given a file path.
   * @param path to find the file
   * @throws FileNotFoundException if path is null
   */
  public void readFile(String path) throws FileNotFoundException {

    stars = new ArrayList<>();
    int counter = 0;
    Scanner sc = new Scanner(new File(path));
    sc.useDelimiter("\n");
    while (sc.hasNext()) {
      String line = sc.next();
      String[] values = line.split(",");
      if (values[0].equals("StarID")) {
        continue;
      }
      Star star = new Star(Integer.parseInt(values[0]), values[1],
          Double.parseDouble(values[2]), Double.parseDouble(values[3]),
          Double.parseDouble(values[4]));

      stars.add(star);
      counter++;
    }
    System.out.println("Read " + counter + " stars from " + path);
  }

  /**
   * This method prints the k-closest stars given x, y, z coordinates.
   * @param k number of stars to find
   * @param x coordinate
   * @param y coordinate
   * @param z coordinate
   */
  public void coordinateSort(int k, double x, double y, double z) {
    for (Star star: this.stars) {
      double starX = star.getX();
      double starY = star.getY();
      double starZ = star.getZ();
      double distance = Math.sqrt(Math.pow(x - starX, 2)
          + Math.pow(y - starY, 2) + Math.pow(z - starZ, 2));
      star.setDistance(distance);
    }

    Collections.sort(stars, new StarComparator());
    this.printStars(k, this.stars);
  }

  /**
   * This method finds the k-closest stars to the named star.
   * @param k stars to find
   * @param name of star to find the closest stars to
   */
  public void nameSort(int k, String name) {
    String noQuotes = name.replaceAll("\"", "");
    Star distanceStar = null;
    for (Star star: this.stars) {
      if (star.getProperName().equals(noQuotes)) {
        distanceStar = star;
        break;
      }
    }
    stars.remove(distanceStar);
    this.coordinateSort(k, distanceStar.getX(),
        distanceStar.getY(), distanceStar.getZ());
    stars.add(distanceStar);
  }

  /**
   * This method prints the stars to the terminal given a list
   * @param k stars to print
   * @param printStar list of stars
   */
  private void printStars(int k, List<Star> printStar) {
    for (int i = 0; i < k; i++) {
      System.out.println(printStar.get(i).getStarID());
    }
  }
}
