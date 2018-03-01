package edu.gatech.cs2340.team12.cs2340_team12_app.models;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.opencsv.CSVReader;

import java.io.FileReader;

/**
 * Created by Gabriel on 3/1/2018.
 */

public class CSVParser {
    private static DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Shelters");

    public static void parse() throws Exception
    {
        CSVReader reader = new CSVReader(new FileReader( "homeless_shelter_database.csv"), ',');

        String[] nextLine = reader.readNext();
        Shelter shelter;
        while (nextLine != null) {
                shelter = new Shelter(nextLine[1], nextLine[2], nextLine[3],
                    nextLine[4], nextLine[5], nextLine[6], nextLine[8]);
            mDatabase.push().setValue(shelter);
            nextLine = reader.readNext();
        }
    }
}
