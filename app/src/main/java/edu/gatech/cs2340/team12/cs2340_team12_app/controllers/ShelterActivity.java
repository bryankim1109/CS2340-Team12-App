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

/**
 * shelter screen where you can reserve a bed at a shelter or un-reserve a bed. this screen also
 * displays info about the shelter. you can navigate to the main screen from here.
 */
public class ShelterActivity extends AppCompatActivity {


    private Shelter shelter;
    private User loggedInUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        shelter = (Shelter) intent.getSerializableExtra("selectedShelter");
        loggedInUser = (User) intent.getSerializableExtra("selectedUser");
        setContentView(R.layout.activity_shelter);

        TextView tvShelter;

        tvShelter = findViewById(R.id.tvShelter);
        tvShelter.setText(shelter.toDisplayInfo());

        Button back;

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("UID", loggedInUser.getUID());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button reserve;
        reserve = findViewById(R.id.reserveBtn);
        if(loggedInUser.getHasBed()) {
            if(loggedInUser.getShelterName().equals(shelter.getShelterName())) {
                reserve.setText("Cancel Reservation");
            } else {
                reserve.setText("Reserve Bed");
            }
        } else {
            reserve.setText("Reserve Bed");
        }
        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loggedInUser.getHasBed()) {
                    if (loggedInUser.getShelterName().equals(shelter.getShelterName())) {
                        loggedInUser.freeBed(shelter);
                        loggedInUser.updateUser();
                        Toast.makeText(ShelterActivity.this,
                                "Reservation Cancelled", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ShelterActivity.this,
                                "Cancel your current Reservation first", Toast.LENGTH_LONG).show();
                    }
                } else {
                    if(loggedInUser.reserveBed(shelter)) {
                        Toast.makeText(ShelterActivity.this,
                                "Reservation Successful", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ShelterActivity.this,
                                "Reservation Not Successful", Toast.LENGTH_LONG).show();
                    }
                    loggedInUser.updateUser();
                }
            }
        });
    }

    /**
     * Creates an intent for other activities to use to start this one
     * @param context   where the activity is being called from
     * @return          the intent used to start this activity
     */
    public static Intent makeIntent(Context context) {
        return new Intent(context, ShelterActivity.class);
    }
}
