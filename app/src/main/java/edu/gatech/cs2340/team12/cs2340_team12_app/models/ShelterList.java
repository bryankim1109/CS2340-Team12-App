package edu.gatech.cs2340.team12.cs2340_team12_app.models;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caleb on 2/27/2018.
 */

public class ShelterList {

    private static final ShelterList ourInstance = new ShelterList();

    public static ShelterList getInstance() {
        return ourInstance;
    }

    private List<Shelter> allShelters = new ArrayList<>();
    private List<Shelter> filteredShelters = new ArrayList<>();

    public ShelterList() {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("Shelters");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot shelterSnapshot : dataSnapshot.getChildren()) {
                    Shelter shelter = shelterSnapshot.getValue(Shelter.class);

                    allShelters.add(shelter);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public List<Shelter> getAllShelters() {
        return allShelters;
    }
    public List<Shelter> getFilteredShelters() { return filteredShelters; }

    public void filterShelters(User user, String name) {
        filteredShelters.clear();
        String userGender = user.getGender();
        String userAgeGroup = user.getAgeGroup();
        for(Shelter shelter : allShelters) {
            String gender = shelter.getGender();
            if((userGender.equals("Male") && gender.contains("Men")) ||
                    (userGender.equals("Female") && gender.contains("Women")) ||
                    userGender.equals("N/A")) {

                if ((userAgeGroup.equals("Family with newborns") && gender.contains("Families w/ newborns")) ||
                        (userAgeGroup.equals("Child") && gender.contains("Children")) ||
                        (userAgeGroup.equals("Young Adult") && gender.contains("Young Adults")) ||
                        userAgeGroup.equals("All") || gender.contains("Anyone")) {

                    if(name.equals("") || name.equals(shelter.getShelterName())) {
                        filteredShelters.add(shelter);
                    }
                }
            }
        }


    }

}

