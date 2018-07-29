package com.tanuja.weather.model;

/**
 * Created by TGUQA8 on 2018-07-28.
 */
public class City {

    private String cityName;
    private String state;

    public City(String cityName, String state) {
        this.cityName = cityName;
        this.state = state;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
