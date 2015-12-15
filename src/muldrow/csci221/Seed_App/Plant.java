package muldrow.csci221.Seed_App;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Benjam on 12/14/2015.
 */
public class Plant {

    public String name;
    public int minExperience;
    public double avgLat;
    public double avgLong;
    public double range = -1;
    public String type;
    public String color = null;
    public String exposure = null;
    public String commonName = null;
    public String imageFileName;

    /**
     * Create a new plant
     * @param name
     * @param minExperience
     * @param avgLat
     * @param avgLong
     * @param type
     */
    public Plant(String name, int minExperience, double avgLat, double avgLong, String type){
        this.name = name;
        this.minExperience = minExperience;
        this.avgLat = avgLat;
        this.avgLong = avgLong;
        this.type = type;
    }

    /**
     * constructor with range
     * @param name
     * @param minExperience
     * @param avgLat
     * @param avgLong
     * @param type
     * @param range
     */
    public Plant(String name, int minExperience, double avgLat, double avgLong, String type, double range){
        this.name = name;
        this.minExperience = minExperience;
        this.avgLat = avgLat;
        this.avgLong = avgLong;
        this.type = type;
        this.range = range;
    }

    /**
     * add some example plants for presentation purposes
     */
    public static ArrayList<Plant> getExamplePlants() {

        // I was unable to use a rest API source for the example plants. I found these from
        // http://www.garden.org/ (along with their images)

        Herb paprika = new Herb("Achillea millefolium", 2, 30, 79, 20);
        paprika.setCommonName("Paprika");
        paprika.setColor("Red");
        paprika.setExposure("Partial Sun");
        paprika.imageFileName = "paprika.jpg";

        Herb dill = new Herb("Anethum graveolens", 5, 50, 50, 100);
        dill.setCommonName("Dill");
        dill.setColor("Yellow");
        dill.setExposure("Full Sun");
        paprika.imageFileName = "dill.jpg";

        Herb saffron = new Herb("Colchicum autumnale", 6, 5, 5, 40);
        saffron.setCommonName("saffron");
        saffron.setColor("Pink");
        saffron.setExposure("Partial Sun");
        saffron.imageFileName = "saffron.jpg";

        Flower poinsettia = new Flower("Euphorbia pulcherrima", 3, 40, 50, 60);
        poinsettia.setCommonName("Poinsettia");
        poinsettia.setColor("Red");
        poinsettia.setExposure("Partial Sun");
        poinsettia.imageFileName="poinsettia.jpg";

        ArrayList<Plant> plants = new ArrayList<Plant>();
        plants.add(paprika);
        plants.add(dill);
        plants.add(saffron);
        plants.add(poinsettia);

        return plants;
    }

    /**
     * get common name
     * @return
     */
    public String getCommonName() {
        return commonName;
    }

    /**
     * set common name
     * @param commonName
     */
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    /**
     * get color of plant
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * set color of plant
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * get exposure required for growth
     * @return
     */
    public String getExposure() {
        return exposure;
    }

    /**
     * get exposure
     * @param exposure
     */
    public void setExposure(String exposure) {
        this.exposure = exposure;
    }

    /**
     * get range
     * @return
     */
    public double getRange() {
        return range;
    }

    /**
     * set range
     * @param range
     */
    public void setRange(double range) {
        this.range = range;
    }

    /**
     * get name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * set name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get minimum experience required
     * @return
     */
    public int getMinExperience() {
        return minExperience;
    }

    /**
     * set minimum experience required
     * @param minExperience
     */
    public void setMinExperience(int minExperience) {
        this.minExperience = minExperience;
    }

    /**
     * get average latitude
     * @return
     */
    public double getAvgLat() {
        return avgLat;
    }

    /**
     * set average latitude
     * @param avgLat
     */
    public void setAvgLat(double avgLat) {
        this.avgLat = avgLat;
    }

    /**
     * get average longitude
     * @return
     */
    public double getAvgLong() {
        return avgLong;
    }

    /**
     * set average longitude
     * @param avgLong
     */
    public void setAvgLong(double avgLong) {
        this.avgLong = avgLong;
    }

    /**
     * get type
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * set type
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
}
