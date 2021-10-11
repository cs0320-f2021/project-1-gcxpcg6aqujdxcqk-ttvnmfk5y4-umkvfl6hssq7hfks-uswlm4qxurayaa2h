package edu.brown.cs.student.main;

import java.io.FileNotFoundException;

public class RecsysLoadHandler implements ArgumentHandler {

  @Override
  public void handleArg(String[] arguments) throws FileNotFoundException {
    if (arguments[1].equals("responses")) {
      ProjectErrorHandler.notImplementedError();
    } else {
      ProjectErrorHandler.notImplementedError();
    }
  }

  @Override
  public boolean checkNumArgs(String[] arguments) {
    return (arguments.length == 2);
  }

  @Override
  public String getUsageString() {
    return "usage: recsys_load responses";
  }
}
