package edu.brown.cs.student.main;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.HashSet;

import static org.junit.Assert.*;


public class StudentRecommenderTest {
  /**
   * Test the constructor which merges API and database data
   */
  @Test
  public void testStudentRecommender() {
    //TODO get some example rows in here, or read in from json for testing purposes, and then add to studentHashSet1
    //Student s1 = new Student(1, "danny", "");
    HashSet<Student> studentHashSet1 = new HashSet<>();

    StudentRecommender sr1 = new StudentRecommender(studentHashSet1, "data/project-1/integration.sqlite3");

    assertEquals(sr1.getStudentsArray(), realStudentsArray);
  }

}
