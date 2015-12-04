package muldrow.csci221.Seed_App;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Benjam on 11/30/2015.
 */
public class FileWriter {

    private FileOutputStream out;
    private StringBuilder newText = new StringBuilder();
    private boolean created = false;

    /**
     * Constructor. Initialized file output stream
     */
    public FileWriter(File file){
        try {
            out = new FileOutputStream(file.getName(), true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a new line to the String to be added to the file
     * @param text to add before new line
     */
    public void println(String text){
        if (!created) {
            newText.append(text + "\n");
        }
    }

    /**
     * Adds text to the stringbuilder to be added to the file
     * @param text to be added
     */
    public void print(String text){
        if (!created){
            newText.append(text);
        }
    }

    /**
     * returns current text
     * @return text
     */
    public String getText(){
        return newText.toString();
    }

    /**
     * writes all data to file
     */
    public void write(){
        created = true;
        try {
            out.flush();
            out.write(newText.toString().getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
