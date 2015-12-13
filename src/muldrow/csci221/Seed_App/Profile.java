package muldrow.csci221.Seed_App;

/**
 * Created by Benjam on 12/8/2015.
 */
public class Profile {

    private User parent;
    public int experience;

    /**
     * constructor
     * @param parent User object
     */
    public Profile(User parent) {
        this.parent = parent;
    }

    /**
     * set Experience value
     * @param experience
     */
    public void setExperience(int experience){
        // TODO: add experience slider
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
