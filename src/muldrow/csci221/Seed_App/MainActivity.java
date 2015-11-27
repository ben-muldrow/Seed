package muldrow.csci221.Seed_App;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

import java.io.*;

public class MainActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    TextView welcomeTextView;
    EditText usernameEditText;
    EditText passwordEditText;
    EditText confirmPasswordEditText;
    Button loginButton;
    Button signUpButton;

    String username;
    String password;

    public static Context context;

    // 0 - logIn 1 - Sign up
    private int mode = 0;

    private File directory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        context = getApplicationContext();

        welcomeTextView = (TextView) findViewById(R.id.welcomeTextView);
        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        confirmPasswordEditText = (EditText) findViewById(R.id.confirmPasswordEditText);
        loginButton = (Button) findViewById(R.id.loginButton);
        signUpButton = (Button) findViewById(R.id.signUpButton);

        directory = Environment.getExternalStorageDirectory();

        // Login Button Listener
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // test mode
                if (mode == 0) {

                    username = usernameEditText.getText().toString();
                    password = passwordEditText.getText().toString();

                    // test validity
                    String toastVal;
                    if (User.isValidUsername(username)){
                        toastVal = "valid name";
                    } else {
                        toastVal = "invalid name;";
                    }
                    Toast toast = Toast.makeText(getApplicationContext(), toastVal, Toast.LENGTH_SHORT);
                    toast.show();

                } else {
                    mode = 0;
                    confirmPasswordEditText.setAlpha(0);
                    Toast toast = Toast.makeText(getApplicationContext(), "Set to Log-in Mode", Toast.LENGTH_LONG);
                    toast.show();
                }

            } // On Click
        }); // Log In Button

        // Sign Up Button Listener
        signUpButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mode == 1) {

                    String newUsername = usernameEditText.getText().toString();
                    String newPassword = passwordEditText.getText().toString();
                    String confirmPass = confirmPasswordEditText.getText().toString();

                    if (newPassword.equals(confirmPass) && User.isValidUsername(newUsername) && User.isValidPassword(newPassword)) {
                        User u = new User(newUsername,newPassword);
                        passwordEditText.setText("");
                        confirmPasswordEditText.setText("");
                        Toast.makeText(context, "greatjob", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!User.isValidUsername(newUsername)) {
                            Toast.makeText(context, "invalid username", Toast.LENGTH_SHORT).show();
                        } else if (!User.isValidPassword(newPassword)){
                            Toast.makeText(context, "invalid password", Toast.LENGTH_SHORT).show();
                        } else if (!newPassword.equals(confirmPass)) {
                            Toast.makeText(context, "password mismatch", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "unknown error", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else {
                    mode = 1;
                    confirmPasswordEditText.setAlpha(1);
                    confirmPasswordEditText.setText("");
                    Toast toast = Toast.makeText(getApplicationContext(), "Set to Sign-up mode", Toast.LENGTH_LONG);
                    toast.show();
                }
                //TODO

            } // on click
        }); // sign up button
    } // On Create


}
