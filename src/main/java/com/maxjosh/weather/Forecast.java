package com.maxjosh.weather;

public class Forecast {
    private String cityName;
    private double temp;

    public Forecast(String cityName, double temp) {
        this.cityName = cityName;
        this.temp = temp;
    }

    public String getCityName() {
        return cityName;
    }

    public double getTemp() {
        return temp;
    }
}
