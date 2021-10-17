package edu.brown.cs.student.main.jsonobjects;

import com.google.gson.Gson;
import edu.brown.cs.student.main.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class handles opening JSON files and using fromJSON to store data in specified objects.
 */
public class JsonHandler {
  private static final Gson gson = new Gson();

  /**
   * Methods takes in the JSON file and returns a Java object.
   *
   * @param file which is the String name of the JSON file
   * @return Clothing object in an array
   */
  public String convertFileToString(String file) throws FileNotFoundException {
    StringBuilder returnValue = new StringBuilder();
    BufferedReader br;
    try {
      br = new BufferedReader(new FileReader(file));
      String line;
      while ((line = br.readLine()) != null) {
        returnValue.append(line);
      }
    } catch (FileNotFoundException f) {
      System.out.println("ERROR: File not found");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return returnValue.toString();
  }

  /**
   * This method converts the contents of a JSON file to a Clothing object and returns a list
   * of Clothing objects.
   *
   * @param file name
   * @return List of Clothing objects
   * @throws FileNotFoundException if file is not found
   */
  public Clothing[] convertClothing(String file) throws FileNotFoundException {
    String string = convertFileToString(file);
    return gson.fromJson(string, Clothing[].class);
  }

  /**
   * This method converts the contents of a JSON file to a Reviews object and returns a list
   * of Reviews objects.
   *
   * @param file name
   * @return List of Reviews objects
   * @throws FileNotFoundException if file is not found
   */
  public Reviews[] convertReviews(String file) throws FileNotFoundException {
    String string2 = convertFileToString(file);
    return gson.fromJson(string2, Reviews[].class);
  }

  /**
   * This method converts the contents of a JSON file to a Users object and returns a list
   * of Users objects.
   *
   * @param file name
   * @return List of Users objects
   * @throws FileNotFoundException if file is not found
   */
  public Users[] convertUsers(String file) throws FileNotFoundException {
    String string3 = convertFileToString(file);
    return gson.fromJson(string3, Users[].class);
  }

  /**
   * This method converts the contents of a JSON file to a Student object and returns a list
   * of Student objects.
   *
   * @param file name
   * @return List of Student objects
   * @throws FileNotFoundException if file is not found
   */
  public Student[] convertStudent(String file) throws FileNotFoundException {
    String string = convertFileToString(file);
    return gson.fromJson(string, Student[].class);
  }

  /**
   * This method converts a JSON string to a Clothing object and returns a list
   * of Clothing objects.
   *
   * @return List of Clothing objects
   */
  public Clothing[] convertClothingFromAPI(String string) {
    return gson.fromJson(string, Clothing[].class);
  }

  /**
   * This method converts a JSON string to a Reviews object and returns a list
   * of Reviews objects.
   *
   * @return List of Reviews objects
   */
  public Reviews[] convertReviewsFromAPI(String string) {
    return gson.fromJson(string, Reviews[].class);
  }

  /**
   * This method converts a JSON string to a Users object and returns a list
   * of Users objects.
   *
   * @return List of Users objects
   */
  public Users[] convertUsersFromAPI(String string) {
    return gson.fromJson(string, Users[].class);
  }

  /**
   * This method converts a JSON string to a Student object and returns a list
   * of Student objects.
   *
   * @return List of Student objects
   */
  public Student[] convertStudentFromAPI(String string) {
    return gson.fromJson(string, Student[].class);
  }

  /**
   * Method takes in the JSON filepath and the type of the file (i.e. Clothing,
   * Review, or User) and returns the corresponding JSONObject.
   *
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

  /**
   * This method takes in the arguments from the REPL and passes them to the storeData method.
   *
   * @param arguments from the REPL
   * @throws FileNotFoundException if the file is not found
   */
  public void handleArg(String[] arguments) throws FileNotFoundException {
    this.storeData(arguments[1], arguments[2]);
  }
}
