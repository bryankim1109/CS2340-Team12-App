package edu.gatech.cs2340.team12.cs2340_team12_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;


public class WelcomeScreen extends AppCompatActivity {
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchLoginScreen();
            }
        });

    }
    private void launchLoginScreen() {

        Intent intent = LoginScreen.makeIntent(this);
        startActivity(intent);
    }

}
