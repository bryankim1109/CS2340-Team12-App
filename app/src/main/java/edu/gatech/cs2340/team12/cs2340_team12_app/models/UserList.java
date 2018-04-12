package edu.gatech.cs2340.team12.cs2340_team12_app.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriel on 3/27/2018.
 *
 * holds a list of all users used for login
 */

public class UserList {

    private List<User> allUsers;

    /**
     * uses firebase to load in all the users
     */
    public UserList() {
        FirebaseInterface fbi = FirebaseInterface.getInstance();
        allUsers = new ArrayList<>(fbi.getUsers());
    }

    /**
     * Checks for a user in the list that matches the values in the input. returns null if not
     *
     * @param user  username we are attempting to log in with
     * @param pass  password for the username we are attempting to log in with
     * @return      the user that matches our inputs, or null if there is none.
     */
    public User loginAttempt(String user, String pass) {
        User temp = null;
        for(User u : allUsers) {
            if(u.getUsername().equals(user) && u.getPassword().equals(pass)) {
                temp = u;
            }
        }
        return temp;
    }

    /**
     * Checks if the input username is taken already and whether the rest of the input is correct
     *
     * @param user      username that is requested to be registered
     * @param pass1     password for the username that is requested to be registered
     * @param pass2     password to check that the user entered the correct password
     * @return          value expression the kind of error with the inputs
     */
    public int registerAttempt(String user, String pass1, String pass2) {
        for(User u : allUsers) {
            if (u.getUsername().equals(user)) return -1;
        }
        if(!pass1.equals(pass2)) return 0;
        FirebaseInterface.addUser(new User(user, pass1));
        return 1;

    }

    /**
     * Returns a user from the list based off of a given UID
     *
     * @param UID special ID given to all users
     * @return    the user corresponding to the UID, or null if there is none
     */
    public User getUserFromUID(String UID) {
        for(User u : allUsers) {
            if(u.getUID().equals(UID)) {
                return u;
            }
        }
        return null;
    }

    /**
     * updates the userList based off of firebase's list
     */
    public void updateUserList() {
        FirebaseInterface fbi = FirebaseInterface.getInstance();
        allUsers = new ArrayList<>(fbi.getUsers());
    }

}
