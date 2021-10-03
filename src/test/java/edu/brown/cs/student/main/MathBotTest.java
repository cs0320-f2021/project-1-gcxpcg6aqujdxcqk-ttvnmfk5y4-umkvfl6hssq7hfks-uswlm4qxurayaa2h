package edu.brown.cs.student.main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MathBotTest {

  @Test
  public void testAddition() {
    MathBot matherator9000 = new MathBot();
    double output = matherator9000.add(10.5, 3);
    assertEquals(13.5, output, 0.01);
  }

  @Test
  public void testLargerNumbers() {
    MathBot matherator9001 = new MathBot();
    double output = matherator9001.add(100000, 200303);
    assertEquals(300303, output, 0.01);
  }

  @Test
  public void testSubtraction() {
    MathBot matherator9002 = new MathBot();
    double output = matherator9002.subtract(18, 17);
    assertEquals(1, output, 0.01);
  }

  @Test
  public void testAddZero() {
    MathBot mathBot = new MathBot();
    double output = mathBot.add(0, 0);
    assertEquals(0, output, 0.01);
  }

  @Test
  public void testAddNegative() {
    MathBot mathBot = new MathBot();
    double output = mathBot.add(-10, -20);
    assertEquals(-30, output, 0.01);
  }

  @Test
  public void testAddDecimal() {
    MathBot mathBot = new MathBot();
    double output = mathBot.add(10.628000, 1.00000000);
    assertEquals(11.628, output, 0.01);
  }

  @Test
  public void testSubtractZero() {
    MathBot mathBot = new MathBot();
    double output = mathBot.subtract(0, 0);
    assertEquals(0, output, 0.01);
  }

  @Test
  public void testSubtractNegative() {
    MathBot mathBot = new MathBot();
    double output = mathBot.subtract(-100, -10);
    assertEquals(-90, output, 0.01);
  }

  @Test
  public void testSubtractDecimal() {
    MathBot mathBot = new MathBot();
    double output = mathBot.subtract(10.01, 1.01);
    assertEquals(9.0, output, 0.01);
  }

  @Test
  public void testSubtractNegativeToPositive() {
    MathBot mathBot = new MathBot();
    double output = mathBot.subtract(-1, -10.10);
    assertEquals(9.10, output, 0.01);
  }

}
