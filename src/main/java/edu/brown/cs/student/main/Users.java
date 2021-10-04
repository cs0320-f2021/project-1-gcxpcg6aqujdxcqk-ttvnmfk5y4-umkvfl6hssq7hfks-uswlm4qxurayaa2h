package edu.brown.cs.student.main;

import java.util.Objects;

public class Users implements JSONObject {
    private final Number user_id;
    private final String weight;
    private final String bust_size;
    private final String height;
    private final Number age;
    private final String body_type;
    private final String horoscope;

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

    /**
     * Gets the three coordinates we're interested in in an array
     * @return [<weight in lbs> <height in inches> <age in years>]
     */
    public int[] getCoordinates() {
        return new int[]{Integer.parseInt(weight), Integer.parseInt(height), (int) age};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Users users = (Users) o;
        return Objects.equals(user_id, users.user_id) &&
            Objects.equals(weight, users.weight) &&
            Objects.equals(bust_size, users.bust_size) &&
            Objects.equals(height, users.height) && Objects.equals(age, users.age) &&
            Objects.equals(body_type, users.body_type) &&
            Objects.equals(horoscope, users.horoscope);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, weight, bust_size, height, age, body_type, horoscope);
    }
}
