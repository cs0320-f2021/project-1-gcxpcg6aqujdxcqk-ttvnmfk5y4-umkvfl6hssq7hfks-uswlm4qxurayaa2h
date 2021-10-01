package edu.brown.cs.student.main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MathBotTest {

    @Test
    public void testGetCoordinates() {
        Node testNode = new Node(1);
        int[]  oneDimOutput = testNode.getCoordinates();
        //how do I represent an empty array
        int[] output = matherator9000.add(10.5, 3);
        assertEquals(13.5, output, 0.01);
    }



  }}