package edu.brown.cs.student.main;

public class ProjectDataContainer {
  private static ProjectDataStructure dataStructure = null;
  private static Recommender projectRecommender = null;

  public static void setDataStructure(ProjectDataStructure s) {
    dataStructure = s;
  }

  public static ProjectDataStructure getDataStructure() {
    return dataStructure;
  }

  public static void setProjectRecommender(Recommender r) {
    projectRecommender = r;
  }

  public static Recommender getProjectRecommender() {
    return projectRecommender;
  }

}
