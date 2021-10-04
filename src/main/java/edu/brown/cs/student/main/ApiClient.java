package edu.brown.cs.student.main;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ApiClient {

  private final HttpClient client;
  private String data;

  public ApiClient() {
    // HttpClient with version HTTP_2 and connection timeout of 15 seconds.
    // See https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html

    HttpClient client = HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_2)
        .connectTimeout(Duration.ofSeconds(15))
        .build();

    this.client = client;
  }

  public void makeRequest(HttpRequest req) {
    try {
      HttpResponse<String> apiResponse = client.send(req, HttpResponse.BodyHandlers.ofString());
      System.out.println("Status " + apiResponse.statusCode());
      System.out.println(apiResponse.body());
      data = apiResponse.body();

    } catch (IOException ioe) {
      System.out.println("An I/O error occurred when sending or receiving data.");
      System.out.println(ioe.getMessage());

    } catch (InterruptedException ie) {
      System.out.println("The operation was interrupted.");
      System.out.println(ie.getMessage());

    } catch (IllegalArgumentException iae) {
      System.out.println(
          "The request argument was invalid. It must be built as specified by HttpRequest.Builder.");
      System.out.println(iae.getMessage());

    } catch (SecurityException se) {
      System.out.println("There was a security configuration error.");
      System.out.println(se.getMessage());
    }
  }

  public String getData() {
    String dataTemp = data;
    data  = null;
    return dataTemp;
  }
}
