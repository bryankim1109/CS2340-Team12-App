package edu.gatech.cs2340.team12.cs2340_team12_app.models;

/**
 * Created by Gabriel on 2/27/2018.
 *
 * holds user information:
 *  ageGroup
 *  gender
 *  veteranStatus
 *  longitude
 *  latitude
 *  hadBed
 *  shelterName
 */

public class User extends Account {

    /**
     * required for firebase
     */
    public User() {

    }

    /**
     * Used for registering users for the first time
     *
     * @param username  new username
     * @param password  new password for username
     */
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

    /**
     * Used as an input for a search
     *
     * @param ageGroup      the age group for the search
     * @param gender        the gender for the search
     * @param veteranStatus a way to differentiate from the registration constructor
     */
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

    /**
     * General constructor to put in any input for values
     *
     * @param username      used to set the class's username attribute
     * @param password      used to set the class's password attribute
     * @param email         used to set the class's email attribute
     * @param lockStatus    used to set the class's lockStatus attribute
     * @param ageGroup      used to set the class's ageGroup attribute
     * @param gender        used to set the class's gender attribute
     * @param veteranStatus used to set the class's veteranStatus attribute
     * @param hasBed        used to set the class's hasBed attribute
     * @param shelterName   used to set the class's shelterName attribute
     */
    public User(String username, String password, String email, boolean lockStatus,
                String ageGroup, String gender, boolean veteranStatus, boolean hasBed,
                String shelterName) {
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

    /**
     * Used to reserve a bed. This accesses firebase and decreases the capacity for the input
     * shelter and makes makes the user's hasBed true and stores the shelterName in this user.
     * It only does this if hasBed is false and the capacity of the shelter isnt 0 though.
     *
     * @param shelter   the shelter the user wants to reserve a bed in
     * @return          whether the reservation was successful
     */
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

    /**
     * Used to un-reserve a bed. This accesses firebase and increases the capacity for the input
     * shelter and makes makes the user's hasBed false and clears the shelterName in this user.
     * It only does this if hasBed is true though.
     *
     * @param shelter
     * @return
     */
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

    /**
     * updates this user's entry in firebase
     */
    public void updateUser() {
        FirebaseInterface.updateUser(this);
    }

    /**
     * **yet to be implemented
     * finds the lat & long and sets it fo the user
     *
     * @return      whether the locating was successful
     */
    public boolean locate() {
        // set longitude and latitude. if successful, return true

        return false;
    }
}
