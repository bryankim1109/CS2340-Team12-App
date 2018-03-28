package edu.gatech.cs2340.team12.cs2340_team12_app.controllers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.gatech.cs2340.team12.cs2340_team12_app.R;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.Shelter;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.User;

public class ShelterActivity extends AppCompatActivity {


    Intent intent = getIntent();
    Shelter shelter = (Shelter) intent.getSerializableExtra("selectedShelter");
    User loggedInUser = (User) intent.getSerializableExtra("selectedUser");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, ShelterActivity.class);
    }
}
