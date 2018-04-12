package edu.gatech.cs2340.team12.cs2340_team12_app.controllers;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

import edu.gatech.cs2340.team12.cs2340_team12_app.R;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.User;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.UserList;

/**
 * Login screen for the app.
 * navigates to the welcome screen or the main screen
 * checks if your login attempt is successful to determine whether to send you to the main screen
 */
public class LoginScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

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
                String userString = username.getText().toString();
                String passString = password.getText().toString();

                UserList users = new UserList();

                User u = users.loginAttempt(userString, passString);
                if(u != null) {
                    launchMainActivity(u);
                    finish();
                } else {
                    Toast.makeText(LoginScreenActivity.this,
                            "Incorrect username or password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void launchMainActivity(Serializable user) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("selectedUser", user);
        startActivity(intent);
    }

    /**
     * Creates an intent for other activities to use to start this one
     * @param context   where the activity is being called from
     * @return          the intent used to start this activity
     */
    public static Intent makeIntent(Context context) {
        return new Intent(context, LoginScreenActivity.class);
    }

}
