
package com.tanuja.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Prediction {

    @JsonProperty(value = "description")
    private String city;

    @JsonProperty(value = "structured_formatting")
    private Structure structure;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Prediction{" +
                "city='" + city + '\'' +
                '}';
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(final Structure structure) {
        this.structure = structure;
    }
}
