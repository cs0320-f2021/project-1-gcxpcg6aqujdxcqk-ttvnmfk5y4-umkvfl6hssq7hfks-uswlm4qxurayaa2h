package edu.brown.cs.student.kdtree;

import edu.brown.cs.student.recommender.Item;
import edu.brown.cs.student.recommender.Recommender;

import java.util.List;

public class KdTreeRecommender<T extends Item> implements Recommender<T> {

  private KdTree<T> tree;

  public KdTreeRecommender(KdTree<T> kdt) {
    tree = kdt;
  }

  @Override
  public List<T> getTopKRecommendations(T item, int k) {
    return null;
  }

  @Override
  public void printRecommendations(T item, int k) {
    //TODO get then print
  }


}
