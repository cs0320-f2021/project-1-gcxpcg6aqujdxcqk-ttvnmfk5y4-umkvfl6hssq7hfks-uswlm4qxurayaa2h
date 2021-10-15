package edu.brown.cs.student.main;

import edu.brown.cs.student.main.api.ApiClient;
import edu.brown.cs.student.main.api.ClientRequestGenerator;
import edu.brown.cs.student.main.jsonobjects.JSONObject;
import edu.brown.cs.student.main.jsonobjects.JsonHandler;
import edu.brown.cs.student.orm.Database;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class StudentRecommender implements Recommender {
  private Student[] studentsArray = new Student[]{};
  private final Database db = null;

  /**
   * Function that combines API and database data
   * It first loads in data from the online API into an array of Students i.e. Students[]
   * Then, for each Student, it looks up that student in the Database, and fills in fields in Student object
   * Prints an error to the REPL if data cannot be found for that Student from the API
   */
  public StudentRecommender(HashSet<Student> studentHashSet, String dbString) {
    // API was already called in RecsysLoadHandler, so now we just load that into Students[] array
    studentHashSet.toArray(studentsArray);


    // set up Database
    try {
      db = new Database(dbString);
    } catch (ClassNotFoundException ce) {
      ProjectErrorHandler.invalidInputError("unable to create database using class org.sqlite.JDBC");
    } catch (SQLException se) {
      ProjectErrorHandler.invalidInputError("error when connecting to sql database");
    }

    // if database is not null...
    if (db != null) {
      // go through API students and fill in skills from Database
      for (Student s : studentsArray) {
        int sid = s.getId();
        Map<String, String> qParams = new HashMap<>();
        qParams.put("id", String.valueOf(sid));
        try {
          // select from skills table and merge with this student
          List<Student> selectResult = db.select(Student.class, "skills", qParams);
          assert (selectResult.size() == 1);
          Student dbStudent = selectResult.get(0);
          s.mergeStudentIntoThis(dbStudent);
        } catch (AssertionError e) {
          System.out.println("Student " + sid + " not found in skills database");
        } catch (Exception e) {
          ProjectErrorHandler.invalidInputError("Error selecting skills from database");
        }

        // select from positive table and merge with this student
        try {
          List<Student> selectResult = db.select(Student.class, "positive", qParams);
          assert (selectResult.size() >= 1);
          for (Student dbStudent : selectResult) {
            s.mergeStudentIntoThis(dbStudent);
          }
        } catch (AssertionError e) {
          System.out.println("Student " + sid + " not found in positive database");
        } catch (Exception e) {
          ProjectErrorHandler.invalidInputError("Error selecting positive traits from database");
        }

        // select from negative table and merge with this student
        try {
          List<Student> selectResult = db.select(Student.class, "negative", qParams);
          assert (selectResult.size() >= 1);
          for (Student dbStudent : selectResult) {
            s.mergeStudentIntoThis(dbStudent);
          }
        } catch (AssertionError e) {
          System.out.println("Student " + sid + " not found in negative database");
        } catch (Exception e) {
          ProjectErrorHandler.invalidInputError("Error selecting negative traits from database");
        }

        // select from interests table and merge with this student
        try {
          List<Student> selectResult = db.select(Student.class, "interests", qParams);
          assert (selectResult.size() >= 1);
          for (Student dbStudent : selectResult) {
            s.mergeStudentIntoThis(dbStudent);
          }
        } catch (AssertionError e) {
          System.out.println("Student " + sid + " not found in interests database");
        } catch (Exception e) {
          ProjectErrorHandler.invalidInputError("Error selecting interests traits from database");
        }
      }
    }



  }

  @Override
  public void recommendID(int numRecs, int id) {
    //TODO
    //first, for students, filter by meeting preferences and whether any meeting_times match using bloom filter recommender
    //from those bloom filter recommendations, build a new kdtree using the students' skills
    //run the INVERTED skill scores for this id through the kdtree and return those results
  }

  @Override
  public void recommendTeams(int teamSize) {
    //TODO
    //num_groups = floor(total people / group size)
    //extra_ppl = total ppl % group size //should be between 1 and n-1
    //initialize num_groups empty groups
    //for each empty group:
    //  randomly pick 1 person to start off the group and get their __ nearest neighbors
    //  randomly choose a neighbour x, remove from global list and add to this group
    //  generate nearest neighbors for x and then randomly choose another member x_2 from there and repeat
    //  keep doing this until this group reaches teamSize
    //if extra_people > 0, or if global still has people left, assert it's equal to extra_people
    //for each extra person
    //  randomly choose a group. if that group size==teamSize, add the extra person. else find another group
  }
}
