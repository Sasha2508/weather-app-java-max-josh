package com.maxjosh.weather;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;

import com.maxjosh.weather.Forecast;
import com.maxjosh.weather.ImageProcessor;

import javax.swing.text.LabelView;
import java.io.IOException;
import java.util.Locale;
import java.util.Stack;

public class Main extends Application {

    /** Set up a maven run profile in intellij or use maven from the command-line.
        Use the javafx:run argument to start the javafx application.
        Update all code and comments in this template to suit your own project.
     */


    @Override
    public void start(Stage stage) {

        //let's use Border pane to set layout
        BorderPane border = new BorderPane();
//        HBox hbox = addHBox();
//        border.setTop(hbox);
//        border.setLeft(addVBox);
//        addStackPane(hbox); //Adding stack to Hbox in top region
//        border.setCenter(addFlowPane());
//        border.setRight(addFlowPane());

        //labels

        Label l = new Label("City:");
        TextField cityName = new TextField();
        Label city = new Label(); // example
        Label temperature = new Label();
        Label humidity = new Label();
        Label wind = new Label();
        Label press = new Label();
        Label image = new Label();
        Label cloud = new Label();
        Label day = new Label();
        Label desc = new Label();

        Button submit = new Button("Submit");



        submit.setOnAction(e -> {
            //deg.setText("Loading forecast for: " + cityName.getText());
            var forecast = new Forecast(cityName.getText().substring(0,1).toUpperCase(Locale.ROOT)+cityName.getText().substring(1, cityName.getLength()));

            try {
                forecast.getWeather();
                city.setText(forecast.getCityName() + " ");
                temperature.setText(forecast.getTemp() + "C ");
                humidity.setText("humidity: "+ forecast.getHumidity() + " ");
                wind.setText("windSpeed: "+ forecast.getWindSpeed()+ " ");
                press.setText("pressure: "+ forecast.getPressure()+ " ");
                cloud.setText("cloudiness: "+ forecast.getCloudiness()+ " ");
                day.setText("time of the day: "+ forecast.getDay()+ " ");
                desc.setText("description: "+ forecast.getDesc()+ " ");


            } catch(IOException ex) {
                city.setText(ex.toString());
                temperature.setText(ex.toString());
            }
        });



       //submitForecast.setOnAction(e ->){};

        //nextForecast.setOnAction()e ->){};
//        var stackPane = new StackPane();
        var dataPane = new FlowPane();
//        var picturePane = new FlowPane();


        //dataPane with all the data
        dataPane.getChildren().add(l);
        dataPane.getChildren().add(cityName);
        dataPane.getChildren().add(submit);
        dataPane.getChildren().add(city);
        dataPane.getChildren().add(temperature);
        dataPane.getChildren().add(humidity);
        dataPane.getChildren().add(wind);
        dataPane.getChildren().add(press);
        dataPane.getChildren().add(cloud);
        dataPane.getChildren().add(day);
        dataPane.getChildren().add(desc);

        //picturePane
//        picturePane.getChildren().add(city);




        //set orientation and Hgap and Vgap
        dataPane.setOrientation(Orientation.VERTICAL);
        dataPane.setHgap(10);
        dataPane.setVgap(10);


        //stackpane
//        stackPane.getChildren().addAll( picturePane, dataPane);
        border.setCenter(dataPane);







        //defining scene
        Scene scene = new Scene(border, 600, 500);
        stage.setScene(scene);
        stage.setTitle("Weather App");
        stage.show();


    }

//    private HBox addHBox() {
//        HBox hbox = new HBox();
//        hbox.setPadding(new Insets(15, 12, 15, 12));
//        hbox.setSpacing(10);
//        hbox.setStyle("-fx-background-color: #336699;");
//        var dataPane = new FlowPane();
//    }

    public static void main(String[] args) {
        launch();
    }

}
