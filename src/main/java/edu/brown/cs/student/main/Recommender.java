package edu.brown.cs.student.main;

/**
 * The Recommender interface ensures that all recommenders have their essential functions.
 */
public interface Recommender {
  void recommendID(int numRecs, int id);

  void recommendTeams(int teamSize);
}
