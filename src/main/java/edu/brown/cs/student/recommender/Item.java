package edu.brown.cs.student.recommender;

import java.util.List;

public interface Item {
  List<String> getStringVector();
  List<Number> getNumberVector();
  String getId();
}
