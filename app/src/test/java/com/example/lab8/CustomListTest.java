package com.example.lab8;


import static org.junit.jupiter.api.Assertions.*;


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
        CustomList list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * Gets the size of the list
     * Increases the list by adding a new city
     * Checks if our current size is 1 more than the initial size
     */
    @Test
    public void addCityTest(){
        CustomList list = MockCityList();
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
    public void testHasCity(){
        CustomList list = MockCityList();
        City city = new City("Vancouver","British Columbia");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    /**
     * Tests the deletion of a city from the city list.
     * This method creates a mock city list and adds a city to it.
     * It asserts that the city is present in the list, then deletes the city.
     * After deletion, it verifies that the city is no longer present in the list
     * and checks that the total number of cities in the list is reduced by one.
     */
    @Test
    void testDeleteCity(){
        CustomList cityList = MockCityList();
        City city = new City("Waterloo","Ontario");
        cityList.addCity(city);
        int listSize = cityList.getCount();
        assertTrue(cityList.hasCity(city));
        cityList.deleteCity(city);
        assertFalse(cityList.hasCity(city));
        assertEquals(listSize-1,cityList.getCount());
    }

    /**
     * Tests the counting of cities in the city list.
     * This method creates a mock city list and asserts the initial count of cities is 0.
     * It then adds two new cities to the list
     * and asserts that the count of cities is now 2.
     * After deleting a mock city, it verifies that the count of cities is reduced to 1.
     */
    @Test
    void testCountCities() {
        CityList cityList = MockCityList();
        assertEquals(0, cityList.countCities());
        cityList.add(new City("Calgary", "Alberta"));
        cityList.add(new City("Ottawa", "Ontario"));
        assertEquals(2, cityList.countCities());
        cityList.deleteCity(mockCity());
        assertEquals(1, cityList.countCities());
    }

}
