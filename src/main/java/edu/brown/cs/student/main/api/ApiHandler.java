package edu.brown.cs.student.main.api;

import edu.brown.cs.student.main.ArgumentHandler;
import edu.brown.cs.student.main.jsonobjects.Clothing;
import edu.brown.cs.student.main.jsonobjects.JSONObject;
import edu.brown.cs.student.main.jsonobjects.JsonHandler;
import edu.brown.cs.student.main.jsonobjects.Reviews;
import edu.brown.cs.student.main.jsonobjects.Users;

import java.util.Arrays;
import java.util.HashSet;

/**
 * This is the ApiHandler class, which gets the JSON data from each of the endpoints. It connects
 * to each endpoint a different number of times depending on speed and reliability of data.
 */
public class ApiHandler implements ArgumentHandler {
  private HashSet<JSONObject> hashSet;

  /**
   *
   * @param arguments
   */
  public void handleArg(String[] arguments) {
    ApiClient client = new ApiClient();
    JsonHandler handler = new JsonHandler();

    switch (arguments[1]) {
      case "users":
        HashSet<JSONObject> userList = new HashSet<>();

        // slower endpoint but more accurate
        try {
          client.makeRequest(ClientRequestGenerator.getRequest("users", "two"));
          Users[] users2 = handler.convertUsersFromAPI(client.getData());
          userList.addAll(Arrays.asList(users2));
        } catch (Exception ignore) {

        }

        // inaccurate endpoint but very fast
        for (int i = 0; i < 4; i++) {
          try {
            client.makeRequest(ClientRequestGenerator.getRequest("users", "three"));
            Users[] users = handler.convertUsersFromAPI(client.getData());
            userList.addAll(Arrays.asList(users));
          } catch (Exception ignore) {

          }
        }

        System.out.println(userList.size() + " results!");
        hashSet = userList;

        break;
      case "reviews":
        HashSet<JSONObject> reviewList = new HashSet<>();

        // slower endpoint but very accurate
        try {
          client.makeRequest(ClientRequestGenerator.getRequest("reviews", "two"));
          Reviews[] reviews = handler.convertReviewsFromAPI(client.getData());
          reviewList.addAll(Arrays.asList(reviews));
        } catch (Exception ignore) {

        }

        // medium speed, good accuracy
        for (int i = 0; i < 3; i++) {
          try {
            client.makeRequest(ClientRequestGenerator.getRequest("reviews", "three"));
            Reviews[] reviews = handler.convertReviewsFromAPI(client.getData());
            reviewList.addAll(Arrays.asList(reviews));
          } catch (Exception ignored) {

          }
        }

        System.out.println(reviewList.size() + " results!");
        hashSet = reviewList;

        break;
      case "rent":
        HashSet<JSONObject> rent = new HashSet<>();

        // medium speed good accuracy
        for (int i = 0; i < 2; i++) {
          try {
            client.makeRequest(ClientRequestGenerator.getRequest("rent", "two"));
            Clothing[] clothing = handler.convertClothingFromAPI(client.getData());
            rent.addAll(Arrays.asList(clothing));
          } catch (Exception ignored) {

          }
        }

        // fast speed medium accuracy
        for (int i = 0; i < 3; i++) {
          try {
            client.makeRequest(ClientRequestGenerator.getRequest("rent", "three"));
            Clothing[] clothing = handler.convertClothingFromAPI(client.getData());
            rent.addAll(Arrays.asList(clothing));
          } catch (Exception ignored) {

          }
        }

        System.out.println(rent.size() + " results!");
        hashSet = rent;
        break;
      default:
        System.out.println("ERROR: unrecognized dataGet command");
        break;
    }
  }

  public boolean checkNumArgs(String[] arguments) {
    return arguments.length == 2;
  }

  public String getUsageString() {
    return "usage: somethingGet <what>";
  }

  public HashSet<JSONObject> getHashSet() {
    return hashSet;
  }

}
