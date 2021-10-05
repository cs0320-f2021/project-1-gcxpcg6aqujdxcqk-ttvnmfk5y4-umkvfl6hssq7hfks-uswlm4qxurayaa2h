package edu.brown.cs.student.main;

import org.json.JSONArray;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class JSONHandlerTest {

    @Test
    /**
     * Testing the convertClothing method from JsonHandler class
     */
    public void testConvertClothing() throws FileNotFoundException {
        JsonHandler jh = new JsonHandler();
        Clothing[] clothingArray = jh.convertClothing("data/project-1/justrentSMALL.json");
        Clothing clothingTest = new Clothing("fit", 420272,
                2260466, "10", "vacation",
                "romper", 14, 1);
        assertEquals(clothingArray[0], clothingTest);
    }

    @Test
    /**
     * Testing the convertReview method from JsonHandler class
     */
    public void testConvertReview() throws FileNotFoundException{
        JsonHandler jh = new JsonHandler();
        Reviews[] reviewsArray = jh.convertReviews("data/project-1/justreviewsSMALL.json");
        Reviews reviewsTest = new Reviews("I rented this dress for a " +
                "photo shoot. The theme was \"Hollywood Glam and Big Beautiful " +
                "Hats\". The dress was very comfortable and easy to move around " +
                "in. It is definitely on my list to rent again for another formal " +
                "event. ", "I felt so glamourous!!!", "June 18, 2013",2);

        assertEquals(reviewsArray[1], reviewsTest);
    }

    @Test
    /**
     * Testing the convertUsers method from JsonHandler class
     */
    public void testConvertUsers() throws FileNotFoundException{
        JsonHandler jh = new JsonHandler();
        Users[] usersArray = jh.convertUsers("data/project-1/justusersSMALL.json");
        Users usersTest = new Users(151944, "145lbs",
                "34b", "5' 9\"", 27, "athletic",
                "Libra");
        assertEquals(usersArray[0], usersTest);
    }

    @Test
    /**
     * Testing storeData method from JsonHandler class
     */
    public void testStoreData() throws FileNotFoundException{

    }

}
