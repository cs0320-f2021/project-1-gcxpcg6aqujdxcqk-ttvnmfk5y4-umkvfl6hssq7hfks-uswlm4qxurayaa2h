package edu.brown.cs.student.main;

import edu.brown.cs.student.main.onboarding.StarsHandler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StarsHandlerTest {

  @Test
  public void testCheckNumArgsStarsHandler() {
    String[] arguments = new String[2];
    arguments[0] = "one";
    arguments[1] = "two";
    StarsHandler handler = new StarsHandler();
    assertEquals(handler.checkNumArgs(arguments), true);
  }

  @Test
  public void testGetUsageStringAddHandler() {
    StarsHandler handler = new StarsHandler();
    assertEquals("usage: stars <filename>", handler.getUsageString());
  }
}
