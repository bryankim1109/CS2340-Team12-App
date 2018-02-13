package edu.gatech.cs2340.team12.cs2340_team12_app;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

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
                launchMainActivity();
                finish();
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
