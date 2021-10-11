package edu.brown.cs.student.main;

import edu.brown.cs.student.main.jsonobjects.JSONObject;

import java.util.Objects;

public class Student {
  public class Clothing implements JSONObject {
    private final int id;
    private final String name;
    private final String meeting;
    private final String grade;
    private final int years_of_experience;
    private final String horoscope;
    private final String meeting_times;
    private final String preferred_language;
    private final String marginalized_groups;
    private final String prefer_group;

    /**
     *
     * @param id
     * @param name
     * @param meeting
     * @param grade
     * @param years_of_experience
     * @param horoscope
     * @param meeting_times
     * @param preferred_language
     * @param marginalized_groups
     * @param prefer_group
     */
    public Clothing(Integer id, String name, String meeting, String grade,
                    Integer years_of_experience, String horoscope, String meeting_times,
                    String preferred_language, String marginalized_groups, String prefer_group) {
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
    }

    /**
     * Get ID of jsonObject
     * @return id of review
     */
    public int getId() {
      return id;
    }

    /**
     * Gets the three coordinates we're interested in in an array
     * @return null because this is not a User
     */
    public int[] getUserCoordinates() {
      return new int[]{};
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Clothing clothing = (Clothing) o;
      return id == clothing.id && years_of_experience == clothing.years_of_experience &&
          Objects.equals(name, clothing.name) &&
          Objects.equals(meeting, clothing.meeting) &&
          Objects.equals(grade, clothing.grade) &&
          Objects.equals(horoscope, clothing.horoscope) &&
          Objects.equals(meeting_times, clothing.meeting_times) &&
          Objects.equals(preferred_language, clothing.preferred_language) &&
          Objects.equals(marginalized_groups, clothing.marginalized_groups) &&
          Objects.equals(prefer_group, clothing.prefer_group);
    }

    @Override
    public int hashCode() {
      return Objects.hash(id, name, meeting, grade, years_of_experience, horoscope, meeting_times,
          preferred_language, marginalized_groups, prefer_group);
    }
  }

}
