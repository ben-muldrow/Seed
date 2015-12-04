package muldrow.csci221.Seed_App;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Benjam on 11/30/2015.
 */
public class FileReader {

    private InputStream in;
    private Reader reader;
    private BufferedReader bufferedReader;

    /**
     * Constructor.
     * @param filename to read from
     */
    public FileReader(File file){
        try {
            in = new FileInputStream(file);
            reader = new InputStreamReader(in, "UTF-8");
            bufferedReader = new BufferedReader(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> printLines() {
        ArrayList<String> lines = new ArrayList<>();
        try {
            String line = bufferedReader.readLine();
            while (line != null) {
                lines.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return lines;
    }

}
