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
  private final Integer commenting;
  private final Integer testing;
  private final Integer oop;
  private final Integer algorithms;
  private final Integer teamwork;
  private final Integer frontend;

  /**
   * Constructor for the SkillsDbStudent class.
   *
   * @param inputMap map of argument fields and string values
   */
  public SkillsDbStudent(Map<String, String> inputMap) {
    this.id = Integer.parseInt(inputMap.get("id"));
    this.name = inputMap.get("name");

    if (inputMap.get("commenting") != null) {
      this.commenting = Integer.parseInt(inputMap.get("commenting"));
    } else {
      this.commenting = null;
    }

    if (inputMap.get("testing") != null) {
      this.testing = Integer.parseInt(inputMap.get("testing"));
    } else {
      this.testing = null;
    }

    if (inputMap.get("oop") != null) {
      this.oop = Integer.parseInt(inputMap.get("oop"));
    } else {
      this.oop = null;
    }

    if (inputMap.get("algorithms") != null) {
      this.algorithms = Integer.parseInt(inputMap.get("algorithms"));
    } else {
      this.algorithms = null;
    }

    if (inputMap.get("teamwork") != null) {
      this.teamwork = Integer.parseInt(inputMap.get("teamwork"));
    } else {
      this.teamwork = null;
    }

    if (inputMap.get("frontend") != null) {
      this.frontend = Integer.parseInt(inputMap.get("frontend"));
    } else {
      this.frontend = null;
    }
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
  public Integer getCommenting() {
    return commenting;
  }

  /**
   * Returns testing score.
   */
  public Integer getTesting() {
    return testing;
  }

  /**
   * Returns oop score.
   */
  public Integer getOop() {
    return oop;
  }

  /**
   * Returns commenting score.
   */
  public Integer getAlgorithms() {
    return algorithms;
  }

  /**
   * Returns teamwork score.
   */
  public Integer getTeamwork() {
    return teamwork;
  }

  /**
   * Returns frontend score.
   */
  public Integer getFrontend() {
    return frontend;
  }
}
