package edu.brown.cs.student.main.onboarding;

import edu.brown.cs.student.main.ArgumentHandler;
import edu.brown.cs.student.main.onboarding.MathBot;

import java.io.FileNotFoundException;

public class AddHandler implements ArgumentHandler {

  public void handleArg(String[] arguments) throws FileNotFoundException {
    MathBot mb = new MathBot();
    double sum = mb.add(Double.parseDouble(arguments[1]), Double.parseDouble(arguments[2]));
    System.out.println(sum);
  }

  public boolean checkNumArgs(String[] arguments) {
    return (arguments.length == 3);
  }

  public String getUsageString() {
    return "usage: add <int1> <int2>";
  }

}
