package edu.brown.cs.student.kdtree;

import edu.brown.cs.student.jsonobjects.Users;
import edu.brown.cs.student.main.ArgumentHandler;
import edu.brown.cs.student.main.ProjectDataContainer;
import edu.brown.cs.student.main.ProjectErrorHandler;
import edu.brown.cs.student.recommender.Item;
import org.eclipse.jetty.server.Authentication;

public class SimilarHandler implements ArgumentHandler {

  public void handleArg(String[] arguments) {
    try {
      int k = Integer.parseInt(arguments[1]);

      if (k < 1) {
        ProjectErrorHandler.invalidInputError("<k> must be greater than 0");
      }

      if (arguments.length == 3) {
        ProjectErrorHandler.notImplementedError();
      } else if (arguments.length == 5) {
        Users item = new Users(-1, arguments[2], "", arguments[3], Integer.parseInt(arguments[4]), "", "");
        ProjectDataContainer.getRecommender().printRecommendations(item, k);
      } else {
        ProjectErrorHandler.invalidInputError("similar");
      }
    } catch (NumberFormatException e) {
      ProjectErrorHandler.invalidInputError("similar");
    }

  }

  public boolean checkNumArgs(String[] arguments) {
    return (arguments.length == 3) | (arguments.length == 5);
  }

  public String getUsageString() {
    return "usage: similar <k> <some_user_id>\n" +
        "       similar <k> <weight in lbs> <height in inches> <age in years>";
  }
}
