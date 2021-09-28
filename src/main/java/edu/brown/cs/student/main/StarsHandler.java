package edu.brown.cs.student.main;

import java.io.FileNotFoundException;

public class StarsHandler implements ArgumentHandler {
  public void handleArg(String[] arguments) {
    CSVReader reader = new CSVReader();
    try {
      reader.readFile(arguments[1]);
    } catch (FileNotFoundException e) {
      ProjectErrorHandler.fileNotFoundError();
    }
  }

  public boolean checkNumArgs(String[] arguments) {
    return (arguments.length == 2);
  }

  public String getUsageString() {
    return "usage: stars <filename>";
  }
}
