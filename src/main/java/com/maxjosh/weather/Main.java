package com.maxjosh.weather;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import com.maxjosh.weather.Forecast;

public class Main extends Application {

    /** Set up a maven run profile in intellij or use maven from the command-line.
        Use the javafx:run argument to start the javafx application.
        Update all code and comments in this template to suit your own project.
     */


    @Override
    public void start(Stage stage) {
        Label l = new Label("CS252 JavaFX Starter Template");
        Scene scene = new Scene(new StackPane(l), 800, 480);
        stage.setScene(scene);
        stage.show();
        Forecast forecast = new Forecast("Kansas City");

    }

    public static void main(String[] args) {
        launch();
    }

}
