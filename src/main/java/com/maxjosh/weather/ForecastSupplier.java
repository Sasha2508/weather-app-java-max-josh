package com.maxjosh.weather;

import java.util.function.Supplier;

public interface ForecastSupplier {
    Forecast get(String cityName);
}
