package edu.brown.cs.student.main;

import org.checkerframework.checker.units.qual.A;

import java.io.FileNotFoundException;
import java.util.HashSet;

public class UsersHandler implements ArgumentHandler {
  public void handleArg(String[] arguments) {
    if (arguments[1].equals("online")) {
      System.out.println("TODO online");
      ApiHandler apih = new ApiHandler();
      apih.handleArg(arguments);
      HashSet<JSONObject> apihs = apih.getHashSet();
      System.out.println(apihs);
    } else {
      String jsonFileName = arguments[1];
      JsonHandler jh = new JsonHandler();
      try {
        // read in json
        Users[] usersArray = jh.convertUsers(jsonFileName);

        // TODO generalize this
        // For now if we didn't read in


        // create a new tree and add data in there
        KdTree newTree = new KdTree(3);
        newTree.loadData(usersArray);

        // print tree for debugging purposes
        // newTree.printTree();

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
