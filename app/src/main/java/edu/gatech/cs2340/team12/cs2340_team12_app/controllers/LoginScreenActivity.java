package edu.gatech.cs2340.team12.cs2340_team12_app.controllers;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import edu.gatech.cs2340.team12.cs2340_team12_app.R;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.RegisteredUserMap;

public class LoginScreenActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

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

                RegisteredUserMap userMap = RegisteredUserMap.getInstance();

                if(userMap.loginAttempt(userString, passString)) {
                    launchMainActivity();
                    finish();
                } else {
                    Toast.makeText(LoginScreenActivity.this, "Incorrect username or password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void launchMainActivity() {
        Intent intent = MainActivity.makeIntent(this);
        startActivity(intent);
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, LoginScreenActivity.class);
    }

}
