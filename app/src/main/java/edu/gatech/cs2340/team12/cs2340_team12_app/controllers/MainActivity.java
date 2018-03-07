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

public class MainActivity extends AppCompatActivity {
    ShelterList myShelterList = ShelterList.getInstance();
    Spinner shelterSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if(false) {
//            try {
//                CSVParser.parse(getResources().openRawResource(R.raw.homeless_shelter_database));
//            }
//            catch(Exception a){
//                Toast.makeText(MainActivity.this, "Parser doesn't work", Toast.LENGTH_LONG).show();
//            }
//        }

        List<Shelter> shelters = myShelterList.getAllShelters();
        shelterSpinner = findViewById(R.id.shelterSpinner);
        ArrayAdapter<Shelter> adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_item, shelters);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        shelterSpinner.setAdapter(adapter);
        shelterSpinner.setSelection(0);

        Button LogOut;
        Button Select;

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
                    launchShelterActivity(shelter);
                } else {
                    Toast.makeText(MainActivity.this, "No shelter selected", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void launchShelterActivity(Shelter s) {
        Intent intent = ShelterActivity.makeIntent(this);
        intent.putExtra("selectedShelter", s);
        startActivity(intent);
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }


}
