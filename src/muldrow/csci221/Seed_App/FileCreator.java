package muldrow.csci221.Seed_App;

import java.io.File;
import java.io.IOException;

/**
 * Created by Benjam on 11/30/2015.
 */
public class FileCreator {

    /**
     * Constructor
     */
    public FileCreator(){}

    /**
     * Creates a file of a specified name.
     * @param dir (file directory)
     * @param fileName (including extension)
     */
    public static void createLocalFile(File dir, String fileName){
        File file = new File(dir, fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
