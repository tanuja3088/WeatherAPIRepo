
package com.tanuja.weather.model;

import java.util.List;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    @JsonProperty(value = "predictions")
    private List<Prediction> cities = null;

    public List<Prediction> getCities() {
        return cities;
    }

    public void setCities(List<Prediction> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Result{" +
                "cities=" + cities +
                '}';
    }
}
