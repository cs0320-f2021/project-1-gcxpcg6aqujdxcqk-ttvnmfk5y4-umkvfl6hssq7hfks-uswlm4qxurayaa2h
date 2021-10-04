package edu.brown.cs.student.main;

import java.util.Arrays;
import java.util.HashSet;

public class ApiHandler implements ArgumentHandler {

  public void handleArg(String[] arguments) {
    ApiClient client = new ApiClient();
    JsonHandler handler = new JsonHandler();

    switch (arguments[1]) {
      case "users":
        HashSet<Users> userList = new HashSet<>();

        for (int i = 0; i < 3; i++) {
          try {
            client.makeRequest(ClientRequestGenerator.getRequest("users", "three"));
            Users[] users = handler.convertUsers(client.getData());
            userList.addAll(Arrays.asList(users));
          } catch (Exception ignore) {

          }
        }

        try {
          client.makeRequest(ClientRequestGenerator.getRequest("users", "two"));
          Users[] users2 = handler.convertUsers(client.getData());
          userList.addAll(Arrays.asList(users2));
        } catch (Exception ignore) {

        }

        System.out.println(userList.size());

        break;
      case "reviews":
        HashSet<Reviews> reviewList = new HashSet<>();

        try {
          client.makeRequest(ClientRequestGenerator.getRequest("reviews", "two"));
          Reviews[] reviews = handler.convertReviews(client.getData());
          reviewList.addAll(Arrays.asList(reviews));
        } catch (Exception ignore) {

        }

        for (int i = 0; i < 3; i++) {
          try {
            client.makeRequest(ClientRequestGenerator.getRequest("reviews", "three"));
            Reviews[] reviews = handler.convertReviews(client.getData());
            reviewList.addAll(Arrays.asList(reviews));
          } catch (Exception ignored) {

          }
        }

        System.out.println(reviewList.size());

        break;
      case "rent":
        HashSet<Clothing> rent = new HashSet<>();
        for (int i = 0; i < 2; i++) {
          try {
            client.makeRequest(ClientRequestGenerator.getRequest("rent", "two"));
            Clothing[] clothing = handler.convertClothing(client.getData());
            rent.addAll(Arrays.asList(clothing));
          } catch (Exception ignored) {

          }
        }

        for (int i = 0; i < 3; i++) {
          try {
            client.makeRequest(ClientRequestGenerator.getRequest("rent", "three"));
            Clothing[] clothing = handler.convertClothing(client.getData());
            rent.addAll(Arrays.asList(clothing));
          } catch (Exception ignored) {

          }
        }

        System.out.println(rent.size());
        break;
      default:
        System.out.println("ERROR: unrecognized dataGet command");
        break;
    }
  }
}
