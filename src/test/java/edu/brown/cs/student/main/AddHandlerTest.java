package edu.brown.cs.student.main;

import edu.brown.cs.student.main.onboarding.AddHandler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddHandlerTest {

  @Test
  public void testCheckNumArgsAddHandler() {
    String[] arguments = new String[3];
    arguments[0] = "add";
    arguments[1] = "1.0";
    arguments[2] = "2.2";
    AddHandler handler = new AddHandler();
    assertEquals(handler.checkNumArgs(arguments), true);
  }

  @Test
  public void testGetUsageStringAddHandler() {
    AddHandler handler = new AddHandler();
    assertEquals("usage: add <int1> <int2>", handler.getUsageString());
  }
}
