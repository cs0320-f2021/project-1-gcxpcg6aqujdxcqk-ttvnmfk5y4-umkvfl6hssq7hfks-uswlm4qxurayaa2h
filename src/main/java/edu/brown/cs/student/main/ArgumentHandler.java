package edu.brown.cs.student.main;

import java.io.FileNotFoundException;

/**
 * This interface ensures that all handlers have the same essential methods, including handleArg,
 * checkNumArgs, and getUsageString.
 */
public interface ArgumentHandler {
  void handleArg(String[] arguments) throws FileNotFoundException;

  boolean checkNumArgs(String[] arguments);

  String getUsageString();
}
