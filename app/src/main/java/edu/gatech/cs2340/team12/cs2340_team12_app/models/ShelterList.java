package edu.gatech.cs2340.team12.cs2340_team12_app.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caleb on 2/27/2018.
 */

public class ShelterList {

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
        String userGender = user.getGender();
        String userAgeGroup = user.getAgeGroup();
        for(Shelter shelter : allShelters) {
            String gender = shelter.getGender();
//            if((userGender.equals("Male") && gender.contains("Men")) ||
//                    (userGender.equals("Female") && gender.contains("Women")) ||
//                    userGender.equals("N/A")) {
//
//                if ((userAgeGroup.equals("Family with newborns") && gender.contains("Families w/ newborns")) ||
//                        (userAgeGroup.equals("Child") && gender.contains("Children")) ||
//                        (userAgeGroup.equals("Young Adult") && gender.contains("Young Adults")) ||
//                        userAgeGroup.equals("Anyone") || gender.contains("Anyone")) {
//
//                    if(name.equals("") || name.equals("Shelter Name") || name.equals(shelter.getShelterName())) {
//                        filteredShelters.add(shelter);
//                    }
//                }
//            }
            filteredShelters.add(shelter);
        }

    }

}

