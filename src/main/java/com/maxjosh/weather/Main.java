package com.maxjosh.weather;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
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
        var topVbox = addVBox();
        rightVbox.setStyle("-fx-background-color: #336699;");
        leftVbox.setStyle("-fx-background-color: #336699;");
        topVbox.setStyle("-fx-background-color: #336699;");
        bottomVbox.setStyle("-fx-background-color: #336699;");
        centerVbox.setStyle("-fx-background-color: #336699;");

        /****************************
        * text and title and other styling features for
         * vboxes
        * *********************/
        Text titleRight = new Text("Weather Details");
        titleRight.setFont(new Font("Arial", 20));
        Text titleLeft = new Text("Time of the day");
        titleLeft.setFont(new Font("Arial", 20));





        /*****************************************
        * topBorder container
         * @city
        *******************************************/
        Label city = new Label();
        /*cityName is going into bottom container*/
        TextField cityName = new TextField();
        /*********************************
         * rightBorder container
         *include labels for keys
         * values:
         * @temperatureValue
         * @humidityValue
         * @windValue
         * @pressValue
         * @cloudValue
         * keys:
         * @temperatureKey
         * @humidityKey
         * @windKey
         * @cloudKey
         ***********************************/

        Label temperatureValue = new Label();
        Label humidityValue = new Label();
        Label windValue = new Label();
        Label pressValue = new Label();
        Label cloudValue = new Label();

        Label temperatureKey = new Label("Temperature: ");
        Label humidityKey = new Label("Humidity: ");
        Label windKey = new Label("Wind: ");
        Label pressKey = new Label("Pressure: ");
        Label cloudKey = new Label("Cloudiness: ");

        /***********************
        *leftBorder container
        * @image param
        *************************/
        Label dayValue = new Label();
        Label image = new Label();
        /*******************
        *centerBorder
        *container
        *@desc param
        *******************/
        Label desc = new Label();


        /**********************
        *creating button called
        *@submit param
        **** ******************/
        Button submit = new Button("Submit");
        submit.setStyle("-fx-background-color: #7fff00");
        submit.setFont(new Font("sans-serif", 16));


        /****************
        * eventHandler
        * @submit param
        ****************/
        submit.setOnAction(e -> {
            //deg.setText("Loading forecast for: " + cityName.getText());
            var forecast = new Forecast(cityName.getText().substring(0,1).toUpperCase(Locale.ROOT)+cityName.getText().substring(1, cityName.getLength()));
            try {
                forecast.getWeather();
                city.setText(forecast.getCityName() + " ");
                temperatureValue.setText(forecast.getTemp() + "C");
                humidityValue.setText(forecast.getHumidity() + "%");
                windValue.setText(forecast.getWindSpeed()+ "m/s");
                pressValue.setText(forecast.getPressure()+ "Hg");
                cloudValue.setText(forecast.getCloudiness()+ " ");
                dayValue.setText(forecast.getDay());
                desc.setText(forecast.getDesc()+ ".");

            } catch(IOException ex) {
                city.setText(ex.toString());
                temperatureValue.setText(ex.toString());
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
        rightPaneValues.getChildren().add(temperatureValue);
        rightPaneValues.getChildren().add(humidityValue);
        rightPaneValues.getChildren().add(windValue);
        rightPaneValues.getChildren().add(pressValue);
        rightPaneValues.getChildren().add(cloudValue);

        rightPaneKeys.getChildren().addAll(temperatureKey,humidityKey, windKey, pressKey, cloudKey);
        leftPane.getChildren().add(dayValue);
        centerPane.getChildren().add(desc);

        /*****************************************
         * adding innerContainer to median-containers
        ********************************************/
        rightVbox.getChildren().addAll(titleRight, rightPaneKeys, rightPaneValues);
        leftVbox.getChildren().addAll(titleLeft,leftPane);
        centerVbox.getChildren().add(centerPane);
        topVbox.getChildren().add(topPane);
        bottomVbox.getChildren().add(bottomPane);


        /*******************************************
         * setting orientation
         * inside inner containers
         * then set it to outer containers
         *******************************************/
        rightPaneValues.setOrientation(Orientation.VERTICAL);
        rightPaneValues.setColumnHalignment(HPos.RIGHT);
        rightPaneKeys.setOrientation(Orientation.VERTICAL);
        rightPaneKeys.setColumnHalignment(HPos.LEFT);
//        rightPaneValues.setHgap(20);
        rightPaneValues.setPadding(new Insets(10, 10, 10, 10));
        rightPaneValues.setVgap(15);
        rightPaneValues.setStyle("-fx-background-color: #adff2f;");
        rightPaneKeys.setVgap(15);
        rightPaneKeys.setStyle("-fx-background-color: #adff2f;");
        leftPane.setOrientation(Orientation.VERTICAL);
        leftPane.setPadding(new Insets(40));
        leftPane.setStyle("-fx-background-color: #adff2f");
        topPane.setOrientation(Orientation.HORIZONTAL);
        topPane.setStyle("-fx-background-color: #adff2f");
        topPane.setPadding(new Insets(20, 20, 10, 10));
        topPane.setAlignment(Pos.TOP_CENTER);
        centerPane.setOrientation(Orientation.VERTICAL);
        centerPane.setPadding(new Insets(40));
        centerPane.setStyle("-fx-background-color: #adff2f");
        centerPane.setAlignment(Pos.CENTER);

        bottomPane.setAlignment(Pos.BOTTOM_CENTER);
        bottomPane.setStyle("-fx-background-color: #adff2f");



//        border.setCenter(centerPane);
//        border.setTop(topPane);
//        border.setBottom(bottomPane);
//        border.setLeft(leftPane);


        border.setRight(rightVbox);
        border.setLeft(leftVbox);
        border.setCenter(centerVbox);
        border.setBottom(bottomVbox);
        border.setTop(topVbox);


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
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
//        vbox.setBorder(new Border());
//        Text title = new Text("Weather Details");
//        title.setFont(new Font("Arial", 24));
//        vbox.getChildren().add(title);

        return vbox;
    }
    public static void main(String[] args) {
        launch();
    }

}
