package muldrow.csci221.Seed_App;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

/**
 * Created by Benjam on 12/13/2015.
 */
public class AddProfileActivity extends Activity implements RadioGroup.OnCheckedChangeListener {

    EditText profileNameEditText;
    SeekBar experienceSeekBar;
    TextView experienceTextView;
    EditText latEditText;
    EditText longEditText;
    RadioGroup radioGroup;
    RadioButton flowerRadioButton;
    RadioButton herbRadioButton;
    RadioButton vegetableRadioButton;
    Button confirmProfileButton;

    public String profileName;
    public int experience = 0;
    public double [] latLong = new double[2];
    public String preference = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_profile_activity);

        profileNameEditText = (EditText) findViewById(R.id.profileNameEditText);
        experienceSeekBar = (SeekBar) findViewById(R.id.experienceSeekBar);
        experienceTextView = (TextView) findViewById(R.id.experienceTextView);
        latEditText = (EditText) findViewById(R.id.latEditText);
        longEditText = (EditText) findViewById(R.id.longEditText);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        flowerRadioButton = (RadioButton) findViewById(R.id.flowerRadioButton);
        herbRadioButton = (RadioButton) findViewById(R.id.herbRadioButton);
        vegetableRadioButton = (RadioButton) findViewById(R.id.vegetableRadioButton);
        confirmProfileButton = (Button) findViewById(R.id.confirmProfileButton);

        radioGroup.setOnCheckedChangeListener(this);

        // seek bar listener
        experienceSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                experience = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // auto-generated
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                experienceTextView.setText("Experience: " + experience);
            }
        });

        // confirm profile button
        confirmProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean valid = true;
                if (profileNameEditText.getText().toString().length() < 3) {
                    makeToast("profile must be more than 3 characters long");
                } else if (latEditText.getText().toString().equals("") ||
                           longEditText.getText().toString().equals("")) {
                    makeToast("No location entered!");
                } else if (preference.equals(null)) {
                    makeToast("Please select a plant type preference");
                } else {
                    profileName = profileNameEditText.getText().toString();
                    latLong[0] = Double.parseDouble(latEditText.getText().toString());
                    latLong[1] = Double.parseDouble(longEditText.getText().toString());

                    User.getActiveUser().addProfile(new Profile(User.getActiveUser(),profileName,
                            experience,latLong[0],latLong[1],preference));

                    makeToast("Added Profile " + profileName + " to " + User.getActiveUser().getUsername());
                    finish();
                }
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.flowerRadioButton:
                preference = "flower";
                break;
            case R.id.herbRadioButton:
                preference = "herb";
                break;
            case R.id.vegetableRadioButton:
                preference = "vegetable";
                break;
            default:
        } // end switch
    } // end on checked change

    public void onBackPressed() {
        finish();
    }

    public void makeToast(String text) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }
}
