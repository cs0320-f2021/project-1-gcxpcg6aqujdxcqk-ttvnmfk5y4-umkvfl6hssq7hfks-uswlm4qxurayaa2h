package edu.brown.cs.student.main;

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
      StarsErrorHandler.noStarsError();
    }

  }
}

