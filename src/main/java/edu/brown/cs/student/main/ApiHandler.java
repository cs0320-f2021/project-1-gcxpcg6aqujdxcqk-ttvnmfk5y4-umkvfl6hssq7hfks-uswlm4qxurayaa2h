package edu.brown.cs.student.main;

public class ApiHandler implements ArgumentHandler {

  public void handleArg(String[] arguments) {
    ApiClient client = new ApiClient();
    if (arguments[1].equals("users")) {
      client.makeRequest(ClientRequestGenerator.getUsersRequest());
    } else if (arguments[1].equals("reviews")) {
      client.makeRequest(ClientRequestGenerator.getReviewsRequest());
    } else if (arguments[1].equals("rent")){
      client.makeRequest(ClientRequestGenerator.getRentRequest());
    } else {
      ProjectErrorHandler.wrongArgError();
    }
  }

  public boolean checkNumArgs(String[] arguments) {
    return arguments.length == 2;
  }

  public String getUsageString() {
    return "usage: somethingGet <what>";
  }
}
