package edu.brown.cs.student.main;

import edu.brown.cs.student.main.jsonobjects.JSONObject;
import edu.brown.cs.student.main.orm.Database;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ResponsesRecommender implements Recommender {
  public void loadDataAPI(JSONObject[] jsonObjects) {
    //TODO
  }

  public void loadDataORM(String dbName) {
    try {
      Database db = new Database(dbName);
      Map<String, String> queryParams = new HashMap<>();
//      List<Student> = db.select(LinkedList<Student>, queryParams);
    } catch (Exception e) {
      //e.printStackTrace();
      ProjectErrorHandler.invalidInputError("invalid db name");
    }

    //TODO
  }

  @Override
  public void recommendID(int numRecs, int id) {
    //TODO
  }

  @Override
  public void recommendTeams(int teamSize) {
    //TODO
  }
}
