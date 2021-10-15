package edu.brown.cs.student.main;

import edu.brown.cs.student.main.api.ApiClient;
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
    //assertNotNull(client.getData());
  }
}
