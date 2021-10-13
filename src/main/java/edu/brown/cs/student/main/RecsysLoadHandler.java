package edu.brown.cs.student.main;

import edu.brown.cs.student.main.api.ApiClient;
import edu.brown.cs.student.main.api.ClientRequestGenerator;
import edu.brown.cs.student.main.jsonobjects.JSONObject;
import edu.brown.cs.student.main.jsonobjects.JsonHandler;
import edu.brown.cs.student.main.jsonobjects.Users;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;

public class RecsysLoadHandler implements ArgumentHandler {
  ApiClient client = new ApiClient();
  JsonHandler handler = new JsonHandler();

  @Override
  public void handleArg(String[] arguments) throws FileNotFoundException {
    //TODO
    //first get the data from the API and create array of Student objects
    //second get the data from ORM and fill in the null fields in that Student array
    //load into our StudentRecommender

    HashSet<JSONObject> studentList = new HashSet<>();

    // slower endpoint but more accurate
    try {
      client.makeRequest(ClientRequestGenerator.postRequest());
      Student[] student = handler.convertStudentFromAPI(client.getData());
      studentList.addAll(Arrays.asList(student));
    } catch (Exception ignore) {

    }

    //1. Use APIHandler and JsonHandler to fill Students[] with Student Objects. Some of the fields for each student object will be null at tis point.
    //2. Go through hAPI and then loop up student ID in database (SQL)
    //3. Then create some databaseHandler to take database data and use ID’s to fill in the empty field (time wise should be fine since the ID is our primary key in the SQL file)
  }

  @Override
  public boolean checkNumArgs(String[] arguments) {
    return false; //TODO
  }

  @Override
  public String getUsageString() {
    return null; //TODO
  }
}
