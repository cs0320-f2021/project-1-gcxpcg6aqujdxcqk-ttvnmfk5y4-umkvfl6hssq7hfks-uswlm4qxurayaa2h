package edu.brown.cs.student.main;
import java.io.FileNotFoundException;

public interface ArgumentHandler {
  void handleArg(String[] arguments) throws FileNotFoundException;
  boolean checkNumArgs(String[] arguments);
  String getUsageString();
}
