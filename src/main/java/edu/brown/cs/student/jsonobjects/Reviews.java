package edu.brown.cs.student.jsonobjects;

import java.util.Objects;

public class Reviews implements JSONObject {
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
     * Get Id of jsonobject
     * @return id of review
     */
    public int getId() { return id; }

    /**
     * Gets the three coordinates we're interested in in an array
     * @return null, since this isn't a user
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
