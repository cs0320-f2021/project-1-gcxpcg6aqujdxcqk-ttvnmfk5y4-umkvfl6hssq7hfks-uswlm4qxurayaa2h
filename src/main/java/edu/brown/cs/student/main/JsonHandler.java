package edu.brown.cs.student.main;

import com.google.gson.Gson;

import java.io.FileNotFoundException;


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
    public Clothing[] convertClothing(String file){
        return gson.fromJson(file, Clothing[].class);
    }

    public Reviews[] convertReviews (String file){
        return gson.fromJson(file, Reviews[].class);
    }

    public Users[] convertUsers (String file){
        return gson.fromJson(file, Users[].class);
    }

    /**
     * Method takes in the json filepath and the type of the file (ie. Clothing,
     * Review, or User) and returns the corresponding JSONObject
     * @param filepath name of json filepath
     * @param type of the java object we want to convert our file into
     * @return JsonObject array
     */
    public JSONObject[] storeData(String filepath, String type) {
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
