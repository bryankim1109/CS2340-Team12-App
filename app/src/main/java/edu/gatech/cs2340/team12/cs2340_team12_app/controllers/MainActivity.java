package edu.gatech.cs2340.team12.cs2340_team12_app.controllers;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import edu.gatech.cs2340.team12.cs2340_team12_app.R;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.Shelter;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.ShelterList;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.User;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.UserList;

/**
 * the Main screen
 *  can navigate to the welcome screen, the search screen, the map screen, or the shelter info
 *  screen
 *  has a list of shelter names and which name is selected is sent to the shelter info screen.
 *  the list of shelters can be changed by the search screen
 */
public class MainActivity extends AppCompatActivity {

    private User loggedInUser;

    private ShelterList myShelterList = new ShelterList();
    private Spinner shelterSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        loggedInUser = (User) intent.getSerializableExtra("selectedUser");

        setContentView(R.layout.activity_main);

        myShelterList.resetFilteredShelters();
        List<Shelter> shelters = myShelterList.getFilteredShelters();
        shelterSpinner = findViewById(R.id.shelterSpinner);
        ArrayAdapter<Shelter> adapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_spinner_item, shelters);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        shelterSpinner.setAdapter(adapter);
        shelterSpinner.setSelection(0);

        Button logOut = findViewById(R.id.logout);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button select = findViewById(R.id.select);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(shelterSpinner.getSelectedItem() != null) {
                    Serializable shelter = (Shelter) shelterSpinner.getSelectedItem();
                    launchShelterActivity(shelter, loggedInUser);

                    UserList users = new UserList();
                    loggedInUser = users.loginAttempt(loggedInUser.getUsername(),
                            loggedInUser.getPassword());

                } else {
                    Toast.makeText(MainActivity.this, "No shelter selected",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        Button search = findViewById(R.id.Search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchSearchActivity();
            }
        });

        Button map = findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchMapsActivity(myShelterList.getFilteredShelters());
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                User u = new User(data.getStringExtra("ageGroup"),
                        data.getStringExtra("gender"), false);
                myShelterList.filterShelters(u, name);
                List<Shelter> filtShelts = myShelterList.getFilteredShelters();
                Toast.makeText(MainActivity.this, "Size: " + myShelterList
                        .getFilteredShelters().size(), Toast.LENGTH_LONG).show();

                ArrayAdapter<Shelter> adapter = new ArrayAdapter(MainActivity.this,
                        android.R.layout.simple_spinner_item, filtShelts);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                shelterSpinner.setAdapter(adapter);
                shelterSpinner.setSelection(0);
            }
        } else if(requestCode == 2) {
            if(resultCode == RESULT_OK) {
                String UID = data.getStringExtra("UID");
                UserList uList = new UserList();
                loggedInUser = uList.getUserFromUID(UID);

                ShelterList shelters = new ShelterList();
                List<Shelter> allShelts = shelters.getAllShelters();
                ArrayAdapter<Shelter> adapter = new ArrayAdapter(MainActivity.this,
                        android.R.layout.simple_spinner_item, allShelts);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                shelterSpinner.setAdapter(adapter);
                shelterSpinner.setSelection(0);
            }
        }
    }

    private void launchShelterActivity(Serializable shelter, Serializable user) {
        Intent intent = ShelterActivity.makeIntent(this);
        intent.putExtra("selectedShelter", shelter);
        intent.putExtra("selectedUser", user);
        startActivityForResult(intent, 2);
    }

    private void launchSearchActivity() {
        Intent intent = SearchActivity.makeIntent(this);
        startActivityForResult(intent, 1);
    }

    private void launchMapsActivity(List<Shelter> filtList) {
        Intent intent = MapsActivity.makeIntent(this);
        intent.putExtra("ShelterList", (Serializable)filtList);
        startActivity(intent);
    }

    /**
     * Creates an intent for other activities to use to start this one
     * @param context   where the activity is being called from
     * @return          the intent used to start this activity
     */
    public static Intent makeIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }


}
