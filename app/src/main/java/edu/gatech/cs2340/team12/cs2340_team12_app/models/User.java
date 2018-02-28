package edu.gatech.cs2340.team12.cs2340_team12_app.models;

import java.util.Date;

/**
 * Created by Gabriel on 2/27/2018.
 */

public class User extends Account {

    User() {
        super();
        birthday = null;
        gender = -1;
        veteranStatus = false;
    }
    User(String user, String pass, String phone, String emale, boolean lock, Date birth, int gndr, boolean vetStat) {
        super(user, pass, phone, emale, lock);
        birthday = birth;
        gender = gndr;
        veteranStatus = vetStat;
    }

    private Date birthday;
    private int gender;
    private boolean veteranStatus;

    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birth) {
        birthday = birth;
    }
    public int getGender() {
        return gender;
    }
    public void setGender(int gndr) {
        gender = gndr;
    }
    public boolean getVeteranStatus() {
        return veteranStatus;
    }
    public void setVeteranStatus(boolean vetStat) {
        veteranStatus = vetStat;
    }

    public int getAge() {
        return 1; //****************************** use the birthday to determine the age
    }

}
