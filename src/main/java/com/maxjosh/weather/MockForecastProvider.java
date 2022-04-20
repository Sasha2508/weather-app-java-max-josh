/**********************
* This is a mock data
**********************/
package com.maxjosh.weather;

public class MockForecastProvider implements ForecastSupplier {
    @Override
    public Forecast get(String cityName) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Forecast(cityName, 60.5);
    }
}
