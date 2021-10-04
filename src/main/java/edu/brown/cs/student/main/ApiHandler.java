package edu.brown.cs.student.main;

import java.util.Arrays;
import java.util.HashSet;

public class ApiHandler implements ArgumentHandler {

  public void handleArg(String[] arguments) {
    ApiClient client = new ApiClient();
    JsonHandler handler = new JsonHandler();

    if (arguments[1].equals("users")) {
      HashSet<Users> userList = new HashSet<>();

      for (int i = 0; i < 3; i++) {
        try {
          client.makeRequest(ClientRequestGenerator.getRequest( "users","three"));
          Users[] users = handler.convertUsers(client.getData());
          userList.addAll(Arrays.asList(users));
        } catch (Exception e) {
          continue;
        }
      }

      try {
        client.makeRequest(ClientRequestGenerator.getRequest("users","two"));
        Users[] users2 = handler.convertUsers(client.getData());
        userList.addAll(Arrays.asList(users2));
      } catch (Exception e) {
        System.out.println("Malicious error, endpoint 2");
      }

      System.out.println(userList.size());

    } else if (arguments[1].equals("reviews")) {
      HashSet<Reviews> reviewList = new HashSet<>();

      try {
        client.makeRequest(ClientRequestGenerator.getRequest("reviews","two"));
        Reviews[] reviews = handler.convertReviews(client.getData());
        reviewList.addAll(Arrays.asList(reviews));
      } catch (Exception e) {

      }

      for (int i = 0; i < 3; i++) {
        try {
          client.makeRequest(ClientRequestGenerator.getRequest("reviews","three"));
          Reviews[] reviews = handler.convertReviews(client.getData());
          reviewList.addAll(Arrays.asList(reviews));
        } catch (Exception e) {
          continue;
        }
      }

      System.out.println(reviewList.size());

    } else if (arguments[1].equals("rent")){
      HashSet<Clothing> rent = new HashSet<>();
      for (int i = 0; i < 2; i++) {
        try {
          client.makeRequest(ClientRequestGenerator.getRequest("rent","two"));
          Clothing[] clothing = handler.convertClothing(client.getData());
          rent.addAll(Arrays.asList(clothing));
        } catch (Exception e) {
          continue;
        }
      }

      for (int i = 0; i < 3; i++) {
        try {
          client.makeRequest(ClientRequestGenerator.getRequest("rent","three"));
          Clothing[] clothing = handler.convertClothing(client.getData());
          rent.addAll(Arrays.asList(clothing));
        } catch (Exception e) {
          continue;
        }
      }

      System.out.println(rent.size());


    } else {
      System.out.println("ERROR: unrecognized dataGet command");
    }
  }
}
