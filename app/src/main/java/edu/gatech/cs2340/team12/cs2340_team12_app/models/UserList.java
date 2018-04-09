package edu.gatech.cs2340.team12.cs2340_team12_app.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriel on 3/27/2018.
 */

public class UserList {

    private List<User> allUsers;

    public UserList() {
        FirebaseInterface fbi = FirebaseInterface.getInstance();
        allUsers = new ArrayList<>(fbi.getUsers());
    }

    public User loginAttempt(String user, String pass) {
        User temp = null;
        for(User u : allUsers) {
            if(u.getUsername().equals(user) && u.getPassword().equals(pass)) {
                temp = u;
            }
        }
        return temp;
    }

    public int registerAttempt(String user, String pass1, String pass2) {
        for(User u : allUsers) {
            if (u.getUsername().equals(user)) return -1;
        }
        if(!pass1.equals(pass2)) return 0;
        FirebaseInterface.addUser(new User(user, pass1));
        return 1;

    }

    public User getUserFromUID(String UID) {
        for(User u : allUsers) {
            if(u.getUID().equals(UID)) {
                return u;
            }
        }
        return null;
    }

    public void updateUserList() {
        FirebaseInterface fbi = FirebaseInterface.getInstance();
        allUsers = new ArrayList<>(fbi.getUsers());
    }

}
