package com.maxjosh.weather;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
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
        Label l = new Label("City:");
        TextField cityName = new TextField();
        Label info = new Label(); // example

        Button submit = new Button("Submit");



        loadSubmit.setOnAction(e -> {
            info.setText("Loading forecast for: " + cityName.getText());



        });

        //saveForecast.setOnAction(e ->){};

       //submitForecast.setOnAction(e ->){};

        //nextForecast.setOnAction()e ->){};

        var rootPane = new FlowPane();
        rootPane.getChildren().add(l);
        rootPane.getChildren().add(cityName);
        rootPane.getChildren().add(submit);
        rootPane.getChildren().add(info);






        Scene scene = new Scene(rootPane);

        stage.setScene(scene);
        stage.show();
        Forecast forecast = new Forecast("Kansas City");

    }

    public static void main(String[] args) {
        launch();
    }

}
