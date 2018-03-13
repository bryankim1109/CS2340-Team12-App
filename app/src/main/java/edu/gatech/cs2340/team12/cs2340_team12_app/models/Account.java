package edu.gatech.cs2340.team12.cs2340_team12_app.models;


/**
 * Created by Gabriel on 2/25/2018.
 */

public class Account {

    Account() {
        username = null;
        password = null;
        email = null;
        lockStatus = false;
    }

    Account(String username, String password, String email, boolean lockStatus) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.lockStatus = lockStatus;
    }

    private String username;
    private String password;
    private String email;
    private boolean lockStatus;

    public boolean checkPassword(String input) {
        return password.equals(input);
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean getLockStatus() {
        return lockStatus;
    }
    public void setLockStatus(boolean lockStatus) {
        this.lockStatus = lockStatus;
    }

}
