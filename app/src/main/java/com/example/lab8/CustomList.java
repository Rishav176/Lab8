package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * Gets the size of the list
     * @return
     */
    public int getCount(){
        return cities.size();
    }

    /**
     * Adds a city object to the list
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * This method checks if a city is present in the list of cities
     * @param city
     * @return true if the city is in the list and false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Removes a city from the list if it exists.
     *
     * @param city the city to remove
     * @throws IllegalArgumentException if the city does not exist in the list
     */
    public void deleteCity(City city) {
        if (!cities.contains(city)){
            throw new IllegalArgumentException();
        } else{
            cities.remove(city);
        }
    };

    /**
     * Returns the number of cities in the list.
     * @return the count of cities
     */
    public int countCities() {
        return cities.size();
    }
}
