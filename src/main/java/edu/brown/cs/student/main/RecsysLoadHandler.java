package edu.brown.cs.student.main;

import java.io.FileNotFoundException;

public class RecsysLoadHandler implements ArgumentHandler {

  @Override
  public void handleArg(String[] arguments) throws FileNotFoundException {
    // make a new StudentRecommender and then loadData()
  }

  @Override
  public boolean checkNumArgs(String[] arguments) {
    return false; //TODO
  }

  @Override
  public String getUsageString() {
    return null; //TODO
  }
}
