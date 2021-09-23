package edu.brown.cs.student.main;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StarTest {

  @Test
  public void testGetProperName() {
    Star star = new Star(1, "Lonely Star",5,-2.24,10.04);
    assertEquals("Lonely Star", star.getProperName());
  }

  @Test
  public void testX() {
    Star star = new Star(1, "Lonely Star",5,-2.24,10.04);
    assertEquals(5, star.getX(), 0.01);
  }

  @Test
  public void testY() {
    Star star = new Star(1, "Lonely Star",5,-2.24,10.04);
    assertEquals(-2.24, star.getY(), 0.01);
  }

  @Test
  public void testZ() {
    Star star = new Star(1, "Lonely Star",5,-2.24,10.04);
    assertEquals(10.04, star.getZ(), 0.01);
  }

  @Test
  public void testDistance() {
    Star star = new Star(1, "Lonely Star",5,-2.24,10.04);
    star.setDistance(500);
    assertEquals(500, star.getDistance(), 0.01);
  }
}
