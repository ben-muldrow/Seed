package muldrow.csci221.Seed_App;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Benjam on 12/3/2015.
 */
public class UserReader extends FileReader {

    /**
     * Constructor
     * @param file containing users data
     */
    public UserReader(File file){
        super(file);
    }

    /**
     * reads the users from the file and returns a hashMap containing all of the users (keys) and
     * their passwords (values)
     * @return HashMap of users
     */
    public HashMap readUsers(){
        HashMap<String, String> users = new HashMap();
        ArrayList<String> lines = super.printLines();
        for (int i = 0; i < lines.size(); i++){
            String[] temp = lines.get(i).split(",");
            users.put(temp[0],temp[1]);
        }
        return users;
    }

    /**
     * checks if a user exists according to the designated users file
     * @param username String
     * @return boolean value of whether or not the user exists
     */
    public boolean userExists(String username) {
        if (readUsers().containsKey(username)){
            return true;
        } else { return false; }
    }

}