package edu.brown.cs.student.main;

public class ClassifyHandler implements ArgumentHandler {
  public void handleArg(String[] arguments) {
    try {
      Integer k = Integer.parseInt(arguments[1]);

      if (arguments.length == 3) {
        System.out.println("Todo id");
      } else if (arguments.length == 5) {
        System.out.println("Todo coordinates");
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
