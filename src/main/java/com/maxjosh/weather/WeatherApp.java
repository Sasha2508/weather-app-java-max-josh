package com.maxjosh.weather;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader; // why it does not exist?
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class WeatherApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ui.fxml"));
        Parent root = loader.load();
        /*Label is in ui.fxml file. but i leave it here for now*/
        Label l = new Label("CS252 JavaFX Starter Template");
        stage.setScene(new Scene(new Pane()));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
