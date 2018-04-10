package edu.gatech.cs2340.team12.cs2340_team12_app.models;


import java.io.Serializable;

/**
 * Created by Bryan on 2/25/2018.
 */

public class Shelter implements Serializable{
    private String shelterName;
    private int capacity;
    private String gender;
    private String ageGroup;
    private String longitude;
    private String latitude;
    private String address;
    private String phoneNumber;
    private boolean veteranStatus;

    private String uid;

    public Shelter() {
    }

    // Used for parser
    public Shelter(String shelterName, int capacity, String gender,
                   String longitude, String latitude, String address, String phoneNumber) {
        this.shelterName = shelterName;
        this.capacity = capacity;
        this.gender = gender;
        this.ageGroup = "";
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.veteranStatus = false;
    }

    public Shelter(String shelterName, int capacity, String gender, String ageGroup,
                   String longitude, String latitude, String address, String phoneNumber,
                   boolean veteranStatus) {
        this.shelterName = shelterName;
        this.capacity = capacity;
        this.gender = gender;
        this.ageGroup = ageGroup;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.veteranStatus = veteranStatus;
    }

    //Used for JUnit testing
    public Shelter(String shelterName, String gender, String ageGroup) {
        this.shelterName = shelterName;
        this.capacity = 0;
        this.gender = gender;
        this.ageGroup = ageGroup;
        this.longitude = "";
        this.latitude = "";
        this.address = "";
        this.phoneNumber = "";
        this.veteranStatus = false;
    }

    public String getShelterName() {
        return shelterName;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getGender() {
        return gender;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public boolean getVeteranStatus() {
        return veteranStatus;
    }

    public void setShelterName(String shelterName) {
        this.shelterName = shelterName;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setAddress(String address) {
        this.address =  address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public void setVeteranStatus(boolean veteranStatus) {
        this.veteranStatus = veteranStatus;
    }

    public String getUid() {return uid; }
    public void setUid(String uid) {this.uid = uid;}

    public String toString() {
        return shelterName;
    }

    public CharSequence toDisplayInfo() {
        return "Shelter name: " + shelterName + "\n" +
                "Capacity: " + capacity + "\n" +
                "Gender: " + gender + "\n" +
                "Ages: " + ageGroup + "\n" +
                "Veteran Only: " + (veteranStatus ? "Yes" : "No") + "\n" +
                "Longitude: " + longitude + "\n" +
                "Latitude: " + latitude + "\n" +
                "Address: " + address + "\n" +
                "Phone number: " + phoneNumber;
    }

}
