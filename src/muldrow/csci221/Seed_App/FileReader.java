package muldrow.csci221.Seed_App;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Benjam on 11/30/2015.
 */
public class FileReader {

    private InputStream in;
    private Reader reader;
    private BufferedReader bufferedReader;
    private File file;

    /**
     * Constructor.
     * @param file to read from
     */
    public FileReader(File file){
        this.file = file;
    }

    public ArrayList<String> printLines() {
        ArrayList<String> lines = new ArrayList<String>();
        try {
            in = new FileInputStream(file);
            reader = new InputStreamReader(in, "UTF-8");
            bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            while (line != null) {
                lines.add(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return lines;
    }

}