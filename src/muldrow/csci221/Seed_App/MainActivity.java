package muldrow.csci221.Seed_App;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class MainActivity extends Activity {

    TextView welcomeTextView;
    EditText usernameEditText;
    EditText passwordEditText;
    EditText confirmPasswordEditText;
    Button loginButton;
    Button signUpButton;

    // 0 - logIn
    // 1 - Sign up
    private int mode = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Instantiate layout items
        welcomeTextView = (TextView) findViewById(R.id.welcomeTextView);
        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        confirmPasswordEditText = (EditText) findViewById(R.id.confirmPasswordEditText);
        loginButton = (Button) findViewById(R.id.loginButton);
        signUpButton = (Button) findViewById(R.id.signUpButton);

        Context context = this;
        String filename = "text.txt";
        String profileFilename = "profiles.txt";
        File file = new File(context.getFilesDir(), filename);
        File profileFile = new File(context.getFilesDir(), profileFilename);
        User.setDataFile(file);
        User.setProFile(profileFile);
        UserWriter uw = new UserWriter(file, false);

        // Login Button
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (mode == 0) {

                    String attemptUser = usernameEditText.getText().toString();
                    String attemptPass = passwordEditText.getText().toString();
                    String attemptConfirm = confirmPasswordEditText.getText().toString();
                    Boolean matching = attemptPass.equals(attemptConfirm);

                    UserReader reader = new UserReader(file);
                    HashMap usersMap = reader.readUsers();

                    if (!User.isValidUsername(attemptUser) || !User.isValidPassword(attemptPass)) {
                        makeToast("Invalid Username or Password");
                    } else if (!usersMap.containsKey(attemptUser)) {
                        makeToast("Invalid Username or Password");
                    } else if (!usersMap.get(attemptUser).equals(attemptPass)) {
                        makeToast("Invalid Username or Password");
                    } else {
                        if (User.logIn(attemptUser, attemptPass)) {
                            logIn();
                            makeToast("Logged in to " + User.getActiveUser().getUsername());
                        } else {
                            makeToast("An unknown error!! Ahh!");
                        }
                    }

                } else {
                    mode = 0;
                    confirmPasswordEditText.setAlpha(0);
                }

            }
        });

        // Sign Up Button
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mode == 1) {
                    String attemptUser = usernameEditText.getText().toString();
                    String attemptPass = passwordEditText.getText().toString();
                    String attemptConfirm = confirmPasswordEditText.getText().toString();
                    Boolean matching = attemptPass.equals(attemptConfirm);

                    UserReader reader = new UserReader(file);
                    UserWriter writer = new UserWriter(file, false);
                    Boolean exists = reader.userExists(attemptUser);

                    if (exists) {
                        makeToast("User already exists");
                    } else if (!matching){
                        makeToast("Username and Password don't match");
                    } else if (!User.isValidUsername(attemptUser)){
                        makeToast("Invalid Username");
                    } else if (!User.isValidPassword(attemptPass)){
                        makeToast("Invalid Password");
                    }
                     else if (User.isValidUsername(attemptUser) && User.isValidPassword(attemptPass)
                            && matching && !exists) {
                        writer.addUser(attemptUser,attemptPass);
                        if (User.logIn(attemptUser, attemptPass)){
                            makeToast("logged in to " + User.getActiveUser().getUsername());
                            logIn();
                        } else {
                            makeToast("failed to set active user");
                        }
                    } else {
                        makeToast("unknown error");
                    }

                } else {
                    mode = 1;
                    confirmPasswordEditText.setAlpha(1);
                    confirmPasswordEditText.setText("");
                }

            }
        });
    }

    /**
     * launch account management page activity
     */
    public void logIn(){
        Intent intent = new Intent(this, ManageAccountActivity.class);
        startActivity(intent);
    }

    /**
     * Displays a pop-up with given text
     * @param text for the popup
     */
    public void makeToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

}
