package com.tanuja.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Structure {

    private String main_text;

    private String secondary_text;

    public String getMain_text() {
        return main_text;
    }

    public void setMain_text(final String main_text) {
        this.main_text = main_text;
    }

    public String getSecondary_text() {
        return secondary_text;
    }

    public void setSecondary_text(String secondary_text) {
        this.secondary_text = secondary_text;
    }
}
