package com.wf.weatherforecast.models.StructureXML;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
    private String date;

    private DayNight night;

    private DayNight day;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DayNight getNight() {
        return night;
    }
    public void setNight(DayNight night) {
        this.night = night;
    }

    public DayNight getDay() {
        return day;
    }

    public void setDay(DayNight day) {
        this.day = day;
    }
}

