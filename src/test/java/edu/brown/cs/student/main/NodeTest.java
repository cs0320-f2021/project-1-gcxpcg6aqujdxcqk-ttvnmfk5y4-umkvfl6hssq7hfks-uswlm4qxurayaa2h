package edu.brown.cs.student.main;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NodeTest {

    /**
     * Tests the method GetCoordinates from Node
     *tests for 1D,2D,3D array and large 10D,40D and 100D arrays
     */

    @Test
    public void testGetCoordinates() {
        //testing for 1D
        Node testNodeOne = new Node(1, 1, new int[]{5});
        int[]  oneDimOutput = testNodeOne.getCoordinates();
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
        assertArrayEquals(threeDimResult, threeDimOutput, 0.01);

        //testing for large
        Node testNodeLargeOne = new Node(10);
        int[]  largeOneDimOutput = testNodeLargeOne.getCoordinates();
        int[] largeOneDimResult = int[10]
        assertEquals(largeOneDimResultDimResult, threeDimOutput, 0.01);
        Node testNodeLargeTwo = new Node(40);
        int[]  largtwoDimOutput = testNode.getCoordinates();
        int[] largeOneDimResult = int[40]
        assertEquals(largeOneDimResultDimResult, threeDimOutput, 0.01);
        Node testNodeLargeThree = new Node(100);
        int[]  largthreeDimOutput = testNodeLargeThree.getCoordinates();
        int[] largeThreeDimResult = int[100]
        assertEquals(largeThreeDimResultDimResultDimResult, largeThreeDimResult, 0.01);
    }

    @Test
    public void testGetDistanceFrom(){
        // regular 1D values
        Node testreg1D = new Node(1);


        //all null 1D values

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
    public void testcompareAndGetChild(){
        //greater than 1D
        Node testreg1D = new Node(1);


        // smaller than 1D

        //same value 1D

        //greater than 2D

        //x and y confusion

        //smaller than 2D

        // x and y confusion

        //same value 2D

        //smaller than 3D

        //x and y confusion

        //greater than 3D

        //x and y confusion

        //same value 3D


    }


}