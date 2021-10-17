package edu.brown.cs.student.main.kdtree;

import edu.brown.cs.student.main.ArgumentHandler;
import edu.brown.cs.student.main.ProjectDataContainer;
import edu.brown.cs.student.main.ProjectDataStructure;
import edu.brown.cs.student.main.ProjectErrorHandler;

/**
 * This is the ClassifyHandler class, which handles the kd tree used for classifying the inputs.
 */
public class ClassifyHandler implements ArgumentHandler {

  /**
   * This method handles the arguments passed in from the REPL.
   *
   * @param arguments from the REPL
   */
  public void handleArg(String[] arguments) {
    try {
      Integer k = Integer.parseInt(arguments[1]);
      ProjectDataStructure kdTree = ProjectDataContainer.getDataStructure();

      if (arguments.length == 3) {
        kdTree.classifyId(k, Integer.parseInt(arguments[2]));
      } else if (arguments.length == 5) {
        int[] coords = new int[] {Integer.parseInt(arguments[2]),
            Integer.parseInt(arguments[3]), Integer.parseInt(arguments[4])};
        kdTree.classifyCoords(k, coords);
      } else {
        ProjectErrorHandler.invalidInputError("classify");
      }

    } catch (NumberFormatException e) {
      ProjectErrorHandler.invalidInputError("classify");
    }
  }

  /**
   * This method checks the number of passed in arguments, and returns true if it equals the
   * expected number. Method used to ensure correct REPL commands.
   *
   * @param arguments passed into the REPL
   * @return true if arguments equal the expected number
   */
  public boolean checkNumArgs(String[] arguments) {
    return (arguments.length == 3) | (arguments.length == 5);
  }

  /**
   * The getUsageString() method returns the usage string providing
   * the user more information on how to properly use the command.
   *
   * @return usage string
   */
  public String getUsageString() {
    return "usage: classify <k> <some_user_id>\n"
        + "       classify <k> <weight in lbs> <height in inches> <age in years>";
  }
}
