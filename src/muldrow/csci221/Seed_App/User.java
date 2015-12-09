package muldrow.csci221.Seed_App;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by Benjam on 11/11/2015.
 */
public class User {

    private String username;
    private String password;

    public static final int MAX_USERNAME_LENGTH = 16;
    public static final int MAX_PASSWORD_LENGTH = 16;
    public static final int MIN_USERNAME_LENGTH = 6;
    public static final int MIN_PASSWORD_LENGTH = 6;
    public static final String VALID_USER_CHARS = "abcdefghijklmnopqrstuvwxyz-_.0123456789";
    public static final String VALID_PASS_CHARS = "abcdefghijklmnopqrstuvwxyz-_.0123456789";
    private static User activeUser = null;

    /**
     * User Class Constructor
     * @param username
     * @param password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
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

    /**
     * tests if a user exists in a file
     * @param file to read
     * @param username to test
     * @return if the user is there
     */
    private static boolean userExists(File file, String username) {
        UserReader reader = new UserReader(file);
        return reader.userExists(username);
    }

    /**
     * log into an account
     * @param file of user ifnormation
     * @param username as a string
     * @param password as a string
     * @return the User object of the logged-in user.
     */
    public static boolean logIn(File file, String username, String password) {
        if (userExists(file, username)) {
            User temp = new User(username, password);
            activeUser = temp;
            return true;
        } else { return false; }
    }

    /**
     * returns username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * returns password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * set username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * set password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * sets the active user
     * @param u user
     */
    public static void setActiveUser(User u) {
        activeUser = u;
    }

    /**
     * returns the active user as a User
     * @return
     */
    public static User getActiveUser() {
        return activeUser;
    }

}
