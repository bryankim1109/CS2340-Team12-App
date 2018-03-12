package edu.gatech.cs2340.team12.cs2340_team12_app.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import edu.gatech.cs2340.team12.cs2340_team12_app.R;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.FirebaseInterface;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.Shelter;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.ShelterList;

public class WelcomeScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        FirebaseInterface.getInstance();

        Button login;
        Button registration;
        Button loginGuest;

        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchLoginScreen();
            }
        });

        registration = findViewById(R.id.register);
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchRegistrationScreen();
            }
        });

        loginGuest = findViewById(R.id.loginGuest);
        loginGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchMainScreen();
            }
        });

        //ShelterList myShelterList = ShelterList.getInstance();
        //Toast.makeText(WelcomeScreenActivity.this, "Size: " + myShelterList.getAllShelters().size(), Toast.LENGTH_LONG).show();

    }

    private void launchLoginScreen() {

        Intent intent = LoginScreenActivity.makeIntent(this);
        startActivity(intent);
    }

    private void launchRegistrationScreen() {

        Intent intent = RegistrationActivity.makeIntent(this);
        startActivity(intent);
    }

    private void launchMainScreen() {

        Intent intent = MainActivity.makeIntent(this);
        startActivity(intent);
    }

}
