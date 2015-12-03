package muldrow.csci221.Seed_App;

import java.io.*;

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
    public FileReader(String filename){
        try {
            in = new FileInputStream(filename);
            reader = new InputStreamReader(in, "UTF-8");
            bufferedReader = new BufferedReader(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void printLines() {
        try {
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
