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
  public void testStudentRecommender1() {
    //TODO get some example rows in here, or read in from json for testing purposes, and then add to studentHashSet1
    Student s1 = new Student(1, "Gari", "Personally", "Junior", 5.0, "Virgo",
            "Early morning (6:00AM - 9:00AM); Late Night (12:00AM - 3:00AM)",
            "", "", "", 7,
            3, 9 , 2, 6, 10);
    Student s1API = new Student(1, "Gari", "Personally", "Junior", 5.0, "Virgo",
            "Early morning (6:00AM - 9:00AM); Late Night (12:00AM - 3:00AM)",
            "", "", "", null,
            null, null , null, null, null);

    HashSet<Student> realstudentHashSet1 = new HashSet<>();
    realstudentHashSet1.add(s1API);

    Student s2 = new Student(2, "Minerva McGongall", "Personally",
            "Grad", 17, "Libra",
            "Early morning (6:00AM - 9:00AM); Late Night (12:00AM - 3:00AM)",
            "", "", "",
            8,	4,	2,8,7,10);
    Student s2API = new Student(2, "Minerva McGongall", "Personally",
            "Grad", 17, "Libra",
            "Early morning (6:00AM - 9:00AM); Late Night (12:00AM - 3:00AM)",
            "", "", "",
            null, null, null, null, null, null);
    realstudentHashSet1.add(s2API);

    StudentRecommender sr1 = new StudentRecommender(realstudentHashSet1, "data/project-1/integration.sqlite3");

    assertEquals(s1, sr1.getStudentsArray()[0]);

    assertEquals(s2, sr1.getStudentsArray()[1]);


  }

  /**
   * Test the constructor which merges API and database data using a list of fake
   * students (separate from what we were given); table of skills is in
   * emptyEditable.sqlite3
   */
  @Test
  public void TestStudentRecommender2(){
    Student s1Fake = new Student(1, "Kat", "Personally", "Junior", 2.0, "Sagittarius",
            "Late Night (12:00AM - 3:00AM)", "",
            "Woman, POC", "Yes", 4,
            3, 6 , 6, 10, 1);
    Student s1API = new Student(1, "Kat", "Personally", "Junior", 2.0, "Sagittarius",
            "Late Night (12:00AM - 3:00AM)", "",
            "Woman, POC", "Yes", null,
            null, null , null, null, null);

    HashSet<Student> realstudentHashSet1 = new HashSet<>();
    realstudentHashSet1.add(s1API);

    Student s2Fake = new Student(2, "Panda", "Zoom",
            "Freshman", 25, "Taurus",
            "Evening (6:00PM - 9:00PM); Late Night (12:00AM - 3:00AM)",
            "C", "", "Yes", null,
            10,	10,10,10,10);
    Student s2API = new Student(2, "Panda", "Zoom",
            "Freshman", 25, "Taurus",
            "Evening (6:00PM - 9:00PM); Late Night (12:00AM - 3:00AM)",
            "C", "", "Yes",
            null, null, null, null, null, null);

    realstudentHashSet1.add(s2API);

    Student s3Fake = new Student(3, "Sheridan", "Personally",
            "Junior", 5, "Libra",
            "Early morning (6:00AM - 9:00AM)",
            "", "Woman, POC", "No", null,
            9,	9,9,9,10);
    Student s3API = new Student(3, "Sheridan", "Personally",
            "Junior", 5, "Libra",
            "Early morning (6:00AM - 9:00AM)",
            "", "Woman, POC", "No",
            null, null, null, null, null, null);
    realstudentHashSet1.add(s3API);


    StudentRecommender sr1Fake = new StudentRecommender(realstudentHashSet1, "data/project-1/emptyEditable.sqlite3");

    assertEquals(s1Fake, sr1Fake.getStudentsArray()[0]);
    assertNotEquals(s2Fake, sr1Fake.getStudentsArray()[1]);
    assertEquals(s3Fake, sr1Fake.getStudentsArray()[2]);



  }

}
