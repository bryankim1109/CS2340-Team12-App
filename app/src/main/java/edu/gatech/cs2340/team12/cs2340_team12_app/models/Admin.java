package edu.gatech.cs2340.team12.cs2340_team12_app.models;

/**
 * Created by Gabriel on 2/27/2018.
 */

public class Admin extends Account {

    Admin() {
        super();
    }
    Admin(String user, String pass, String phone, String emale, boolean lock) {
        super(user, pass, phone, emale, lock);
    }

    public void lockUser(User u) {
        u.setLockStatus(true);
    }
    public void unlockUser(User u) {
        u.setLockStatus(false);
    }
    public void deleteUser(User u) {
        //************************************* dont know how to do this yet, use firebase
    }

}
