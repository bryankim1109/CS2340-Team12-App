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
        DatabaseReference userDatabase = FirebaseDatabase.getInstance().getReference("Accounts/Users");

        shelterDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot shelterSnapshot : dataSnapshot.getChildren()) {
                    FirebaseInterface.getInstance().getShelters().add(shelterSnapshot.getValue(Shelter.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        userDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    FirebaseInterface.getInstance().getUsers().add(userSnapshot.getValue(User.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private List<Shelter> shelters = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public List<Shelter> getShelters() {
        return shelters;
    }
    public List<User> getUsers() {
        return users;
    }

    ////////////////////////////////////////////////////////////////////////////////////
    // The methods below are not done
    ////////////////////////////////////////////////////////////////////////////////////

    //uses shelter name to determine if that shelter is in the database and then updates it
    public boolean updateShelter(Shelter s) {
        String UID = "";
        for (Shelter input : shelters) {
            if (s.getUID().equals(input.getUID())) {
                UID = input.getUID();
            }
        }

        return false;
    }

    //for registration, adds a new user
    public boolean addUser(User u) {
        DatabaseReference userDatabase = FirebaseDatabase.getInstance().getReference("Accounts/Users");
        String key = userDatabase.push().getKey();
        u.setUID(key);
        userDatabase.push().setValue(u);
        return true;
    }

    //for editing user, updates an existing user
    public boolean updateUser(User u) {
        return false;
    }

}
