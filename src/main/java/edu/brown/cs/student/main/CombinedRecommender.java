package edu.brown.cs.student.main;

import edu.brown.cs.student.bloomfilter.BloomFilter;
import edu.brown.cs.student.jsonobjects.JSONObject;
import edu.brown.cs.student.orm.Database;
import edu.brown.cs.student.recommender.Item;
import edu.brown.cs.student.recommender.Recommender;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This combined recommender takes in a HashMap of recommendation strategies and the items they
 * should be used on...?
 * @param <T>
 */
public class CombinedRecommender<T extends Item> implements Recommender<T> {
  HashMap<Recommender<T>, List<T>> itemSets;

  public void loadDataAPI(JSONObject[] jsonObjects) {
    //TODO make able to load in from API? or do that outside?
  }

  /**
   * Loads data from ORM source and puts in
   * @param dbName
   */
  public void loadDataORM(String dbName) {
    try {
      Database db = new Database(dbName);
      Map<String, String> queryParams = new HashMap<>();
      //Student List<Student> = db.select(Student<>, ); //TODO how to make this work, or do this outside?
    } catch (Exception e) {
      //e.printStackTrace();
      ProjectErrorHandler.invalidInputError("invalid db name");
    }


  }

  @Override
  public List<T> getTopKRecommendations(T item, int k) {
    //TODO go through each of the strategies and then combine them all and return
    return null;
  }

  @Override
  public void printRecommendations(T item, int k) {
    //TODO call getTopK and then print them
  }
}
