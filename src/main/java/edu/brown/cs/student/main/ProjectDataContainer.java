package edu.brown.cs.student.main;

/**
 * This class is the container for our entire project, as it allows us to set the structure and
 * use the recommender throughout the project.
 */
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
