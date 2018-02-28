package edu.gatech.cs2340.team12.cs2340_team12_app.controllers;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.Spinner;

import edu.gatech.cs2340.team12.cs2340_team12_app.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button LogOut;
        Button Select;
        Spinner shelterSpinner;

        shelterSpinner = findViewById(R.id.shelterSpinner);
        //ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, ShelterList);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //shelterSpinner.setAdapter(adapter);

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
                launchShelterActivity();
            }
        });
    }

    private void launchShelterActivity() {
        Intent intent = ShelterActivity.makeIntent(this);
        startActivity(intent);
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }


}
