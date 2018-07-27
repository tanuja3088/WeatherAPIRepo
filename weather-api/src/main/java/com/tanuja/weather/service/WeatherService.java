package com.tanuja.weather.service;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by tguqa8 on 2018-07-25.
 */
@Service
public class WeatherService {

    private static final Logger log = LoggerFactory.getLogger(WeatherService.class);

    @Value("${api-key-weather}")
    String key;

    @Value("${api-url-weather}")
    String url;

    public Weather getWeather(String name) throws JsonProcessingException {
        log.info("Getting weather details..");
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

        weatherInfo = mapper.writeValueAsString(response.getBody());
        log.info("Returning weather details");
        return response.getBody();
    }

}
