package edu.brown.cs.student.main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class ApiHandler implements ArgumentHandler {

  public void handleArg(String[] arguments) {
    ApiClient client = new ApiClient();
    JsonHandler handler = new JsonHandler();

    if (arguments[1].equals("users")) {
      HashSet<Users> userList = new HashSet<>();

      for (int i = 0; i < 3; i++) {
        client.makeRequest(ClientRequestGenerator.getUsersRequest("three"));
        Users[] users = handler.convertUsers(client.getData());
        userList.addAll(Arrays.asList(users));

        /*
        client.makeRequest(ClientRequestGenerator.getUsersRequest("four"));
        Users[] users2 = handler.convertUsers(client.getData());
        userList.addAll(Arrays.asList(users2));
        
         */
      }

      Iterator<Users> iterator = userList.iterator();

      System.out.println(userList.size());

    } else if (arguments[1].equals("reviews")) {
      client.makeRequest(ClientRequestGenerator.getReviewsRequest());
    } else if (arguments[1].equals("rent")){
      client.makeRequest(ClientRequestGenerator.getRentRequest());
    } else {
      System.out.println("ERROR: unrecognized dataGet command");
    }
  }
}
