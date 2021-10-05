package edu.brown.cs.student.main;

import java.io.FileNotFoundException;

public class UsersHandler implements ArgumentHandler {
  public void handleArg(String[] arguments) {
    if (arguments[1].equals("online")) {
      System.out.println("TODO online");
    } else {
      String jsonFileName = arguments[1];
      JsonHandler jh = new JsonHandler();
      try {
        // read in json
        Users[] usersArray = jh.convertUsers(jsonFileName);

        // create a new tree and add data in there
        KdTree newTree = new KdTree(3);
        newTree.loadData(usersArray);
//        newTree.printTree();

        // set tree to be the global data structure
        ProjectDataContainer.setDataStructure(newTree);
      } catch (FileNotFoundException e) {
        ProjectErrorHandler.invalidInputError("could not read file "+jsonFileName);
      }
    }
  }

  public boolean checkNumArgs(String[] arguments) {
    return (arguments.length == 2);
  }

  public String getUsageString() {
    return "usage: users path/to/jsonfile.json \n " +
        "       users online";
  }

}
