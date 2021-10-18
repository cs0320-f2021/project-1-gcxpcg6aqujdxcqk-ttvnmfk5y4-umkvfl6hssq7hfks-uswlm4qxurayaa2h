package edu.brown.cs.student.main;

import edu.brown.cs.student.main.jsonobjects.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This is the Student class, which holds the data for the object.
 */
public class Student implements JSONObject {
  private final int id;
  private final String name;
  private final String meeting;
  private final String grade;
  private final double years_of_experience;
  private final String horoscope;
  private final String meeting_times;
  private final String preferred_language;
  private final String marginalized_groups;
  private final String prefer_group;


  //  private final int skillsID;
  //  private final String skillsName;
  private Integer commenting;
  private Integer testing;
  private Integer oop;
  private Integer algorithms;
  private Integer teamwork;
  private Integer frontend;

  /**
   * Constructor for the Student class.
   *
   * @param id of the student
   * @param name of the student
   * @param meeting zoom or in person
   * @param grade of the student
   * @param years_of_experience coding
   * @param horoscope of the student
   * @param meeting_times of the student
   * @param preferred_language of the student
   * @param marginalized_groups or identity
   * @param prefer_group of similar identity
   * @param commenting ability
   * @param testing ability
   * @param oop ability
   * @param algorithms ability
   * @param teamwork ability
   * @param frontend ability
   */
  public Student(int id, String name, String meeting, String grade,
                  double years_of_experience, String horoscope, String meeting_times,
                  String preferred_language, String marginalized_groups, String prefer_group,
                 Integer commenting, Integer testing, Integer oop, Integer algorithms,
                 Integer teamwork, Integer frontend) {
    this.id = id;
    this.name = name;
    this.meeting = meeting;
    this.grade = grade;
    this.years_of_experience = years_of_experience;
    this.horoscope = horoscope;
    this.meeting_times = meeting_times;
    this.preferred_language = preferred_language;
    this.marginalized_groups = marginalized_groups;
    this.prefer_group = prefer_group;
    //    this.skillsID = skillsID;
    //    this.skillsName = skillsName;
    this.commenting = commenting;
    this.testing = testing;
    this.oop = oop;
    this.algorithms = algorithms;
    this.teamwork = teamwork;
    this.frontend = frontend;
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
   * @return null because this is not a User
   */
  public int[] getUserCoordinates() {
    return new int[]{};
  }


  /**
   * Takes in a SkillsDbStudent and merges into this student.
   * TODO create a generic interface for Db results that includes SkillsDbStudent
   *
   * @param dbStudent to merge into our Student object
   */
  public void mergeSkillsDbStudent(SkillsDbStudent dbStudent) {
    if (dbStudent.getId() != this.id) {
      ProjectErrorHandler.invalidInputError(
          "mergeStudents can only merge Students with the same id");
    } else {
      this.commenting = dbStudent.getCommenting();
      this.testing = dbStudent.getTesting();
      this.oop = dbStudent.getOop();
      this.algorithms = dbStudent.getAlgorithms();
      this.teamwork = dbStudent.getTeamwork();
      this.frontend = dbStudent.getFrontend();
    }
  }


  /**
   * Returns a list of all the fields from the API that are only in the API;
   * does not include id or name.
   *
   * @return List<Object> containing data from the API
   */
  public List<Object> getDataAPI() {
    List<Object> list = new ArrayList<Object>();
    list.add(this.meeting);
    list.add(this.grade);
    list.add(this.years_of_experience);
    list.add(this.horoscope);
    list.add(this.meeting_times);
    list.add(this.preferred_language);
    list.add(this.marginalized_groups);
    list.add(this.prefer_group);
    return list;
  }

  /**
   * Returns a list of all the fields from the database that are only in the database;
   * does not include id or name.
   *
   * @return List<Object> containing data from the API
   */
  public List<Object> getDataORM() {
    List<Object> list = new ArrayList<Object>();
    list.add(this.commenting);
    list.add(this.testing);
    list.add(this.oop);
    list.add(this.algorithms);
    list.add(this.teamwork);
    list.add(this.frontend);
    return list;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return id == student.id && years_of_experience == student.years_of_experience
        // && skillsID == student.skillsID
        && Objects.equals(commenting, student.commenting)
        && Objects.equals(testing, student.testing) && Objects.equals(oop, student.oop) &&
        Objects.equals(algorithms, student.algorithms)
        && Objects.equals(teamwork, student.teamwork) && Objects.equals(frontend, student.frontend)
        && Objects.equals(name, student.name)
        && Objects.equals(meeting, student.meeting)
        && Objects.equals(grade, student.grade)
        && Objects.equals(horoscope, student.horoscope)
        && Objects.equals(meeting_times, student.meeting_times)
        && Objects.equals(preferred_language, student.preferred_language)
        && Objects.equals(marginalized_groups, student.marginalized_groups)
        && Objects.equals(prefer_group, student.prefer_group);
    //  && Objects.equals(skillsName, student.skillsName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, meeting, grade, years_of_experience, horoscope, meeting_times,
        preferred_language, marginalized_groups, prefer_group, commenting, testing,
        oop,
        algorithms, teamwork, frontend);
  }
}
