package edu.gatech.cs2340.team12.cs2340_team12_app.models;


/**
 * Created by Gabriel on 2/25/2018.
 */

public abstract class Account {

    Account() {
        username = null;
        password = null;
        phoneNumber = null;
        email = null;
        lockStatus = false;
    }

    Account(String user, String pass, String phone, String emale, boolean lock) {
        username = user;
        password = pass;
        phoneNumber = phone;
        email = emale;
        lockStatus = lock;
    }

    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private boolean lockStatus;

    public boolean checkPassword(String input) {
        return password.equals(input);
    }

    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String emale) {
        email = emale;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phone) {
        phoneNumber = phone;
    }
    public boolean getLockStatus() {
        return lockStatus;
    }
    public void setLockStatus(boolean lock) {
        lockStatus = lock;
    }
}
