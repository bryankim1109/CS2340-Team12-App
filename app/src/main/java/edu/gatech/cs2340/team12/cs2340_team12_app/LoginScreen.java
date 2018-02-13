package edu.gatech.cs2340.team12.cs2340_team12_app;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {
    private Button cancel;
    private Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

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

                if(userString.equals("user") && passString.equals("pass")) {
                    launchMainActivity();
                    finish();
                } else {
                    Toast.makeText(LoginScreen.this, "Incorrect username or password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void launchMainActivity() {

        Intent intent = MainActivity.makeIntent(this);
        startActivity(intent);
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, LoginScreen.class);
    }

}
