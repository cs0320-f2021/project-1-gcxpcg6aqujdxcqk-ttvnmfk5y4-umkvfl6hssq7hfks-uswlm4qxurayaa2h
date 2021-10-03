package edu.brown.cs.student.main;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.*;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;

/**
 * Class handles opening JSON files and using fromJSON to create new objects to
 * store data in
 */
public class JsonHandler {


  public static void main(String[] args, String filepath) {
    JSONArray array = readJSONfile(filepath);
    convertJSONList(array);
  }
  // converts our JSON object to a ArrayList object
  private static void convertJSONList(JSONArray array) {
    final ArrayList<?> JSRead = new Gson().fromJson(array.toString(),
        ArrayList.class);
    System.out.println("\nArrayList:" + JSRead);
  }

  // reads JSON file using buffered reader
  private static JSONArray readJSONfile(String filepath) {
    JSONArray newArray = new JSONArray();
    String lineFromFile;

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))) {
      while ((lineFromFile = bufferedReader.readLine()) != null) {
        if (!lineFromFile.isEmpty()) {
          JSONObject jsnObj = new JSONObject();
          System.out.println("Line: ==>" + lineFromFile);

          String[] split = lineFromFile.split(" ");
          jsnObj.put(lineFromFile, split[0]);
        }

      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return newArray;
  }
}