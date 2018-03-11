package edu.gatech.cs2340.team12.cs2340_team12_app.controllers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.team12.cs2340_team12_app.R;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.Shelter;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.User;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final Spinner genderSpinner;
        final Spinner ageGroupSpinner;
        final EditText shelterNameText;

        genderSpinner = findViewById(R.id.genderSpinner);
        ageGroupSpinner = findViewById(R.id.ageGroupSpinner);
        shelterNameText = findViewById(R.id.ShelterNameText);

        List<String> genders = new ArrayList<>();
        genders.add("N/A");
        genders.add("Male");
        genders.add("Female");
        ArrayAdapter<Shelter> genderAdapter = new ArrayAdapter(SearchActivity.this,android.R.layout.simple_spinner_item, genders);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);
        genderSpinner.setSelection(0);

        List<String> ageGroups = new ArrayList<>();
        ageGroups.add("Anyone");
        ageGroups.add("Family with newborns");
        ageGroups.add("Children");
        ageGroups.add("Young Adults");
        final ArrayAdapter<Shelter> ageGroupAdapter = new ArrayAdapter(SearchActivity.this,android.R.layout.simple_spinner_item, ageGroups);
        ageGroupAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageGroupSpinner.setAdapter(ageGroupAdapter);
        ageGroupSpinner.setSelection(0);

        Button Back;
        Button Search;

        Back = findViewById(R.id.back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Search = findViewById(R.id.Search);
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = shelterNameText.getText().toString();
                String gender = genderSpinner.getSelectedItem().toString();
                String ageGroup = ageGroupSpinner.getSelectedItem().toString();
                Intent intent = new Intent();
                intent.putExtra("name", name);
                intent.putExtra("gender", gender);
                intent.putExtra("ageGroup", ageGroup);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }


    public static Intent makeIntent(Context context) {
        return new Intent(context, SearchActivity.class);
    }
}
