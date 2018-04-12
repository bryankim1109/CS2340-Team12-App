package edu.gatech.cs2340.team12.cs2340_team12_app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caleb on 2/27/2018.
 *
 * holds lists of all the shelters and can make a list of shelters that are narrowed down based
 * on certain search criteria
 */

public class ShelterList implements Serializable{

    private List<Shelter> allShelters;
    private List<Shelter> filteredShelters;

    /**
     * Creates the shelter Lists using firebase
     */
    public ShelterList() {
        FirebaseInterface fbi = FirebaseInterface.getInstance();
        allShelters = new ArrayList<>(fbi.getShelters());
        filteredShelters = new ArrayList<>(allShelters);
    }

    /**
     * Creates an object based on a given List of shelters for use in JUnit testing
     *
     * @param input List of shelters
     */
    public ShelterList(List<Shelter> input) {
        allShelters = new ArrayList<>(input);
        filteredShelters = new ArrayList<>(allShelters);
    }

    public List<Shelter> getAllShelters() {
        return allShelters;
    }
    public List<Shelter> getFilteredShelters() { return filteredShelters; }

    /**
     * sets the filtered shelter list to the same value as the allShelters list
     */
    public void resetFilteredShelters() { filteredShelters = new ArrayList<>(allShelters); }

    /**
     * Creates a List of filtered shelters based on the allShelters list and given search
     * criteria: ageGroup, gender, shelterName.
     * searches based off of ageGroup && gender && shelterName
     *
     * @param user  source of ageGroup and gender search criteria
     * @param name  source of shelterName search criteria
     */
    public void filterShelters(User user, String name) {
        filteredShelters.clear();
        if ((user != null) && (name != null)) {
            String userGender = user.getGender();
            String userAgeGroup = user.getAgeGroup();
            for (Shelter shelter : allShelters) {
                String gender = shelter.getGender();
                String ageGroup = shelter.getAgeGroup();
                if ("Anyone".equals(userGender) || "Anyone".equals(gender) ||
                        ("Male".equals(userGender) && gender.contains("Men")) ||
                        ("Female".equals(userGender) && gender.contains("Women"))) {

                    if ("Anyone".equals(userAgeGroup) || "Anyone".equals(ageGroup) ||
                            ("Young Adults".equals(userAgeGroup) &&
                                    ageGroup.contains("Young Adults")) ||
                            ("Family with newborns".equals(userAgeGroup) &&
                                    ageGroup.contains("Families")) ||
                            ("Children".equals(userAgeGroup) &&
                                    ageGroup.contains("Children"))) {

                        if ("".equals(name) || "Shelter Name".equals(name) ||
                                name.equals(shelter.getShelterName())) {
                            filteredShelters.add(shelter);
                        }
                    }
                }
            }
        }
    }

}

