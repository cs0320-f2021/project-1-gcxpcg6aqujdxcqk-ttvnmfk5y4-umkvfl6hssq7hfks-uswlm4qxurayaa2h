package edu.brown.cs.student.main.onboarding;

import edu.brown.cs.student.main.ArgumentHandler;
import edu.brown.cs.student.main.CSVReader;
import edu.brown.cs.student.main.ProjectErrorHandler;

public class NaiveNeighborsHandler implements ArgumentHandler {

  public void handleArg(String[] arguments) {
    try {
      CSVReader reader = new CSVReader();
      if (arguments[2].startsWith("\"")) {
        //These lines ensure that the full name is passed to nameSort
        StringBuilder properName = new StringBuilder(arguments[2]);
        if (!properName.toString().endsWith("\"")) {
          for (int i = 3; i < arguments.length; i++) {
            properName.append(arguments[i]);
            if (arguments[i].contains("\"")) {
              break;
            }
          }
        }
        if (!arguments[1].equals("1")) {
          reader.nameSort(Integer.parseInt(arguments[1]), properName.toString());
        }
      } else {
        reader.coordinateSort(Integer.parseInt(arguments[1]),
            Double.parseDouble(arguments[2]),
            Double.parseDouble(arguments[3]), Double.parseDouble(arguments[4]));
      }
    } catch (NullPointerException e) {
      ProjectErrorHandler.noStarsError();
    }

  }

  public boolean checkNumArgs(String[] arguments) {
    return (arguments.length == 3) | (arguments.length == 5);
  }

  public String getUsageString() {
    return "usage: naive_neighbors <k> <star_id>\n" +
        "       naive_neighbors <k> <x> <y> <z>";
  }
}

