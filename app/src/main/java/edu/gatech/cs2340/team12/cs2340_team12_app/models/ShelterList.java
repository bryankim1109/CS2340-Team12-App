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

    private DatabaseReference mDatabase;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference ref = database.getReference(
            "server/saving-data/shelterinfo");
    private List<Shelter> shelters = new ArrayList<>();
    private DatabaseReference sheltersRef = ref.child("Shelters");

    public void parse(String csvFileName) throws Exception
    {
        //Build reader instance
        //Default seperator is comma
        //Default quote character is double quote
        //Start reading from line number 2 (line numbers start from zero)
        CSVReader reader = new CSVReader(new FileReader(csvFileName + ".csv"));

        //Read CSV line by line and use the string array as you want
        String[] nextLine = reader.readNext();
        while (nextLine != null) {
            if (nextLine != null) {
                shelters.add(new Shelter(nextLine[1], nextLine[2], nextLine[3],
                        nextLine[4], nextLine[5], nextLine[6], nextLine[8]));
            }
            nextLine = reader.readNext();
        }
    }
}

