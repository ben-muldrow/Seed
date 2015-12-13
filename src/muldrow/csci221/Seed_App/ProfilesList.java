package muldrow.csci221.Seed_App;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Benjam on 12/11/2015.
 */
public class ProfilesList extends ListActivity{

    ListView listView;
    public ArrayList<String> listItems;
    public ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Instantiate listView and specify what it will display.
        listView = (ListView) findViewById(R.id.profilesListView);
        String [] profiles = User.getActiveUser().getProfiles();

        // set listView adapter
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, profiles);
        setListAdapter(adapter);

        // on click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Go to edit profile section

            }
        });
    }

}
