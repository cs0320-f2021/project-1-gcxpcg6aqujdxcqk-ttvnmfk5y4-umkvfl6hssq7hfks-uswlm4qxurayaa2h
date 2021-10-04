package edu.brown.cs.student.main;

// a ProjectDataStructure that can be stored in ProjectDataContainer
public interface ProjectDataStructure {
  // Function to check if this structure has data loaded in or not
  boolean containsData();

  // Functions to load in data
  void loadDataSql(String pathToDb);
  void loadDataJson(String pathToJson);
  void loadFromOnline();

  // Functions used by similar command
  void similarToId(int numNeighbors, int userId);
  void similarToCoords(int numNeighbors, int[] targetCoords);

  // Functions used by classify command
  void classifyId(int numNeighbors, int userId);
  void classifyCoords(int numNeighbors, int[] targetCoords);
}
