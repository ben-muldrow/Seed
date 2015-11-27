package muldrow.csci221.Seed_App;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Benjam on 11/11/2015.
 */
public class User {

    public String username;
    public String password;

    public static final int MAX_USERNAME_LENGTH = 16;
    public static final int MAX_PASSWORD_LENGTH = 16;
    public static final int MIN_USERNAME_LENGTH = 6;
    public static final int MIN_PASSWORD_LENGTH = 6;
    public static final String VALID_USER_CHARS = "abcdefghijklmnopqrstuvwxyz-_.0123456789";
    public static final String VALID_PASS_CHARS = "abcdefghijklmnopqrstuvwxyz-_.0123456789";

    public static FileOutputStream usersOutputStream;
    private File usersFile;

    /**
     * User Class Constructor
     * @param username
     * @param password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;

        try {
            URL usersURL = new URL(getClass().getResource("users.txt").getPath());
            usersFile = new File(usersURL.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        
    }

    /**
     * Adds a user's information to the users file.
     * @param username
     * @param password
     */
    public static void addUser(String username, String password) {
    }

    /**
     * Returns whether or not a username is valid
     * @param username String
     * @return validity of username
     */
    public static boolean isValidUsername(String username) {

        boolean valid = true;

        // check if username contains valid characters
        for (int i = 0; i < username.length(); i++) {
            if (!VALID_USER_CHARS.contains(username.substring(i, i+1).toLowerCase())) {
                valid = false;
            }
        }

        // check if valid length
        if (username.length() < MIN_USERNAME_LENGTH || username.length() > MAX_USERNAME_LENGTH) {
            valid = false;
        }

        return valid;
    }

    /**
     * Returns if a string is a valid password
     * @param password String
     * @return boolean validity
     */
    public static boolean isValidPassword(String password) {

        boolean valid = true;

        // check if password contains valid characters
        for (int i = 0; i < password.length(); i++) {
            if (!VALID_PASS_CHARS.contains(password.substring(i, i+1).toLowerCase())){
                valid = false;
            }
        }

        // check if valid length
        if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            valid = false;
        }

        return valid;
    }

    /*private static boolean userExists(String username) {
        boolean found = false;
        boolean validInput = true;
        String temp;
        String[] usersList;
        while (!found && validInput) {
            try {
                temp = bufferedReader.readLine();
                usersList = temp.split(",");

                // check if username exists
                if (usersList[0].toLowerCase().equals(username.toLowerCase())) {
                    found = true;
                }
                if (temp.equals(null)) {
                    validInput = false;
                }

            } catch (IOException e) {
                e.printStackTrace();
                validInput = false;
            }
        }
        return found;
    }*/
}
