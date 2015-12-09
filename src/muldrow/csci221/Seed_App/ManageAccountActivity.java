package muldrow.csci221.Seed_App;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

/**
 * Created by Benjam on 12/5/2015.
 */
public class ManageAccountActivity extends Activity {

    Toolbar toolbar;
    TextView toolbarText;
    TextView manageWelcomeTextView;
    Button editInfoButton;
    Button logOutButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_account);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbarText = (TextView) findViewById(R.id.manageAccountTextView);
        manageWelcomeTextView = (TextView) findViewById(R.id.manageWelcomeTextView);
        editInfoButton = (Button) findViewById(R.id.editInformationButton);
        logOutButton = (Button) findViewById(R.id.logOutButton);

        manageWelcomeTextView.setText("Hello, " + User.getActiveUser().getUsername() + ".");

        // log out button
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.setActiveUser(null);
                finish();
            }
        });
    } // end onCreate
}
