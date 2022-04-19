/**********************
* This is a mock data
**********************/
package com.maxjosh.weather;

public class MockForecastProvider implements ForecastSupplier {
    @Override
    public Forecast get() {
        return new Forecast("Kansas City", 60.5);
    }
}
