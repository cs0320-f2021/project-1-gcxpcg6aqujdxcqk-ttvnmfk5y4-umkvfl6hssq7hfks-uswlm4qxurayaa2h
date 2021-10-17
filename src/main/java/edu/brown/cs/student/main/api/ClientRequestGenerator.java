package edu.brown.cs.student.main.api;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.List;

/**
 * This class generates the HttpRequests that are then used to make requests from the ApiClient.
 */
public class ClientRequestGenerator {

  /**
   * This method makes an HttpRequest and constructs the endpoint url using the data type, api key,
   * and cs login.
   *
   * @return an HttpRequest object for accessing the secured resource.
   */
  public static HttpRequest getRequest(String data, String endpoint) {
    List<String> arguments = ClientAuth.getApiKey();
    String apiKey = arguments.get(0);
    String csLogin = arguments.get(1);

    String auth = "?auth=" + csLogin + "&key=" + apiKey;

    String reqUri =
        "https://runwayapi.herokuapp.com/" + data + "-" + endpoint + auth;

    return HttpRequest.newBuilder()
        .GET()
        .uri(URI.create(reqUri))
        .header("x-api-key", apiKey)
        .build();
  }

  /**
   * This method makes a POST request and sends a JSON containing the cs login.
   *
   * @return an HttpRequest object for accessing and posting to the secured resource.
   */
  public static HttpRequest postRequest() {
    List<String> arguments = ClientAuth.getApiKey();
    String apiKey = arguments.get(0);
    String csLogin = arguments.get(1);

    String reqUri = "https://runwayapi.herokuapp.com/integration";
    return HttpRequest.newBuilder()
        .POST(HttpRequest.BodyPublishers.ofString("{\"auth\":\"" + csLogin + "\"}"))
        .uri(URI.create(reqUri))
        .header("x-api-key", apiKey)
        .build();
  }
}
