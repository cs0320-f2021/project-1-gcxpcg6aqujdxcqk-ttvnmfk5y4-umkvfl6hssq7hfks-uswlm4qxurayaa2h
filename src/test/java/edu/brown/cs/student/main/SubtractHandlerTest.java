package edu.brown.cs.student.main;

import edu.brown.cs.student.main.onboarding.SubtractHandler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubtractHandlerTest {

  @Test
  public void testCheckNumArgsSubtractHandler() {
    String[] arguments = new String[3];
    arguments[0] = "add";
    arguments[1] = "1.0";
    arguments[2] = "2.2";
    SubtractHandler handler = new SubtractHandler();
    assertEquals(handler.checkNumArgs(arguments), true);
  }

  @Test
  public void testGetUsageStringSubtractHandler() {
    SubtractHandler handler = new SubtractHandler();
    assertEquals("usage: subtract <int1> <int2>", handler.getUsageString());
  }
}
