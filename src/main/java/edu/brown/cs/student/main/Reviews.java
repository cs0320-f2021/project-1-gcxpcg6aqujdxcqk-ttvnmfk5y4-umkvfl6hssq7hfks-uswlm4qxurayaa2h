package edu.brown.cs.student.main;

public class Reviews implements JSONObject {
    private String review_text;
    private String review_summary;
    private String review_date;
    private Integer id;

    private Reviews(String review_text, String review_summary,
                    String review_date, Number id){
        this.review_text = review_text;
        this.review_summary = review_summary;
        this.review_date = review_date;
        this.id = id.intValue();

    }

}
