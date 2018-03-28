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

import java.util.List;

import edu.gatech.cs2340.team12.cs2340_team12_app.R;
//import edu.gatech.cs2340.team12.cs2340_team12_app.models.CSVParser;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.Shelter;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.ShelterList;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.User;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.UserList;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    User loggedInUser;

    ShelterList myShelterList = new ShelterList();
    Spinner shelterSpinner;
    Button LogOut;
    Button Select;
    Button Search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = getIntent();
        loggedInUser = (User) intent.getSerializableExtra("selectedUser");

        setContentView(R.layout.activity_main);

//        if(false) {
//            try {
//                CSVParser.parse(getResources().openRawResource(R.raw.homeless_shelter_database));
//            }
//            catch(Exception a){
//                Toast.makeText(MainActivity.this, "Parser doesn't work", Toast.LENGTH_LONG).show();
//            }
//        }

        myShelterList.resetFilteredShelters();
        List<Shelter> shelters = myShelterList.getFilteredShelters();
        shelterSpinner = findViewById(R.id.shelterSpinner);
        ArrayAdapter<Shelter> adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_item, shelters);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        shelterSpinner.setAdapter(adapter);
        shelterSpinner.setSelection(0);

        LogOut = findViewById(R.id.logout);
        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Select = findViewById(R.id.select);
        Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(shelterSpinner.getSelectedItem() != null) {
                    Shelter shelter = (Shelter) shelterSpinner.getSelectedItem();
                    launchShelterActivity(shelter, loggedInUser);

                    UserList users = new UserList();
                    loggedInUser = users.loginAttempt(loggedInUser.getUsername(), loggedInUser.getPassword());

                } else {
                    Toast.makeText(MainActivity.this, "No shelter selected", Toast.LENGTH_LONG).show();
                }
            }
        });

        Search = findViewById(R.id.Search);
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchSearchActivity();
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                User u = new User(data.getStringExtra("ageGroup"), data.getStringExtra("gender"), false);
                myShelterList.filterShelters(u, name);
                List<Shelter> filtShelts = myShelterList.getFilteredShelters();
                //Toast.makeText(MainActivity.this, "Name: " + name, Toast.LENGTH_LONG).show();
                //Toast.makeText(MainActivity.this, "Gender: " + u.getGender(), Toast.LENGTH_LONG).show();
                //Toast.makeText(MainActivity.this, "AgeGroup: " + u.getAgeGroup(), Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, "Size: " + myShelterList.getFilteredShelters().size(), Toast.LENGTH_LONG).show();

                ArrayAdapter<Shelter> adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_item, filtShelts);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                shelterSpinner.setAdapter(adapter);
                shelterSpinner.setSelection(0);
            }
        }
    }

    private void launchShelterActivity(Shelter s, User u) {
        Intent intent = ShelterActivity.makeIntent(this);
        intent.putExtra("selectedShelter", s);
        intent.putExtra("selectedUser", u);
        startActivity(intent);
    }

    private void launchSearchActivity() {
        Intent intent = SearchActivity.makeIntent(this);
        startActivityForResult(intent, 1);
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }


}
