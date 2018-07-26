package com.tanuja.weather.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tanuja.weather.model.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by tguqa8 on 2018-07-25.
 */
@Service
public class WeatherService {

    private static final Logger log = LoggerFactory.getLogger(CityService.class);

    @Value("${api-key-weather}")
    String key;

    @Value("${api-url-weather}")
    String url;

    public String getWeather(String name) throws UnsupportedEncodingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        ObjectMapper mapper = new ObjectMapper();
        String weatherInfo = "";
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8");
        HttpEntity<?> entity = new HttpEntity<>(headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("q", name)
                .queryParam("key", key);

        HttpEntity<Weather> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                Weather.class);

        try {
            weatherInfo = mapper.writeValueAsString(response.getBody());
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherInfo;
    }

}
