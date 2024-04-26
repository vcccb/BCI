package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Phones {

    @JsonProperty("number")
    String number;
    @JsonProperty("citycode")
    String citycode;
    @JsonProperty("contrycode")
    String contrycode;


    public String getNumber() {
        return number;
    }

    public String getCitycode() {
        return citycode;
    }

    public String getContrycode() {
        return contrycode;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public void setContrycode(String contrycode) {
        this.contrycode = contrycode;
    }
}
