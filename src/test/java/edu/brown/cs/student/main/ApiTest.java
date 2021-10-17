package edu.brown.cs.student.main;

import edu.brown.cs.student.main.api.ApiClient;
import edu.brown.cs.student.main.api.ApiHandler;
import edu.brown.cs.student.main.api.ClientAuth;
import edu.brown.cs.student.main.api.ClientRequestGenerator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ApiTest {

  @Test
  public void testMakeRequest() {
    ApiClient client = new ApiClient();
    client.makeRequest(ClientRequestGenerator.getRequest("users", "two"));
    assertNotNull(client.getData());
  }

  @Test
  public void testHandleArgUsers() {
    String[] arguments = new String[2];
    arguments[0] = "dataGet";
    arguments[1] = "users";
    ApiHandler handler = new ApiHandler();
    handler.handleArg(arguments);
    assertEquals(handler.getHashSet().size(), 15);
  }

  @Test
  public void testHandleArgReviews() {
    String[] arguments = new String[2];
    arguments[0] = "dataGet";
    arguments[1] = "reviews";
    ApiHandler handler = new ApiHandler();
    handler.handleArg(arguments);
    assertEquals(handler.getHashSet().size(), 30);
  }

  @Test
  public void testHandleArgRent() {
    String[] arguments = new String[2];
    arguments[0] = "dataGet";
    arguments[1] = "rent";
    ApiHandler handler = new ApiHandler();
    handler.handleArg(arguments);
    assertEquals(handler.getHashSet().size(), 30);
  }

  @Test
  public void checkNumArgs() {
    String[] arguments = new String[2];
    arguments[0] = "dataGet";
    arguments[1] = "rent";
    ApiHandler handler = new ApiHandler();
    assertEquals(handler.checkNumArgs(arguments), true);
  }

  @Test
  public void checkNumArgsForAPIHandler() {
    String[] arguments = new String[2];
    arguments[0] = "dataGet";
    arguments[1] = "rent";
    ApiHandler handler = new ApiHandler();
    assertEquals(handler.getUsageString(), "usage: dataGet <data_type>");
  }

  @Test
  public void getHashSet() {
    ApiHandler handler = new ApiHandler();
    assertNull(handler.getHashSet());
  }

  @Test
  public void getApiKey() {
    assertEquals(ClientAuth.getApiKey().size(), 2);
  }
}
