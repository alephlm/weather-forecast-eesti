package com.wf.weatherforecast.models;

import javax.persistence.*;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String phenomenon;

    private Integer tempmin;

    private Integer tempmax;

    public Place(){
    }

    public Place(String name, String phenomenon, Integer tempmin, Integer tempmax) {
        this.name = name;
        this.phenomenon = phenomenon;
        this.tempmin = tempmin;
        this.tempmax = tempmax;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
