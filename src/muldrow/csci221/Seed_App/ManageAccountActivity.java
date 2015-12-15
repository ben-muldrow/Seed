package muldrow.csci221.Seed_App;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

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
    TextView profileNameValueTextView;
    TextView experienceLevelTextView;
    TextView locationValueTextView;
    TextView plantPrefTextView;
    Button searchButton;

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
        profileNameValueTextView = (TextView) findViewById(R.id.profileNameValueTextView);
        experienceLevelTextView = (TextView) findViewById(R.id.experienceLevelTextView);
        locationValueTextView = (TextView) findViewById(R.id.locationValueTextView);
        plantPrefTextView = (TextView) findViewById(R.id.plantPrefValTextView);
        searchButton = (Button) findViewById(R.id.searchButton);

        manageWelcomeTextView.setText("Hello, " + User.getActiveUser().getUsername() + ".");

        // log out button
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.setActiveUser(null);
                User.setActiveProfile(null);
                finish();
            }
        });

        // add profile button
        addProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProfile();
            }
        });

        // Update Info Button
        editInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (User.getActiveUser().hasProfile()) {
                    ProfileReader reader = new ProfileReader(User.proFile);
                    Profile profile = reader.readProfile(User.getActiveUser().getUsername());
                    profileNameValueTextView.setText(profile.getName());
                    experienceLevelTextView.setText(profile.getExperience() + "/10");
                    locationValueTextView.setText(profile.getLat() + "º , " + profile.getLongitude() + "º");
                    plantPrefTextView.setText(profile.getPreference());
                    User.setActiveProfile(profile);
                    makeToast("profile found!");
                } else {
                    makeToast("no profile found for " + User.getActiveUser().getUsername());
                    User.setActiveProfile(null);
                }
            }
        });

        // Search Button
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });

    } // end onCreate

    /**
     * sign out when back button is pressed
     */
    public void onBackPressed() {
        User.setActiveUser(null);
        User.setActiveProfile(null);
        finish();
    }

    /**
     * write a profile to the profile file
     */
    public void addProfile() {
        Intent intent = new Intent(this,AddProfileActivity.class);
        startActivity(intent);
    }

    public void search() {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
    /**
     * makes a short toast containing given text
     * @param text
     */
    public void makeToast(String text) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

}
