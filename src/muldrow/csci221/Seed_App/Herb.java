package muldrow.csci221.Seed_App;

/**
 * Created by Benjam on 12/14/2015.
 */
public class Herb extends Plant {

    public Herb(String name, int experience, double avgLat, double avgLong) {
        super(name, experience, avgLat, avgLong, "herb");
    }

    public Herb(String name, int experience, double avgLat, double avgLong, double range) {
        super(name, experience, avgLat, avgLong, "herb", range);
    }

}
