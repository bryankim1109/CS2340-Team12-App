package edu.gatech.cs2340.team12.cs2340_team12_app.controllers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.gatech.cs2340.team12.cs2340_team12_app.R;

public class RegSuccessActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_success);

        Button contin;

        contin = findViewById(R.id.contin);
        contin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, RegSuccessActivity.class);
    }
}
