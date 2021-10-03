package edu.brown.cs.student.main;

import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Class handles opening JSON files and using fromJSON to create new objects to
 * store data in
 */
public class JsonHandler {

  public void JsonHandler(String string) {
    try {
      // create Gson instance
      Gson gson = new Gson();

      // create a reader
      Reader reader = Files.newBufferedReader(Paths.get(string));

      // convert JSON file to map
      Map<?, ?> map = gson.fromJson(reader, Map.class);

      // print map entries
      for (Map.Entry<?, ?> entry : map.entrySet()) {
        System.out.println(entry.getKey() + "=" + entry.getValue());
      }

      // close reader
      reader.close();

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}
