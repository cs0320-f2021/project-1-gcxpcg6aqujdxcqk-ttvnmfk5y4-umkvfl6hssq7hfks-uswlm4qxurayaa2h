package edu.brown.cs.student.main.kdtree;

import edu.brown.cs.student.main.ArgumentHandler;
import edu.brown.cs.student.main.ProjectDataContainer;
import edu.brown.cs.student.main.ProjectDataStructure;
import edu.brown.cs.student.main.ProjectErrorHandler;

public class ClassifyHandler implements ArgumentHandler {
  public void handleArg(String[] arguments) {
    try {
      Integer k = Integer.parseInt(arguments[1]);
      ProjectDataStructure kdTree = ProjectDataContainer.getDataStructure();

      if (arguments.length == 3) {
        kdTree.classifyId(k, Integer.parseInt(arguments[2]));
      } else if (arguments.length == 5) {
        int[] coords = new int[] {Integer.parseInt(arguments[2]), Integer.parseInt(arguments[3]), Integer.parseInt(arguments[4])};
        kdTree.classifyCoords(k, coords);
      } else {
        ProjectErrorHandler.invalidInputError("classify");
      }

    } catch (NumberFormatException e) {
      ProjectErrorHandler.invalidInputError("classify");
    }
  }

  public boolean checkNumArgs(String[] arguments) {
    return (arguments.length == 3) | (arguments.length == 5);
  }

  public String getUsageString() {
    return "usage: classify <k> <some_user_id>\n" +
        "       classify <k> <weight in lbs> <height in inches> <age in years>";
  }
}
