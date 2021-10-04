package edu.brown.cs.student.main;

public class Users implements JSONObject {
    private Number user_id;
    private String weight;
    private String bust_size;
    private String height;
    private Number age;
    private String body_type;
    private String horoscope;

    /**
     * This is the constructor for the Clothing class.
     * @param user_id of the item
     * @param weight of the customer
     * @param bust_size of the customer
     * @param height of the customer
     * @param age of the customer
     * @param body_type of the customer
     * @param horoscope of the customer
     */

    public Users(Number user_id, String weight, String bust_size, String height,
                    Number age, String body_type, String horoscope){
        this.user_id = user_id.intValue();
        this.weight = weight;
        this.bust_size = bust_size;
        this.height = height;
        this.age = age.intValue();
        this.body_type = body_type;
        this.horoscope = horoscope;
    }
}
