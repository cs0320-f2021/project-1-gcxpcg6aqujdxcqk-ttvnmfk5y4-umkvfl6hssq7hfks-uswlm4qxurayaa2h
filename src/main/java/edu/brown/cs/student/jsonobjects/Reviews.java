package edu.brown.cs.student.jsonobjects;

import edu.brown.cs.student.recommender.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reviews implements Item {
    private final String review_text;
    private final String review_summary;
    private final String review_date;
    private final Integer id;

    public Reviews(String review_text, String review_summary,
                    String review_date, Number id){
        this.review_text = review_text;
        this.review_summary = review_summary;
        this.review_date = review_date;
        this.id = id.intValue();
    }

    /**
     * Returns the fields of interests that are represented as Strings
     * @return list of relevant Strings
     */
    @Override
    public List<String> getStringVector() {
        List<String> l = new ArrayList<>();
        l.add(review_text);
        l.add(review_summary);
        l.add(review_date);
        return l;
    }

    /**
     * Returns the fields of interests that are represented as Numbers
     * @return list of relevant Numbers
     */
    @Override
    public List<Number> getNumberVector() {
        return new ArrayList<>();
    }

    /**
     * Get Id of Item
     * @return id of review
     */
    public String getId() { return Integer.toString(id); }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reviews reviews = (Reviews) o;
        return Objects.equals(review_text, reviews.review_text) &&
            Objects.equals(review_summary, reviews.review_summary) &&
            Objects.equals(review_date, reviews.review_date) &&
            Objects.equals(id, reviews.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(review_text, review_summary, review_date, id);
    }
}
