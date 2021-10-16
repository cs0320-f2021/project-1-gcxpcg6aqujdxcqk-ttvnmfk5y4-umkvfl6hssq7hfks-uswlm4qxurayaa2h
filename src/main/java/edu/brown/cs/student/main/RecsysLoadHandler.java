package edu.brown.cs.student.main;

import edu.brown.cs.student.main.api.ApiClient;
import edu.brown.cs.student.main.api.ClientRequestGenerator;
import edu.brown.cs.student.main.jsonobjects.JSONObject;
import edu.brown.cs.student.main.jsonobjects.JsonHandler;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;

public class RecsysLoadHandler implements ArgumentHandler {

  @Override
  public void handleArg(String[] arguments) throws FileNotFoundException {
    ApiClient client = new ApiClient();
    JsonHandler handler = new JsonHandler();

    //first get the data from the API and create array of Student objects
    HashSet<Student> studentHashSet = new HashSet<>();
    for (int i = 0; i < 3; i++) {
      try {
      client.makeRequest(ClientRequestGenerator.postRequest());
      Student[] student = handler.convertStudentFromAPI(client.getData());
      studentHashSet.addAll(Arrays.asList(student));
      } catch (Exception ignore) {

      }
    }
    System.out.println(studentHashSet.size() + " results!");

    //TODO make sure filename is right
    StudentRecommender sr = new StudentRecommender(studentHashSet, "data/project-1/integration.sqlite3");
    ProjectDataContainer.setProjectRecommender(sr);
  }

  @Override
  public boolean checkNumArgs(String[] arguments) {
    return arguments.length == 2;
  }

  @Override
  public String getUsageString() {
    return "usage: recsys_load responses";
  }
}
