package edu.gatech.cs2340.team12.cs2340_team12_app.models;

import android.util.Log;

/**
 * Created by Gabriel on 2/27/2018.
 */

public class User extends Account {

    public User() {

    }
    //for Registration
    public User(String username, String password) {
        super(username, password, "", false);
        ageGroup = null;
        gender = "N/A";
        veteranStatus = false;
        longitude = 0;
        latitude = 0;
        hasBed = false;
        shelterName = "";
    }
    //for Search
    public User(String ageGroup, String gender, boolean veteranStatus) {
        super();
        this.ageGroup = ageGroup;
        this.gender = gender;
        this.veteranStatus = veteranStatus;
        longitude = 0;
        latitude = 0;
        hasBed = false;
        shelterName = "";
    }
    public User(String username, String password, String email, boolean lockStatus, String ageGroup, String gender, boolean veteranStatus, boolean hasBed, String shelterName) {
        super(username, password, email, lockStatus);
        this.ageGroup = ageGroup;
        this.gender = gender;
        this.veteranStatus = veteranStatus;
        longitude = 0;
        latitude = 0;
        this.hasBed = hasBed;
        this.shelterName = shelterName;
    }

    private String ageGroup;
    private String gender;
    private String contactInfo;
    private boolean veteranStatus;
    private double longitude;
    private double latitude;

    private boolean hasBed;
    private String shelterName;

    public String getAgeGroup() {
        return ageGroup;
    }
    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
    public boolean getVeteranStatus() {
        return veteranStatus;
    }
    public void setVeteranStatus(boolean vetStat) {
        this.veteranStatus = vetStat;
    }
    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public boolean getHasBed() {return this.hasBed;}

    public String getShelterName() {
        return this.shelterName;
    }

    public boolean reserveBed(Shelter shelter) {
        if(this.hasBed) return false;
        if(shelter.getCapacity() < 1) return false;
        shelter.setCapacity(shelter.getCapacity() - 1);
        if(FirebaseInterface.updateShelter(shelter)) {
            this.shelterName = shelter.getShelterName();
            this.hasBed = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean freeBed(Shelter shelter) {
        if(!this.hasBed) return false;
        shelter.setCapacity(shelter.getCapacity() + 1);
        if(FirebaseInterface.updateShelter(shelter)) {
            this.shelterName = "";
            this.hasBed = false;
            return true;
        } else {
            return false;
        }
    }

    public void updateUser() {
        FirebaseInterface.updateUser(this);
    }


    public boolean locate() {
        // set longitude and latitude. if successful, return true

        return false;
    }
}
