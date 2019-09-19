package com.wf.weatherforecast.models.StructureXML;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceXML {

    private String name;
    private String phenomenon;
    private Integer tempmin;
    private Integer tempmax;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhenomenon() {
        return phenomenon;
    }

    public void setPhenomenon(String phenomenon) {
        this.phenomenon = phenomenon;
    }

    public Integer getTempmin() {
        return tempmin;
    }

    public void setTempmin(Integer tempmin) {
        this.tempmin = tempmin;
    }

    public Integer getTempmax() {
        return tempmax;
    }

    public void setTempmax(Integer tempmax) {
        this.tempmax = tempmax;
    }
}
