package com.tanuja.weather.model;

/**
 * Created by tguqa8 on 2018-07-25.
 */
public class Condition {
    private String text;
    private String icon;
    private float code;


    // Getter Methods

    public String getText() {
        return text;
    }

    public String getIcon() {
        return icon;
    }

    public float getCode() {
        return code;
    }

    // Setter Methods

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setCode(float code) {
        this.code = code;
    }
}

