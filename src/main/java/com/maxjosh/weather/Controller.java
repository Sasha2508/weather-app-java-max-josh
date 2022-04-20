package com.maxjosh.weather;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class Controller {
    private TextField fieldSearch;

    private Label labelInfo;

    private ForecastSupplier forecastSupplier;

    private WeatherService service = new WeatherService();

    public Controller(ForecastSupplier supplier){
        forecastSupplier = supplier;
    }

    public void onSearch() {
        service.cityName = fieldSearch.getText();
        service.restart();
    }

    private class WeatherService extends Service<Forecast> {
        private String cityName;

        @Override
        protected Task<Forecast> createTask() {
            return new Task<Forecast>() {
                @Override
                protected Forecast call() throws Exception {
                    return forecastSupplier.get(cityName);
                }

                @Override
                protected void succeeded() {
                    Forecast forecast = getValue();
                    labelInfo.setText(forecast.getCityName() + ": " + forecast.getTemp());
                }

                @Override
                protected void failed() {
                    Throwable error = getException();

                    labelInfo.setText("Error: " + error);
                }
            };
        }
    }
}
