package edu.gatech.cs2340.team12.cs2340_team12_app.models;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bryan on 2/25/2018.
 */

public class Shelter {
    private String shelterName;
    private String capacity;
    private String gender;
    private String longitude;
    private String latitude;
    private String address;
    private String phoneNumber;

    public Shelter() {
    }

    public Shelter(String shelterName, String capacity, String gender,
                   String longitude, String latitude, String address, String phoneNumber) {
        this.shelterName = shelterName;
        this.capacity = capacity;
        this.gender = gender;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getShelterName() {
        return shelterName;
    }

    public String getCapacity() {
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

    public void setShelterName(String shelterName) {
        this.shelterName = shelterName;
    }

    public void setCapacity(String capacity) {
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

    public String toString() {
        return shelterName;
    }

}
