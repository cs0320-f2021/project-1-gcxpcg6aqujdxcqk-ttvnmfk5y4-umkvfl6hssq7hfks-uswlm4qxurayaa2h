package edu.brown.cs.student.main;

import edu.brown.cs.student.recommender.Recommender;

public class ProjectDataContainer {
  private static ProjectDataStructure dataStructure = null;
  private static Recommender recommender = null;

  public static void setDataStructure(ProjectDataStructure s) {
    dataStructure = s;
  }

  public static ProjectDataStructure getDataStructure() {
    return dataStructure;
  }

  public static void setRecommender(Recommender r) {
    recommender = r;
  }

  public static Recommender getRecommender() {
    return recommender;
  }

}
