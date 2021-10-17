package edu.brown.cs.student.main;

import edu.brown.cs.student.main.jsonobjects.JSONObject;
import java.util.Map;

/**
 * This is the SkillsDbStudent class, which holds the data for the object.
 */
public class SkillsDbStudent implements JSONObject {
  /** Fields corresponding to skills table in integration.sqlite3
   * "id"          INTEGER,
   * "name"        TEXT,
   * "commenting"  INTEGER,
   * "testing"     INTEGER,
   * "OOP"         INTEGER,
   * "algorithms"  INTEGER,
   * "teamwork"    INTEGER,
   * "frontend"    INTEGER
   */
  private final int id;
  private final String name;
  private final int commenting;
  private final int testing;
  private final int oop;
  private final int algorithms;
  private final int teamwork;
  private final int frontend;

  /**
   * Constructor for the SkillsDbStudent class.
   *
   * @param inputMap map of argument fields and string values
   */
  public SkillsDbStudent(Map<String, String> inputMap) {
    this.id = Integer.parseInt(inputMap.get("id"));
    this.name = inputMap.get("name");
    this.commenting = Integer.parseInt(inputMap.get("commenting"));
    this.testing = Integer.parseInt(inputMap.get("testing"));
    this.oop = Integer.parseInt(inputMap.get("oop"));
    this.algorithms = Integer.parseInt(inputMap.get("algorithms"));
    this.teamwork = Integer.parseInt(inputMap.get("teamwork"));
    this.frontend = Integer.parseInt(inputMap.get("frontend"));
  }

  /**
   * Get ID of jsonObject.
   *
   * @return id of review
   */
  public int getId() {
    return id;
  }

  /**
   * Gets the three coordinates we're interested in in an array.
   *
   * @return null because this is not used for kdtrees
   */
  public int[] getUserCoordinates() {
    return new int[]{};
  }

  /**
   * Returns commenting score.
   */
  public int getCommenting() {
    return commenting;
  }

  /**
   * Returns testing score.
   */
  public int getTesting() {
    return testing;
  }

  /**
   * Returns oop score.
   */
  public int getOop() {
    return oop;
  }

  /**
   * Returns commenting score.
   */
  public int getAlgorithms() {
    return algorithms;
  }

  /**
   * Returns teamwork score.
   */
  public int getTeamwork() {
    return teamwork;
  }

  /**
   * Returns frontend score.
   */
  public int getFrontend() {
    return frontend;
  }
}
