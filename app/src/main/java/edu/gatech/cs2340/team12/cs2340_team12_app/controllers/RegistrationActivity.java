package edu.gatech.cs2340.team12.cs2340_team12_app.controllers;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.gatech.cs2340.team12.cs2340_team12_app.R;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.UserList;

/**
 * registration screen in which users enter in their desired username and password for their account
 * checks whether the username is taken and if the passwords entered match. you can navigate to the
 * welcome screen from here
 */
public class RegistrationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button cancel;
        Button enter;

        cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        enter = findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText username = findViewById(R.id.username);
                EditText password = findViewById(R.id.password);
                EditText password2 = findViewById(R.id.password2);
                String userString = username.getText().toString();
                String passString = password.getText().toString();
                String passString2 = password2.getText().toString();

                //use the UserList below
                UserList users = new UserList();
                int regSuccess = users.registerAttempt(userString, passString, passString2);

                if(regSuccess == -1) {
                    Toast.makeText(RegistrationActivity.this,
                            "This username is already taken", Toast.LENGTH_LONG).show();
                } else if(regSuccess == 0){
                    Toast.makeText(RegistrationActivity.this,
                            "The passwords do not match", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(RegistrationActivity.this,
                            "Registration Successful", Toast.LENGTH_LONG).show();
                    finish();
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
        return new Intent(context, RegistrationActivity.class);
    }

}
