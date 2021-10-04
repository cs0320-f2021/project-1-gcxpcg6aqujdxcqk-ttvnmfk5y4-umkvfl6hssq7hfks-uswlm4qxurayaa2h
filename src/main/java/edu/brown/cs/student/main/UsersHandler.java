package edu.brown.cs.student.main;

public class UsersHandler implements ArgumentHandler {
  public void handleArg(String[] arguments) {
    if (arguments[1] == "online") {
      System.out.println("TODO online");
    } else {
      System.out.println("TODO json");
    }
  }

  public boolean checkNumArgs(String[] arguments) {
    return (arguments.length == 2);
  }

  public String getUsageString() {
    return "usage: users path/to/jsonfile.json ... for API pursuers \n " +
        "       users online ...";


  }

}
