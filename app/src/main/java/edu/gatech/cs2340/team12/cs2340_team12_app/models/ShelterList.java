package edu.gatech.cs2340.team12.cs2340_team12_app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caleb on 2/27/2018.
 */

public class ShelterList implements Serializable{

    private List<Shelter> allShelters;
    private List<Shelter> filteredShelters;

    public ShelterList() {
        FirebaseInterface fbi = FirebaseInterface.getInstance();
        allShelters = new ArrayList<>(fbi.getShelters());
        filteredShelters = new ArrayList<>(allShelters);
    }

    public List<Shelter> getAllShelters() {
        return allShelters;
    }
    public List<Shelter> getFilteredShelters() { return filteredShelters; }

    public void resetFilteredShelters() { filteredShelters = new ArrayList<>(allShelters); }

    public void filterShelters(User user, String name) {
        filteredShelters.clear();
        if (user != null && name != null) {
            String userGender = user.getGender();
            String userAgeGroup = user.getAgeGroup();
            for (Shelter shelter : allShelters) {
                String gender = shelter.getGender();
                String ageGroup = shelter.getAgeGroup();
                if (userGender.equals("Anyone") || gender.equals("Anyone") || (userGender.equals("Male") && gender.contains("Men")) ||
                        (userGender.equals("Female") && gender.contains("Women"))) {

                    if (userAgeGroup.equals("Anyone") || ageGroup.equals("Anyone") || (userAgeGroup.equals("Young Adults") && ageGroup.contains("Young Adults")) ||
                            (userAgeGroup.equals("Family with newborns") && ageGroup.contains("Families")) ||
                            (userAgeGroup.equals("Children") && ageGroup.contains("Children"))) {

                        if (name.equals("") || name.equals("Shelter Name") || name.equals(shelter.getShelterName())) {
                            filteredShelters.add(shelter);
                        }
                    }
                }
            }
        }
    }

}

