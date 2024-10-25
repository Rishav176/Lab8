package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    /**
     * Creates a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * Gets the size of the list
     * Increases the list by adding a new city
     * Checks if our current size is 1 more than the initial size
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan","SK"));
        assertEquals(list.getCount(),listSize+1);
    }

    /**
     * Checks to make sure a newly created city isn't in the list
     * Adds a city to the list
     * Checks if the the city is in the list
     */
    @Test
    void testHasCity(){
        list = MockCityList();
        City city = new City("Vancouver","British Columbia");
        assertEquals(false,list.hasCity(city));
        list.add(city);
        assertEquals(true,list.hasCity(city));
    }


}
