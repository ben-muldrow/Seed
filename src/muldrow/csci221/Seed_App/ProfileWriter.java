package muldrow.csci221.Seed_App;

import java.io.File;

/**
 * Created by Benjam on 12/12/2015.
 */
public class ProfileWriter extends FileWriter {

    /**
     * Constructor
     * @param file containing profiles
     */
    public ProfileWriter(File file) {
        super(file,true);
    }

    /**
     * write profile to profile file
     * @param username user that owns profile
     * @param profilename name of profile
     * @param experience experience
     * @param latLong location
     * @param preference plant type preference
     */
    public void writeProfile(String username, String profilename,
                             int experience, double [] latLong,
                             String preference) {
        super.println(username + "," + profilename + ";" + experience + ";" + latLong + ";" + preference);
    }

}
