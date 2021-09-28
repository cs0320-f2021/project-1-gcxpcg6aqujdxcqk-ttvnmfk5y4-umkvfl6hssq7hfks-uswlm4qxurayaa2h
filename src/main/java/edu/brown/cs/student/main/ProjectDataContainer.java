package edu.brown.cs.student.main;

public class ProjectDataContainer {
  private static ProjectDataStructure dataStructure = null;

  public static void setDataStructure(ProjectDataStructure s) {
    dataStructure = s;
  }

  public static ProjectDataStructure getDataStructure() {
    return dataStructure;
  }

}
