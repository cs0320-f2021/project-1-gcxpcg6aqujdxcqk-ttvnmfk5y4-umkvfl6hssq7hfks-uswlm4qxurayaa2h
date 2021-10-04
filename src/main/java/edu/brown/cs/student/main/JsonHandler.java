package edu.brown.cs.student.main;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Class handles opening JSON files and using fromJSON to create new objects to
 * store data in
 */
public class JsonHandler {

  private static final Gson gson = new Gson();

    /**
     * Methods takes in the JSON file and returns a Java object
     * @param file which is the String name of the JSON file
     * @return Clothing object in an array
     */

    public String convertFilePath (String file) throws FileNotFoundException {
        StringBuilder returnValue = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                returnValue.append(line);
            }} catch( FileNotFoundException f){
                System.out.println("ERROR: File not found");
            } catch (IOException e) {
            e.printStackTrace();
        }
        return returnValue.toString();

    }

    public Clothing[] convertClothing(String file) throws FileNotFoundException {
        String string = convertFilePath(file);
        return gson.fromJson(string, Clothing[].class);
    }

    public Reviews[] convertReviews (String file) throws FileNotFoundException {
        String string2 = convertFilePath(file);
        return gson.fromJson(string2, Reviews[].class);
    }

    public Users[] convertUsers (String file) throws FileNotFoundException {
        String string3 = convertFilePath(file);
        return gson.fromJson(string3, Users[].class);
    }

    /**
     * Method takes in the json filepath and the type of the file (ie. Clothing,
     * Review, or User) and returns the corresponding JSONObject
     * @param filepath name of json filepath
     * @param type of the java object we want to convert our file into
     * @return JsonObject array
     */
    public JSONObject[] storeData(String filepath, String type) throws FileNotFoundException {
        switch (type) {
            case "clothing":
                return convertClothing(filepath);
            case "reviews":
                return convertReviews(filepath);
            case "users":
                return convertUsers(filepath);
            default:
                return null;
        }
    }

    public void handleArg(String[] arguments) throws FileNotFoundException {
        this.storeData(arguments[1], arguments[2]);
    }
}
