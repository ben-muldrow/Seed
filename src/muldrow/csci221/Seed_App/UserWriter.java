package muldrow.csci221.Seed_App;

import java.io.File;

/**
 * Created by Benjam on 12/3/2015.
 */
public class UserWriter extends FileWriter{

    public UserWriter(File file, boolean append){
        super(file, append);
    }

    public void addUser(String username, String password){
        super.println(username + "," + password);
        super.write();
    }
}
