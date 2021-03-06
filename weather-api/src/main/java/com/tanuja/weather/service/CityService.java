package com.tanuja.weather.service;

import com.tanuja.weather.model.City;
import com.tanuja.weather.model.Result;
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

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tguqa8 on 2018-07-24.
 */
@Service
public class CityService {
    private static final Logger log = LoggerFactory.getLogger(CityService.class);

    @Value("${api-key-cities}")
    String key;

    @Value("${api-city-types}")
    String types;

    @Value("${api-url-cities}")
    String url;

    public List<City> getCities(String cityName) {
        log.info("Getting cities list..");
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8");
        HttpEntity<?> entity = new HttpEntity<>(headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("input", cityName)
                .queryParam("key", key)
                .queryParam("types", types);

        HttpEntity<Result> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                Result.class);
        log.info("Returning cities list..");

        return response.getBody().getCities().stream().map(obj -> new City(obj.getStructure().getMain_text(), obj.getStructure().getSecondary_text())).collect(Collectors.toList());
    }

}
