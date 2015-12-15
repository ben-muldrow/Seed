package muldrow.csci221.Seed_App;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

/**
 * Created by Benjam on 12/15/2015.
 */
public class SearchActivity extends Activity {

    ScrollView scrollView;
    LinearLayout linearLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        scrollView = (ScrollView) findViewById(R.id.scrollView);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayoutSearch);

        Profile profile = User.getActiveProfile();

        ArrayList<Plant> plants = Plant.getExamplePlants();
        for (Plant plant : plants) {

            // check if plant is viable

            double minLat = 0;
            double maxLat = 0;
            double minLong = 0;
            double maxLong = 0;

            if (plant.range != -1) {
                minLat = plant.getAvgLat() - plant.getRange();
                maxLat = plant.getAvgLat() + plant.getRange();

                minLong = plant.getAvgLong() - plant.getRange();
                maxLong = plant.getAvgLong() + plant.getRange();
            } else {
                minLat = -90;
                maxLat = 90;

                minLong = -90;
                maxLong = 90;
            }

            boolean isInRange = (profile.getLongitude() < maxLong && profile.getLongitude() > minLong) &&
                    (profile.getLat() < maxLat && profile.getLat() > minLat);
            boolean hasExperience = profile.experience >= plant.getMinExperience();
            boolean hasPreference = profile.preference.equals(plant.getType());

            // add views if plant is viable
            if (isInRange && hasExperience && hasPreference) {

                // add image if available
                if (plant.imageFileName != null) {
                    ImageView imageView = new ImageView(this);
                    String imageFileNameText = plant.imageFileName;
                    Uri uri = Uri.parse("android.resource://muldrow.csci221.Seed_App/drawable/" + imageFileNameText);
                    imageView.setImageDrawable(Drawable.createFromPath(uri.toString()));
                    linearLayout.addView(imageView);
                }

                // Create String for other values
                StringBuilder builder = new StringBuilder();
                builder.append(plant.getName() + "( " + plant.getCommonName() + " )" + "\n");
                builder.append("Exposure Required:  " + plant.getExposure() + "\n");
                builder.append("Color:  " + plant.getColor() + "\n");
                builder.append("Experience Required: " + plant.getMinExperience() + "/10" + "\n");
                builder.append("\n");

                // Display TextView
                TextView descriptionTextView = new TextView(this);
                descriptionTextView.setText(builder.toString());
                descriptionTextView.setTextColor(Color.BLACK);
                linearLayout.addView(descriptionTextView);
            }
        }
    }

    public void makeToast(String text) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

}
