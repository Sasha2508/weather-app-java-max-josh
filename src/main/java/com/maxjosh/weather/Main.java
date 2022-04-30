package com.maxjosh.weather;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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

        /*******************************************
         *
         * Creating @border instance of BorderPane type
         * putting median boxes inside
         * @rightVbox
         * @leftVbox
         * @centerVbox
         * @bottomVbox
         * @centerVbox
         *
         *
        * ********************************************/

        BorderPane border = new BorderPane();
        var rightVbox = addVBox();
        var leftVbox = addVBox();
        var centerVbox = addVBox();
        var bottomVbox = addVBox();
        border.setRight(rightVbox);
        border.setLeft(leftVbox);
        border.setCenter(centerVbox);
        border.setBottom(bottomVbox);
        /*****************************************
        * Labels that are inside inner containers
         * @city
         * @temperature, @humidity, @wind, @press,
         * @image, @cloud, @day, @desc,
         * @submit button
        *******************************************/

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

        /******************
        *creating button called
         * @submit
        **** ***************/
        Button submit = new Button("Submit");


        /****************
        * eventHandler
        *
        ****************/
        submit.setOnAction(e -> {
            //deg.setText("Loading forecast for: " + cityName.getText());
            var forecast = new Forecast(cityName.getText().substring(0,1).toUpperCase(Locale.ROOT)+cityName.getText().substring(1, cityName.getLength()));

            try {
                forecast.getWeather();
                city.setText(forecast.getCityName() + " ");
                temperature.setText("temperature: "+ forecast.getTemp() + "C ");
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
/***********************************
*Using flowPane as inner containers
 * @topPane
 * @bottomPane
 * @leftPane
 * @rightPane
 * @centerPane
***********************************/
        var topPane = new FlowPane();
        var bottomPane = new FlowPane();
        var leftPane = new FlowPane();
        var rightPaneValues = new FlowPane();
        var rightPaneKeys = new FlowPane();
        var centerPane = new FlowPane();



        /*****************************
         * adding labels to containers
         *
        **********************************/
        bottomPane.getChildren().add(cityName);
        bottomPane.getChildren().add(submit);
        topPane.getChildren().add(city);
//        topPane.setAlignment();
        rightPaneValues.getChildren().add(temperature);
        rightPaneValues.getChildren().add(humidity);
        rightPaneValues.getChildren().add(wind);
        rightPaneValues.getChildren().add(press);
        rightPaneValues.getChildren().add(cloud);
        leftPane.getChildren().add(day);
        centerPane.getChildren().add(desc);

        /*****************************************
         * adding innerContainer to median-containers
        ********************************************/
        rightVbox.getChildren().add(rightPaneValues);


        /*******************************************
         * setting orientation
         * inside inner containers
         * then set it to outer containers
         *******************************************/
        rightPaneValues.setOrientation(Orientation.VERTICAL);
        rightPaneValues.setHgap(10);
        rightPaneValues.setPadding(new Insets(40, 10, 10, 10));
        rightPaneValues.setVgap(10);
        rightPaneValues.setStyle("-fx-background-color: #336699;");
        rightPaneValues.


        border.setCenter(centerPane);
        border.setTop(topPane);
        border.setBottom(bottomPane);
        border.setLeft(leftPane);

        //defining scene
        Scene scene = new Scene(border, 900, 500);
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

    private VBox addVBox(){
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(100));
        vbox.setSpacing(8);
//        vbox.setBorder(new Border());
        Text title = new Text("Weather Details");
        title.setFont(new Font("Arial", 24));
        vbox.getChildren().add(title);

        return vbox;
    }
    public static void main(String[] args) {
        launch();
    }

}
