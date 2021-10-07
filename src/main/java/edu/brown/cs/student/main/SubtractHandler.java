package edu.brown.cs.student.main;

import edu.brown.cs.student.main.onboarding.MathBot;

public class SubtractHandler implements ArgumentHandler {
  public void handleArg(String[] arguments) {
    MathBot mb = new MathBot();
    double difference = mb.subtract(Double.parseDouble(arguments[1]), Double.parseDouble(arguments[2]));
    System.out.println(difference);
  }

  public boolean checkNumArgs(String[] arguments) {
    return (arguments.length == 3);
  }

  public String getUsageString() {
    return "usage: subtract <int1> <int2>";
  }

}
