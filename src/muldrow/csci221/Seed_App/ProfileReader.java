package muldrow.csci221.Seed_App;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Benjam on 12/13/2015.
 */
public class ProfileReader extends FileReader {

    /**
     * constructor
     * @param file
     */
    public ProfileReader(File file){
        super(file);
    }

    public Profile readProfile(String username) {
        ArrayList<String> profiles = super.printLines();
        int indexOfLastProfile = -1;
        for (int i = 0; i < profiles.size(); i++) {
            if (profiles.get(i).split(",")[0].equals(username)) {
                indexOfLastProfile = i;
            }
        }

        // Spaghetti code
        if (indexOfLastProfile == -1) {
            return null;
        }

        String [] profileData = profiles.get(indexOfLastProfile).split(",");
        String newUsername = profileData[0];
        String [] attributes = profileData[1].split(";");

        if (newUsername.equals(User.getActiveUser().getUsername())) {
            return new Profile(User.getActiveUser(), attributes[0] , Integer.parseInt(attributes[1]),
                    Double.parseDouble(attributes[2]), Double.parseDouble(attributes[3]), attributes[4]);
        } else { return null; }
    }

    /**
     * checks if a user has a profile already
     * @param u user
     * @return boolean true or false
     */
    public boolean profileExists(User u) {
        if ((readProfile(u.getUsername())) == null) {
            return false;
        } else {
            return true;
        }
    }
}