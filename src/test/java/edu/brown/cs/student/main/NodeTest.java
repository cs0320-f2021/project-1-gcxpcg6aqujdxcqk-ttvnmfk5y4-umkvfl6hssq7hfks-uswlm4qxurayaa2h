package edu.brown.cs.student.main;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import edu.brown.cs.student.main.kdtree.Node;
import org.junit.Test;

import java.util.stream.IntStream;

public class NodeTest {

    /**
     * Tests the method GetCoordinates from Node
     *tests for 1D,2D,3D array and large 10D,40D and 100D arrays
     */

    @Test
    public void testGetCoordinates() {
        //testing for 1D
        Node testNodeOne = new Node(1, 1, new int[]{5});
        int[] oneDimOutput = testNodeOne.getCoordinates();
        int[] oneDimResult = new int[]{5};
        assertArrayEquals(oneDimResult, oneDimOutput);

        //testing for 2D
        Node testNodeTwo = new Node(2, 2, new int[]{5, 4});
        int[]  twoDimOutput = testNodeTwo.getCoordinates();
        int[] twoDimResult = new int[]{5, 4};
        assertArrayEquals(twoDimResult, twoDimOutput);

        //testing for 3D
        Node testNodeThree = new Node(3, 3, new int[]{5, 4, 3});
        int[]  threeDimOutput = testNodeThree.getCoordinates();
        int[] threeDimResult = new int[]{5, 4, 3};
        assertArrayEquals(threeDimResult, threeDimOutput);

        //testing for large
        Node testNodeLargeOne = new Node(10, 10, IntStream.rangeClosed(1, 10).toArray());
        int[]  largeOneDimOutput = testNodeLargeOne.getCoordinates();
        int[] largeOneDimResult = IntStream.rangeClosed(1, 10).toArray(); //are these distinct objects?
        assertArrayEquals(largeOneDimResult, largeOneDimOutput);
        Node testNodeLargeTwo = new Node(40, 40, IntStream.rangeClosed(1, 40).toArray());
        int[]  largeTwoDimOutput = testNodeLargeTwo.getCoordinates();
        int[] largeTwoDimResult = IntStream.rangeClosed(1, 40).toArray();
        assertArrayEquals(largeTwoDimResult, largeTwoDimOutput);
        Node testNodeLargeThree = new Node(100, 100, IntStream.rangeClosed(1, 100).toArray());
        int[]  largeThreeDimOutput = testNodeLargeThree.getCoordinates();
        int[] largeThreeDimResult = IntStream.rangeClosed(1, 100).toArray();
        assertArrayEquals(largeThreeDimResult, largeThreeDimOutput);
    }

    @Test
    public void testGetDistanceFrom(){
        // regular 1D values
        Node testreg1Da = new Node(1, 1, new int[]{29});
        Node testreg1Db = new Node(1, 1, new int[]{34});
        assertEquals((Object)5.0, testreg1Da.getDistanceFrom(testreg1Db.getCoordinates()));

        // all null 1D values
        Node testreg1Dc = new Node(1, 1, new int[]{});
        Node testreg1Dd = new Node(1, 1, new int[]{});
        assertNull(testreg1Dc.getDistanceFrom(testreg1Dd.getCoordinates()));

        // negative 1D values


        //regular 2D values

        //one null 2D value

        //all null 2D value

        //one negative 2D value

        //all negative values


        //regular 3D values

        //one null 3D value

        //two null 3D value

        //all null 3D value

        //one negative value

        //two negative value

        //all negative values



    }

    @Test
    public void testCompareAndGetChild(){
        //greater than 1D
        Node testreg1D = new Node(1, 1, new int[]{64});
        Node testLChild1D = new Node(1, 1, new int[]{35});
        Node testRChild1D = new Node(1, 1, new int[]{72});
        testreg1D.setLChild(testLChild1D);
        testreg1D.setRChild(testRChild1D);

        assertEquals(true, testreg1D.getLChild().getCoordinates()[0] < testreg1D.getRChild().getCoordinates()[0]);
        assertEquals(false, testreg1D.getRChild().getCoordinates()[0] < testreg1D.getCoordinates()[0]);

        Node testLLChild2D = new Node(1, 1, new int[]{35});
        testLChild1D.setLChild(testLLChild2D);

        assertEquals(true, testLChild1D.getLChild().getCoordinates()[0] == testLChild1D.getCoordinates()[0]);
        // smaller than 1D
        Node testLRChild2D = new Node(1, 1, new int[]{42});
        testLChild1D.setRChild(testLRChild2D);
        Node testLRRChild3D = new Node(1, 1, new int[]{44});
        testLRChild2D.setRChild(testLRRChild3D);

        assertEquals(true, testLRChild2D.getRChild().getCoordinates()[0] < testreg1D.getRChild().getCoordinates()[0]);



    }


}