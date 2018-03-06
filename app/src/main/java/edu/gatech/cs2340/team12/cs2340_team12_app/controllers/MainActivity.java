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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.team12.cs2340_team12_app.R;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.CSVParser;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.Shelter;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.ShelterList;

public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseShelters;
    List<Shelter> shelterList;
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

        databaseShelters = FirebaseDatabase.getInstance().getReference("Shelters");
        shelterList = new ArrayList<>();
        databaseShelters.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot shelterSnapshot : dataSnapshot.getChildren()) {
                    Shelter shelter = shelterSnapshot.getValue(Shelter.class);

                    shelterList.add(shelter);
                }

                Toast.makeText(MainActivity.this, "Database read", Toast.LENGTH_LONG).show();
                shelterSpinner = findViewById(R.id.shelterSpinner);
                ArrayAdapter<Shelter> adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_item, shelterList);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                shelterSpinner.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        shelterSpinner = findViewById(R.id.shelterSpinner);
        ArrayAdapter<Shelter> adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_item, shelterList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        shelterSpinner.setAdapter(adapter);

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
                Shelter shelter = (Shelter) shelterSpinner.getSelectedItem();
                launchShelterActivity(shelter);
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
