package muldrow.csci221.Seed_App;

import java.io.File;

/**
 * Created by Benjam on 12/3/2015.
 */
public class UserWriter extends FileWriter{

    /**
     * constructor
     * @param file
     * @param append
     */
    public UserWriter(File file, boolean append){
        super(file, append);
    }

    /**
     * add user to users file
     * @param username
     * @param password
     */
    public void addUser(String username, String password){
        super.println(username + "," + password);
        super.write();
    }

    /**
     * add profile to a user
     * @param username
     * @param profileName
     */
    public void addProfile(String username, String profileName){
        super.println(username + ";" + profileName);
        super.write();
    }
}
