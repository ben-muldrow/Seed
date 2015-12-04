package muldrow.csci221.Seed_App;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.*;

public class MainActivity extends Activity {

    TextView welcomeTextView;
    EditText usernameEditText;
    EditText passwordEditText;
    EditText confirmPasswordEditText;
    Button loginButton;
    Button signUpButton;

    public static Context context;

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

        context = this;
        String filename = "text.txt";
        File file = new File(context.getFilesDir(), filename);
        UserWriter userWriter = new UserWriter(file);
        UserReader userReader = new UserReader(file);

        // Login Button Listener
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (mode == 0) {
                } else {
                    mode = 0;
                    confirmPasswordEditText.setAlpha(0);
                }

            } // End On Click for Log-In Button
        });

        // Sign Up Button Listener
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mode == 1) {
                } else {
                    mode = 1;
                    confirmPasswordEditText.setAlpha(1);
                    confirmPasswordEditText.setText("");
                }

            } // end on click for Sign-Up button
        });
    }

}
