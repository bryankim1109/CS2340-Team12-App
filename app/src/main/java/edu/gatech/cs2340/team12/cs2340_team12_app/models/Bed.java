package edu.gatech.cs2340.team12.cs2340_team12_app.models;

import java.io.Serializable;

/**
 * Created by Gabriel on 3/27/2018.
 */

public class Bed implements Serializable{

    public Bed() {
        this.hasBed = false;
        this.shelterName = "";
    }

    private boolean hasBed;
    private String shelterName;

    public boolean getHasBed() {
        return this.hasBed;
    }

    public String getShelterName() {
        return this.shelterName;
    }

    public boolean reserveBed(Shelter shelter) {
        if(!this.hasBed) return false;
        FirebaseInterface fI = FirebaseInterface.getInstance();
        if(shelter.getCapacity() < 1) return false;

        shelter.setCapacity(shelter.getCapacity() - 1);
        if(fI.updateShelter(shelter)) {
            this.shelterName = shelter.getShelterName();
            this.hasBed = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean freeBed() {
        if(this.hasBed) return false;
        FirebaseInterface fI = FirebaseInterface.getInstance();
        Shelter shelter = null;
        for(Shelter s : fI.getShelters()) {
            if(s.getShelterName().equals(this.shelterName)) {
                shelter = s;
            }
        }
        if(shelter == null) return false;
        shelter.setCapacity(shelter.getCapacity() + 1);
        return fI.updateShelter(shelter);
    }

}
