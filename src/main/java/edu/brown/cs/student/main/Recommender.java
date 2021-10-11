package edu.brown.cs.student.main;

public interface Recommender {
  void recommendID(int numRecs, int id);
  void recommendTeams(int teamSize);
}
