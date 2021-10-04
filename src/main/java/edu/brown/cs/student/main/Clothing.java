package edu.brown.cs.student.main;

import java.util.Objects;

public class Clothing implements JSONObject {
    private String fit;
    private int user_id;
    private int item_id;
    private String rating;
    private String rented_for;
    private String height;
    private String category;
    private int size;
    private int id;

    /**
     * This is the constructor for the Clothing class.
     * @param fit of the item
     * @param user_id of the customer
     * @param item_id of the customer
     * @param rating of the customer
     * @param rented_for of the customer
     * @param height of the customer
     * @param category of the customer
     * @param size of the customer
     * @param id of the customer
     */

    public Clothing(String fit, int user_id, int item_id, String rating,
                    String category, int size, int id){
        this.fit = fit;
        this.user_id = user_id;
        this.item_id = item_id;
        this.rating = rating;
        this.category = category;
        this.size = size;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Clothing clothing = (Clothing) o;
        return user_id == clothing.user_id && item_id == clothing.item_id &&
            size == clothing.size &&
            id == clothing.id && Objects.equals(fit, clothing.fit) &&
            Objects.equals(rating, clothing.rating) &&
            Objects.equals(rented_for, clothing.rented_for) &&
            Objects.equals(height, clothing.height) &&
            Objects.equals(category, clothing.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fit, user_id, item_id, rating, rented_for, height, category, size, id);
    }
}
