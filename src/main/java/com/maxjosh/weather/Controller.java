package com.maxjosh.weather;

import java.awt.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

public class Controller {

    @FXML
    private TextField fieldSearch;

    @FXML
    private Label labelInfo;

    private ForecastSupplier forecastSupplier;

    public Controller(ForecastSupplier supplier) {
        forecastSupplier = supplier;
    }
    public void onSearch() {

    }

}
