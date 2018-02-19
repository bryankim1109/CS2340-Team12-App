package edu.gatech.cs2340.team12.cs2340_team12_app.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gabriel on 2/19/2018.
 */

public class RegisteredUserMap {
    private static final RegisteredUserMap ourInstance = new RegisteredUserMap();

    public static RegisteredUserMap getInstance() {
        return ourInstance;
    }

    private Map<String, String> userMap = new HashMap<>();

    private RegisteredUserMap() {
    }

//    public boolean checkUsername(String s) {
//        return userMap.containsKey(s);
//    }

    public void makeNewUserAndPass(String user, String pass) {
        userMap.put(user, pass);
    }

    public boolean loginAttempt(String user, String pass) {
        if(userMap.containsKey(user) && userMap.get(user).equals(pass)) {
            return true;
        } else {
            return false;
        }
    }

    public int registerAttempt(String user, String pass1, String pass2) {
        if(userMap.containsKey(user)) return -1;
        if(!pass1.equals(pass2)) return 0;
        makeNewUserAndPass(user, pass1);
        return 1;

    }
}
