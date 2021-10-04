package edu.brown.cs.student.main;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.List;

/**
 * This class generates the HttpRequests that are then used to make requests from the ApiClient.
 */
public class ClientRequestGenerator {

  /**
   *
   * @return an HttpRequest object for accessing and posting to the secured resource.
   */
  public static HttpRequest getUsersRequest(String endpoint) {
    List<String> arguments = ClientAuth.getApiKey();
    String apiKey = arguments.get(0);
    String csLogin = arguments.get(1);

    String auth = "?auth=" + csLogin + "&key=" + apiKey;

    String reqUri =
        "https://runwayapi.herokuapp.com/users-" + endpoint + auth;

    HttpRequest request = HttpRequest.newBuilder()
        .GET()
        .uri(URI.create(reqUri))
        .header("x-api-key", apiKey)
        .build();

    return request;
  }

  /**
   *
   * @return an HttpRequest object for accessing and posting to the secured resource.
   */
  public static HttpRequest getReviewsRequest() {
    List<String> arguments = ClientAuth.getApiKey();
    String apiKey = arguments.get(0);
    String csLogin = arguments.get(1);

    String auth = "?auth=" + csLogin + "&key=" + apiKey;

    String reqUriOne =
        "https://runwayapi.herokuapp.com/reviews-one" + auth;

    String reqUriTwo =
        "https://runwayapi.herokuapp.com/reviews-two" + auth;

    String reqUriThree =
        "https://runwayapi.herokuapp.com/reviews-three" + auth;

    String reqUriFour =
        "https://runwayapi.herokuapp.com/reviews-four" + auth;

    String reqUriFive =
        "https://runwayapi.herokuapp.com/reviews-five" + auth;

    HttpRequest request = HttpRequest.newBuilder()
        .GET()
        .uri(URI.create(reqUriThree))
        .header("x-api-key", apiKey)
        .build();

    return request;
  }

  /**
   *
   * @return an HttpRequest object for accessing and posting to the secured resource.
   */
  public static HttpRequest getRentRequest() {
    List<String> arguments = ClientAuth.getApiKey();
    String apiKey = arguments.get(0);
    String csLogin = arguments.get(1);

    String auth = "?auth=" + csLogin + "&key=" + apiKey;

    String reqUriOne =
        "https://runwayapi.herokuapp.com/rent-one" + auth;

    String reqUriTwo =
        "https://runwayapi.herokuapp.com/rent-two" + auth;

    String reqUriThree =
        "https://runwayapi.herokuapp.com/rent-three" + auth;

    String reqUriFour =
        "https://runwayapi.herokuapp.com/rent-four" + auth;

    String reqUriFive =
        "https://runwayapi.herokuapp.com/rent-five" + auth;

    HttpRequest request = HttpRequest.newBuilder()
        .GET()
        .uri(URI.create(reqUriThree))
        .header("x-api-key", apiKey)
        .build();

    return request;
  }
}