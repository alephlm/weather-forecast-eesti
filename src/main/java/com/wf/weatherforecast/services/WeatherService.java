package com.wf.weatherforecast.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.wf.weatherforecast.models.StructureXML.Forecast;
import com.wf.weatherforecast.models.Place;
import com.wf.weatherforecast.models.StructureXML.PlaceXML;
import com.wf.weatherforecast.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${serviceURL}")
    private String serviceURL;

    @Autowired
    private PlaceRepository placeRepository;

    private List<PlaceXML> getWeatherForAllPlaces() throws IOException {
        ResponseEntity<String> response = getStringResponseEntityFromServiceXML();

        XmlMapper xmlMapper = new XmlMapper();
        List<Forecast> value = xmlMapper.readValue(response.getBody(), new TypeReference<List<Forecast>>() {});
        List<Integer> maxTemps = value.get(0).getDay().getPlace().stream().map(p -> p.getTempmax()).collect(Collectors.toList());
        for (int i = 0; i < value.get(0).getDay().getPlace().size(); i++) {
            value.get(0).getNight().getPlace().get(i).setTempmax(maxTemps.get(i));
        }
        return value.get(0).getNight().getPlace();
    }

    private ResponseEntity<String> getStringResponseEntityFromServiceXML() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_XML, MediaType.TEXT_XML));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.TEXT_XML));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        return restTemplate.exchange(serviceURL, HttpMethod.GET,entity,String.class);
    }

    public void SavePlaces() throws IOException {
        List<PlaceXML> lstPlaces = getWeatherForAllPlaces();
        List<Place> places = lstPlaces.stream().map(p -> new Place(  p.getName(), p.getPhenomenon(), p.getTempmin(), p.getTempmax())).collect(Collectors.toList());
        placeRepository.deleteAll();
        placeRepository.saveAll(places);
    }

    public Place getWeatherByCityName(String cityName) {
        return placeRepository.findByName(cityName);
    }

    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }
}
