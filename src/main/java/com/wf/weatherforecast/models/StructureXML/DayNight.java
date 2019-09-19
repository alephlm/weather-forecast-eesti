package com.wf.weatherforecast.models.StructureXML;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DayNight {

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<PlaceXML> place;

    public List<PlaceXML> getPlace() {
        return place;
    }

    public void setPlace(List<PlaceXML> place) {
        this.place = place;
    }
}
