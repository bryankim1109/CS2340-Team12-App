package edu.gatech.cs2340.team12.cs2340_team12_app.models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Gabriel on 4/9/2018.
 */
public class ShelterListTest {
    @Test
    public void filterShelters() throws Exception {
        Shelter shelter1 = new Shelter("name1", "Men", "Anyone");
        Shelter shelter2 = new Shelter("name2", "Women", "Families");
        Shelter shelter3 = new Shelter("name3", "Men", "Families");
        List<Shelter> shelters = new ArrayList<>();
        shelters.add(shelter1);
        shelters.add(shelter2);
        shelters.add(shelter3);

        ShelterList myShelterList1 = new ShelterList(shelters);
        ShelterList myShelterList2 = new ShelterList(shelters);
        ShelterList myShelterList3 = new ShelterList(shelters);
        ShelterList myShelterList4 = new ShelterList(shelters);
        ShelterList myShelterList5 = new ShelterList(shelters);

        User user1 = new User("Anyone", "Anyone", false);
        User user2 = new User("Anyone", "Male", false);
        User user3 = new User("Families", "Anyone", false);
        User user4 = new User("Families", "Male", false);
        User user5 = new User("Anyone", "Anyone", false);

        myShelterList1.filterShelters(user1, "");
        myShelterList2.filterShelters(user2, "");
        myShelterList3.filterShelters(user3, "");
        myShelterList4.filterShelters(user4, "");
        myShelterList5.filterShelters(user5, "name2");

        List<Shelter> expected1 = new ArrayList<>();
        List<Shelter> expected2 = new ArrayList<>();
        List<Shelter> expected3 = new ArrayList<>();
        List<Shelter> expected4 = new ArrayList<>();
        List<Shelter> expected5 = new ArrayList<>();

        expected1.add(shelter1);
        expected1.add(shelter2);
        expected1.add(shelter3);

        expected2.add(shelter1);
        expected2.add(shelter3);

        expected3.add(shelter1);
        expected3.add(shelter3);

        expected4.add(shelter3);

        expected5.add(shelter2);

        assertEquals("Test 1 Failed", expected1, myShelterList1.getFilteredShelters());
        assertEquals("Test 2 Failed", expected2, myShelterList2.getFilteredShelters());
        assertEquals("Test 3 Failed", expected3, myShelterList3.getFilteredShelters());
        assertEquals("Test 4 Failed", expected4, myShelterList4.getFilteredShelters());
        assertEquals("Test 5 Failed", expected5, myShelterList5.getFilteredShelters());
    }

}