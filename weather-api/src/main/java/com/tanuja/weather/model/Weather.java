package com.tanuja.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tguqa8 on 2018-07-25.
 */
public class Weather {

    @JsonProperty(value = "location")
    Location locationObject;

    @JsonProperty(value = "current")
    Current currentObject;

    public Location getLocationObject() {
        return locationObject;
    }

    public void setLocationObject(Location locationObject) {
        this.locationObject = locationObject;
    }

    public Current getCurrentObject() {
        return currentObject;
    }

    public void setCurrentObject(Current currentObject) {
        this.currentObject = currentObject;
    }
}

