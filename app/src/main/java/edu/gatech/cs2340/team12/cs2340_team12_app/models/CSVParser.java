package edu.gatech.cs2340.team12.cs2340_team12_app.models;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * Created by Gabriel on 3/1/2018.
 */

public class CSVParser {
    private static DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Shelters");

    public static void parse(InputStream i) throws Exception
    {
        CSVReader reader = new CSVReader(new InputStreamReader(i));

        String[] nextLine;
        reader.readNext();
        Shelter shelter;
        while ((nextLine = reader.readNext()) != null) {
                shelter = new Shelter(nextLine[1], Integer.parseInt(nextLine[2]), nextLine[3],
                    nextLine[4], nextLine[5], nextLine[6], nextLine[8]);
            mDatabase.push().setValue(shelter);
        }
    }
}
