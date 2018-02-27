package edu.gatech.cs2340.team12.cs2340_team12_app.models;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
/**
 * Created by Bryan on 2/25/2018.
 */

public class Shelter {
    private DatabaseReference mDatabase;
    private DatabaseReference mDatabase;
    private String key;
    private String shelterName;
    private String capacity;
    private String restrictions;
    private String longitude;
    private String latitude;
    private String address;
    private String notes;
    private String phoneNumber;

    public String getKey() {
        return key;
    }

    public String getShelterName() {
        return shelterName;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getRestrictions() {
        return restrictions;
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

    public String getNotes() {
        return notes;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public void setShelterName(String shelterName) {
        this.shelterName = shelterName;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
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

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
