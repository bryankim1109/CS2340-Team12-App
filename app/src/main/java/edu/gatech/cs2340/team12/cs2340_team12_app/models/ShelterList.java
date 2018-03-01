package edu.gatech.cs2340.team12.cs2340_team12_app.models;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caleb on 2/27/2018.
 */

public class ShelterList {

    private List<Shelter> shelters = new ArrayList<>();

    public ShelterList() {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    }

    public List<Shelter> getShelters() {
        return shelters;
    }

}

