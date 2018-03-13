package edu.gatech.cs2340.team12.cs2340_team12_app.models;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriel on 3/9/2018.
 */

public class FirebaseInterface {

    private static final FirebaseInterface ourInstance = new FirebaseInterface();

    public static FirebaseInterface getInstance() { return ourInstance; }

    private FirebaseInterface() {
        DatabaseReference shelterDatabase = FirebaseDatabase.getInstance().getReference("Shelters");
        DatabaseReference userDatabase = FirebaseDatabase.getInstance().getReference("Users");

        shelterDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot shelterSnapshot : dataSnapshot.getChildren()) {
                    Shelter shelter = shelterSnapshot.getValue(Shelter.class);

                    FirebaseInterface.getInstance().getShelters().add(shelter);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private List<Shelter> shelters = new ArrayList<>();

    public List<Shelter> getShelters() {
        return shelters;
    }

}