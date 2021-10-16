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
    Student s1 = new Student(1, "Gari", "Personally", "Junior", 5.0, "Virgo",
            "Early morning (6:00AM - 9:00AM); Late Night (12:00AM - 3:00AM)",
            "", "", "", 7,
            3, 9 , 2, 6, 10);
    Student s1API = new Student(1, "Gari", "Personally", "Junior", 5.0, "Virgo",
            "Early morning (6:00AM - 9:00AM); Late Night (12:00AM - 3:00AM)",
            "", "", "", null,
            null, null , null, null, null);
    HashSet<Student> s1HashSet = new HashSet<>();
    s1HashSet.add(s1);
    
    HashSet<Student> realstudentHashSet1 = new HashSet<>();
    realstudentHashSet1.add(s1API);

    StudentRecommender sr1 = new StudentRecommender(realstudentHashSet1, "data/project-1/integration.sqlite3");


    assertEquals(s1, sr1.getStudentsArray()[0]);

    Student s2 = new Student(2, "Minerva McGongall", "Personally",
            "Grad", 17, "Libra",
            "Early morning (6:00AM - 9:00AM); Late Night (12:00AM - 3:00AM)",
            "", "", "",
            null, null, null, null, null, null);
    Student s2API = new Student(2, "Minerva McGongall", "Personally",
            "Grad", 17, "Libra",
            "Early morning (6:00AM - 9:00AM); Late Night (12:00AM - 3:00AM)",
            "", "", "",
            null, null, null, null, null, null);
    HashSet<Student> s2HashSet = new HashSet<>();
    s2HashSet.add(s2);

    HashSet<Student> realstudentHashSet2 = new HashSet<>();
    realstudentHashSet2.add(s2API);
  }

}
