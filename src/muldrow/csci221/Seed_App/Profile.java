package muldrow.csci221.Seed_App;

/**
 * Created by Benjam on 12/8/2015.
 */
public class Profile {

    private User parent;
    public String name;
    public int experience;
    public double lat;
    public double longitude;
    public String preference;

    /**
     * constructor
     * @param parent User object
     */
    public Profile(User parent, String name, int experience, double lat, double longitude,
                   String preference) {
        this.parent = parent;
        this.name = name;
        this.experience = experience;
        this.lat = lat;
        this.longitude = longitude;
        this.preference = preference;

    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * return plant preference
     * @return
     */
    public String getPreference() {
        return preference;
    }

    /**
     * set plant preference
     * @param preference
     */
    public void setPreference(String preference) {
        this.preference = preference;
    }

    /**
     * set profile name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns profile name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * set Experience value
     * @param experience
     */
    public void setExperience(int experience){
        this.experience = experience;
    }

    /**
     * returns experience value
     * @return experience int
     */
    public int getExperience() {
        return experience;
    }

    /**
     * returns parent User object
     * @return User
     */
    public User getParent() {
        return parent;
    }

}
