package com.example.lab8;

public class City implements Comparable{
    private String city;
    private String province;

    /**
     * Constructs a new city object with the provided city and province names
     * @param city
     * @param province
     */
    public City(String city, String province){
        this.city = city;
        this.province = province;
    }
    /**
     * Returns the name of the city.
     *
     * @return the city name
     */
    public String getCityName(){
        return this.city;
    }

    /**
     * Returns the name of the province.
     *
     * @return the province name
     */
    public String getProvinceName(){
        return this.province;
    }

    /**
     * Compares this city with another city
     * @param o the city to which we are comparing
     * @return a negative integer, zero, or a positive integer indicating the city is
     * less than, equal to, or greater than the specified city
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }

    /**
     * Checks if the city is equal to another city object
     * @param o the city to which we are comparing
     * @return true if this city is the same as the param city and false otherwise
     */
    @Override
    public boolean equals(Object o){
        if (this ==o ) return true;
        if (o==null || getClass() != o.getClass()) return false;
        City city_obj = (City) o;
        return city == city_obj.city && province == city_obj.province;
    }

    /**
     * Returns a hash code value for the city.
     * This method computes a hash code based on the city's name.
     *
     * @return a hash code value for this city
     */
    @Override
    public int hashCode(){
        int hash = 17 + (this.city!= null ? this.city.hashCode():0);
        return hash;
    }

}
