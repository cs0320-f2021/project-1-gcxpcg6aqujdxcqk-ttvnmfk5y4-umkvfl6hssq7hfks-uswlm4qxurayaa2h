package edu.brown.cs.student.api;

import java.util.ArrayList;
import java.util.List;

/**
 * This simple class is for reading the API Key from your secret file (THAT SHOULD NOT BE PUSHED TO GIT).
 */
public class ClientAuth {

  /**
   * Reads the API Key and the CS Login from the secret file.
   *
   * @return a List containing the API Key and CS Login
   */
  public static List<String> getApiKey() {
    List<String> arguments = new ArrayList<>();
    FileParser parser = new FileParser("config/secret/apikey.txt");
    arguments.add(parser.readNewLine());
    arguments.add(parser.readNewLine());
    return arguments;
  }
}