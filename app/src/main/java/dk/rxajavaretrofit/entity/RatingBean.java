package dk.rxajavaretrofit.entity;

import java.io.Serializable;

/**
 * Created by dk on 2016/10/28.
 */

public class RatingBean implements Serializable{

    /**
     * max : 10
     * average : 9.6
     * stars : 50
     * min : 0
     */

    private int max;
    private String average;
    private String stars;
    private int min;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
