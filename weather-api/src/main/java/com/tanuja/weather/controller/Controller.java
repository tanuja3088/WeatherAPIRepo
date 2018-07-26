package com.tanuja.weather.controller;

import com.tanuja.weather.service.CityService;
import com.tanuja.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by tguqa8 on 2018-07-24.
 */
@RestController
@RequestMapping(value = "/rest/getData")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    @Autowired
    CityService cityService;

    @Autowired
    WeatherService weatherService;


    @RequestMapping(value = "/city", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> getCities(@RequestParam("city") final String city) throws UnsupportedEncodingException {
        return cityService.getCities(city);
    }

    @RequestMapping(value = "/weather", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getTemperature(@RequestParam("city") final String city) throws UnsupportedEncodingException {
        return weatherService.getWeather(city);
    }
}
