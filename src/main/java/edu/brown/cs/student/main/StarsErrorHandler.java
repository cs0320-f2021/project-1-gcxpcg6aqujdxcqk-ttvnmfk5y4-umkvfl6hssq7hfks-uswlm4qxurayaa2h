package edu.brown.cs.student.main;

public final class StarsErrorHandler {
  public static void noStarsError() {
    System.out.println("ERROR: no stars file has been loaded in yet");
  }

  public static void wrongArgError() {
    System.out.println("ERROR: unrecognized command");
  }

  public static void brokenReplError() {
    System.out.println("ERROR: invalid REPL input");
  }

  public static void fileNotFoundError() {
    System.out.println("ERROR: file not found");
  }

}
