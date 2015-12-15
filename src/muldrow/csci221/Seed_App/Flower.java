package muldrow.csci221.Seed_App;

/**
 * Created by Benjam on 12/14/2015.
 */
public class Flower extends Plant {

    public Flower(String name, int experience, double avgLat, double avgLong) {
        super(name, experience, avgLat, avgLong, "flower");
    }

    public Flower(String name, int experience, double avgLat, double avgLong, double range) {
        super(name, experience, avgLat, avgLong, "flower", range);
    }

}
