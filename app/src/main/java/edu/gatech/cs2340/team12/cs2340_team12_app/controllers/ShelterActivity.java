package edu.gatech.cs2340.team12.cs2340_team12_app.controllers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import edu.gatech.cs2340.team12.cs2340_team12_app.R;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.Shelter;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.User;

public class ShelterActivity extends AppCompatActivity {


    Intent intent;
    User loggedInUser = (User) intent.getSerializableExtra("selectedUser");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        final Shelter shelter = (Shelter) intent.getSerializableExtra("selectedShelter");
        setContentView(R.layout.activity_shelter);

        TextView tvShelter;

        tvShelter = findViewById(R.id.tvShelter);
        tvShelter.setText(shelter.toDisplayInfo());

        Button back;

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button reserve;
        reserve = findViewById(R.id.reserveBtn);
        if(loggedInUser.hasBed()) {
            if(loggedInUser.getShelterOfBed().equals(shelter.getShelterName())) {
                reserve.setText("Cancel Reservation");
                reserve.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        loggedInUser.freeBed();
                        loggedInUser.updateUser();
                        Toast.makeText(ShelterActivity.this, "Reservation Cancelled", Toast.LENGTH_LONG).show();
                    }
                });
            } else {
                reserve.setText("Cancel your Current Reservation first");
                reserve.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ShelterActivity.this, "Cancel your current Reservation first", Toast.LENGTH_LONG).show();
                    }
                });
            }
        } else {
            reserve.setText("Reserve Bed");
            reserve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(loggedInUser.reserveBed(shelter)) {
                        Toast.makeText(ShelterActivity.this, "Reservation Successful", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ShelterActivity.this, "Reservation Not Successful", Toast.LENGTH_LONG).show();
                    }
                    loggedInUser.updateUser();
                }
            });
        }
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, ShelterActivity.class);
    }
}
