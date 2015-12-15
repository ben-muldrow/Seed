package muldrow.csci221.Seed_App;

/**
 * Created by Benjam on 12/14/2015.
 */
public class Vegetable extends Plant {

    public Vegetable(String name, int experience, double avgLat, double avgLong) {
        super(name, experience, avgLat, avgLong, "vegetable");
    }

    public Vegetable(String name, int experience, double avgLat, double avgLong, double range) {
        super(name, experience, avgLat, avgLong, "vegetable", range);
    }

}
