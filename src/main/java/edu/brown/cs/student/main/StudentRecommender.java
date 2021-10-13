package edu.brown.cs.student.main;

import edu.brown.cs.student.main.jsonobjects.JSONObject;

public class StudentRecommender implements Recommender {
  public void loadDataAPI(JSONObject[] jsonObjects) {
    //TODO load in the api data
  }

  public void loadDataORM() {
    //TODO go through the api data and look up each id in the database and fill it in
  }

  @Override
  public void recommendID(int numRecs, int id) {
    //TODO
    //first, for students, filter by meeting preferences and whether any meeting_times match using bloom filter recommender
    //from those bloom filter recommendations, build a new kdtree using the students' skills
    //run the INVERTED skill scores for this id through the kdtree and return those results
  }

  @Override
  public void recommendTeams(int teamSize) {
    //TODO
    //num_groups = floor(total people / group size)
    //extra_ppl = total ppl % group size //should be between 1 and n-1
    //initialize num_groups empty groups
    //for each empty group:
    //  randomly pick 1 person to start off the group and get their __ nearest neighbors
    //  randomly choose a neighbour x, remove from global list and add to this group
    //  generate nearest neighbors for x and then randomly choose another member x_2 from there and repeat
    //  keep doing this until this group reaches teamSize
    //if extra_people > 0, or if global still has people left, assert it's equal to extra_people
    //for each extra person
    //  randomly choose a group. if that group size==teamSize, add the extra person. else find another group
  }
}
