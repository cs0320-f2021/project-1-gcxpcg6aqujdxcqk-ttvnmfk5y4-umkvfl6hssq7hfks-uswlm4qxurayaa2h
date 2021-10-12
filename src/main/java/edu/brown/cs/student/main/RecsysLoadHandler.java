package edu.brown.cs.student.main;

import java.io.FileNotFoundException;

public class RecsysLoadHandler implements ArgumentHandler {

  @Override
  public void handleArg(String[] arguments) throws FileNotFoundException {
    //TODO
    //first get the data from the API and create array of Student objects
    //second get the data from ORM and fill in the null fields in that Student array
    //load into our StudentRecommender

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
