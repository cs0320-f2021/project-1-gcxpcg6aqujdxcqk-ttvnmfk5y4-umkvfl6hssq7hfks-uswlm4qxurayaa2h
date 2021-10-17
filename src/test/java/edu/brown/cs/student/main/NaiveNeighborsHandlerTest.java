package edu.brown.cs.student.main;

import edu.brown.cs.student.main.onboarding.NaiveNeighborsHandler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NaiveNeighborsHandlerTest {

  @Test
  public void testCheckNumArgsNaiveNeighborsHandlerThree() {
    String[] arguments = new String[3];
    arguments[0] = "one";
    arguments[1] = "two";
    arguments[2] = "three";
    NaiveNeighborsHandler handler = new NaiveNeighborsHandler();
    assertEquals(handler.checkNumArgs(arguments), true);
  }

  @Test
  public void testCheckNumArgsNaiveNeighborsHandlerFive() {
    String[] arguments = new String[5];
    arguments[0] = "one";
    arguments[1] = "two";
    arguments[2] = "three";
    arguments[3] = "four";
    arguments[4] = "five";
    NaiveNeighborsHandler handler = new NaiveNeighborsHandler();
    assertEquals(handler.checkNumArgs(arguments), true);
  }

  @Test
  public void testGetUsageStringNaiveNeighborsHandler() {
    NaiveNeighborsHandler handler = new NaiveNeighborsHandler();
    assertEquals("usage: naive_neighbors <k> <star_id>\n" +
        "       naive_neighbors <k> <x> <y> <z>", handler.getUsageString());
  }
}
