package edu.brown.cs.student.main;

/**
 * The ProjectErrorHandler class contains all the errors thrown in the Main class.
 */
public final class ProjectErrorHandler {
  public static void noStarsError() {
    System.out.println("ERROR: no stars file has been loaded in yet");
  }

  public static void wrongArgError() {
    System.out.println("ERROR: unrecognized command");
  }

  public static void invalidInputError(String usage) {
    System.out.println("ERROR: invalid input for function");
    System.out.println(usage);
  }

  public static void brokenReplError() {
    System.out.println("ERROR: invalid REPL input");
  }

  public static void fileNotFoundError() {
    System.out.println("ERROR: file not found");
  }

  public static void notImplementedError() {
    System.out.println("ERROR: feature not yet implemented");
  }

  public static void wrongDimensionError() {
    System.out.println("ERROR: wrong dimension");
  }
}
