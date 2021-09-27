package edu.brown.cs.student.main;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.JSONObject;
import java.lang.Math;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;




/**
 * Class handles opening JSON files and using fromJSON to create new objects to
 * store data in
 */
public class JsonHandler {

    public static void main (String[] args){
        JSONList array = readJSONfile();
        convertJSONList(array);
    }

    private static void convertJSONList(JsonArray array) {
    final ArrayList<?> JSRead = new Gson().fromJson(array.toString(), ArrayList.class);
    log("\nArrayList:" + JSRead);
    }

    private static JsonArray readJSONfile() {
        JSONArray newArray = new JSONArray();
        String lineFromFile;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(lineFromFile))){
            while ((lineFromFile = bufferedReader.readLine()) != null) {
                if (!lineFromFile.isEmpty()) {
                    JSONObject jsnObj = new JSONObject();
                    log("Line: ==>" + lineFromFile);

                    String split = lineFromFile.split(" ");

                }

    }

} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
