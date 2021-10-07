package edu.brown.cs.student.main;

import edu.brown.cs.student.main.onboarding.Star;
import edu.brown.cs.student.main.onboarding.StarComparator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StarComparatorTest {

  @Test
  public void testStar1IsCloser() {
    Star star1 = new Star(1, "Lonely Star",5,5,5);
    Star star2 = new Star(2, "Sol",10,10,10);
    star1.setDistance(0);
    star2.setDistance(10);
    StarComparator comparator = new StarComparator();
    assertEquals(-1, comparator.compare(star1, star2));
  }

  @Test
  public void testStar2IsFarther() {
    Star star1 = new Star(1, "Lonely Star",5,5,5);
    Star star2 = new Star(2, "Sol",10,10,10);
    star1.setDistance(100);
    star2.setDistance(10);
    StarComparator comparator = new StarComparator();
    assertEquals(1, comparator.compare(star1, star2));
  }
}
