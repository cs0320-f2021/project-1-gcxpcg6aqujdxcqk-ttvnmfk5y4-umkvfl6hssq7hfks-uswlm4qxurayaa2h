package edu.brown.cs.student.main;

import java.io.FileNotFoundException;

public class StarsHandler implements ArgumentHandler {
  public void handleArg(String[] arguments) {
    CSVReader reader = new CSVReader();
    try {
      reader.readFile(arguments[1]);
    }
    catch (FileNotFoundException e) {
      System.out.println("ERROR: file not found");
    }
  }
}
