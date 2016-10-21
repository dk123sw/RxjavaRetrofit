package dk.rxajavaretrofit.entity;

import java.util.ArrayList;

/**
 * Created by dk on 2016/10/20.
 */

public class GankDate {

    private ArrayList<Gank> results;

    public ArrayList<Gank> getResults() {
        return results;
    }

    public void setResults(ArrayList<Gank> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "GankDate{" +
                "results=" + results +
                '}';
    }
}
