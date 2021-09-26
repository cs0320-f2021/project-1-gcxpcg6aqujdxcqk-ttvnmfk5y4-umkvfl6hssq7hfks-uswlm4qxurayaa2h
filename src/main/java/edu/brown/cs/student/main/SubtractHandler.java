package edu.brown.cs.student.main;

public class SubtractHandler implements ArgumentHandler {
  public void handleArg(String[] arguments) {
    MathBot mb = new MathBot();
    double difference = mb.subtract(Double.parseDouble(arguments[1]), Double.parseDouble(arguments[2]));
    System.out.println(difference);
  }

}
