package edu.brown.cs.student.main;

public class AddHandler implements ArgumentHandler {

  public void handleArg(String[] arguments) {
    try {
      MathBot mb = new MathBot();
      double sum = mb.add(Double.parseDouble(arguments[1]), Double.parseDouble(arguments[2]));
      System.out.println(sum);
    } catch (Exception e) {

    }

  }
}
