package muldrow.csci221.Seed_App;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Benjam on 12/5/2015.
 */
public class ManageAccountActivity extends Activity {

    Toolbar toolbar;
    TextView toolbarText;
    TextView manageWelcomeTextView;
    Button editInfoButton;
    Button logOutButton;
    Button addProfileButton;
    ListView profilesListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_account);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbarText = (TextView) findViewById(R.id.manageAccountTextView);
        manageWelcomeTextView = (TextView) findViewById(R.id.manageWelcomeTextView);
        editInfoButton = (Button) findViewById(R.id.editInformationButton);
        logOutButton = (Button) findViewById(R.id.logOutButton);
        addProfileButton = (Button) findViewById(R.id.addProfileButton);
        profilesListView = (ListView) findViewById(R.id.profilesListView);

        manageWelcomeTextView.setText("Hello, " + User.getActiveUser().getUsername() + ".");

        // list view
        ArrayList<String> listItems=new ArrayList<String>();
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);

        // log out button
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.setActiveUser(null);
                finish();
            }
        });

        // add profile button
        addProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    } // end onCreate

    /**
     * sign out when back button is pressed
     */
    public void onBackPressed() {
        User.setActiveUser(null);
        finish();
    }

}
