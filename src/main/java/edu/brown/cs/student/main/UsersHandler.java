package edu.brown.cs.student.main;

import edu.brown.cs.student.api.ApiHandler;
import edu.brown.cs.student.jsonobjects.JSONObject;
import edu.brown.cs.student.jsonobjects.JsonHandler;
import edu.brown.cs.student.jsonobjects.Users;
import edu.brown.cs.student.kdtree.KdTree;

import java.io.FileNotFoundException;
import java.util.HashSet;

public class UsersHandler implements ArgumentHandler {
  public void handleArg(String[] arguments) {
    if (arguments[1].equals("online")) {
      System.out.println("loading from api...");

      // get the hashset from the api handler
      ApiHandler apiHandler = new ApiHandler();
      apiHandler.handleArg(new String[] {"dataGet", "users"}); // dataGet <users, reviews, rent>
      HashSet<JSONObject> apiHashSet = apiHandler.getHashSet();

      // load into a kdtree structure, hardcode k=3 because UsersHandler
      KdTree newTree = new KdTree(3);
      JSONObject[] apiArray = new JSONObject[]{};
      newTree.loadData(apiHashSet.toArray(apiArray));

      // print tree for debugging purposes
      // newTree.printTree();

      // set tree to be the global data structure
      ProjectDataContainer.setDataStructure(newTree);
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

        System.out.println("Data loaded!");
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
