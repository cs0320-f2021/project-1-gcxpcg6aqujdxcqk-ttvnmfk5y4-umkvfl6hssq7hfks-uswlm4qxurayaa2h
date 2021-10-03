package edu.brown.cs.student.main;

import java.io.FileNotFoundException;

public class AddHandler implements ArgumentHandler {

  public void handleArg(String[] arguments) throws FileNotFoundException {
    MathBot mb = new MathBot();
    double sum = mb.add(Double.parseDouble(arguments[1]), Double.parseDouble(arguments[2]));
    System.out.println(sum);
//    System.out.println(JsonHandler.readJSONfile("data/justrentSMALL.json"));


  }

}
