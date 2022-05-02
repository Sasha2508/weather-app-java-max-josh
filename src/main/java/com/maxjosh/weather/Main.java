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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.IOException;
import java.util.Locale;

public class Main extends Application {

    /** Set up a maven run profile in intellij or use maven from the command-line.
        Use the javafx:run argument to start the javafx application.
        Update all code and comments in this template to suit your own project.
     */

    Stage window = new Stage();
    ImageView imageView = new ImageView();
    /*cityName is going into bottom container*/
    TextField cityName = new TextField();

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
        city.setFont(new Font("sans-serif", 28));
        city.setStyle("-fx-text-fill: #fffafa; -fx-font-weight: 700;");



        /*********************************
         * rightBorder container
         *include labels
         *
         * @temperatureValue
         * @humidityValue
         * @windValue
         * @pressValue
         * @cloudValue
         *
         ***********************************/

        Label temperatureValue = new Label();
        temperatureValue.setFont(new Font("sans-serif", 20));
        temperatureValue.setStyle("-fx-text-fill: #fffafa; -fx-font-weight: 700;");

        Label humidityValue = new Label();
        humidityValue.setFont(new Font("sans-serif", 20));
        humidityValue.setStyle("-fx-text-fill: #fffafa; -fx-font-weight: 700;");

        Label windValue = new Label();
        windValue.setFont(new Font("sans-serif", 20));
        windValue.setStyle("-fx-text-fill: #fffafa; -fx-font-weight: 700;");

        Label pressValue = new Label();
        pressValue.setFont(new Font("sans-serif", 20));
        pressValue.setStyle("-fx-text-fill: #fffafa; -fx-font-weight: 700;");

        Label cloudValue = new Label();
        cloudValue.setFont(new Font("sans-serif", 20));
        cloudValue.setStyle("-fx-text-fill: #fffafa; -fx-font-weight: 700;");


        /***********************
        *leftBorder container
        * @image param
        *************************/
        Label dayValue = new Label();
        dayValue.setFont(new Font("sans-serif", 24));
        dayValue.setStyle("-fx-text-fill: #fffafa; -fx-font-weight: 700;");
        /*******************
        *centerBorder
        *container
        *@desc param
        *******************/
        Label desc = new Label();
        desc.setFont(new Font("Lucida Sans Unicode", 24));
        desc.setStyle("-fx-text-fill: #fffafa; -fx-font-weight: 700;");


        /**********************
        *creating buttons called
        *@submit
         * @newSearch
         * @closeProgram
        **** ******************/
        Button submit = new Button("Submit");
        submit.setStyle("-fx-background-color: #adff2f; -fx-border-radius: 5");
        submit.setFont(new Font("sans-serif", 16));


        Button newSearch = new Button("New Search");
        newSearch.setStyle("-fx-background-color: #7cfc00; -fx-border-radius: 5");
        newSearch.setFont(new Font("sans-serif", 16));


        Button closeProgram = new Button("Close Program");
        closeProgram.setStyle("-fx-background-color: #7cfc00; -fx-border-radius: 5");
        closeProgram.setFont(new Font("sans-serif", 16));








        /****************
        * eventHandler
        * @submit param
        ****************/
        submit.setOnAction(e -> {
            var forecast = new Forecast(cityName.getText().substring(0,1).toUpperCase(Locale.ROOT)+cityName.getText().substring(1, cityName.getLength()));
            try {
                forecast.getWeather();
                city.setText(forecast.getCityName() + " ");
                temperatureValue.setText("Temperature: " + forecast.getTemp() + "C");
                humidityValue.setText("Humidity: " + forecast.getHumidity() + "%");
                windValue.setText("Wind Speed: " + forecast.getWindSpeed()+ "m/s");
                pressValue.setText("Pressure: " + forecast.getPressure()+ "Hg");
                cloudValue.setText("Cloudiness: " + forecast.getCloudiness()+ "%");
                dayValue.setText(forecast.getDay());
                desc.setText(forecast.getDesc()+ ".");

                /******************************
                 *ImageView
                 * @image param
                 * Has to upload on click Submit
                 *******************************/
                Image image;
                if (Integer.parseInt(forecast.getCloudiness()) >= 95 && Integer.parseInt(forecast.getHumidity()) >= 90 ) {
                    image = new Image("/images/rain.jpeg");
                } else {
                    image = new Image("/images/sun.png");
                }


                imageView.setImage(image);

            } catch(IOException ex) {
                city.setText(ex.toString());
                temperatureValue.setText(ex.toString());
            }
        });
        newSearch.setOnAction(e -> {
            boolean result = ConfirmBox.display("Title Of Window", "Are you sure you want to start a new search?");
            if (result == true){

            this.cityName.setText("");
            }
        });

        closeProgram.setOnAction(e -> closeProgram());






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
        var rightPane = new FlowPane();
        var centerPane = new FlowPane();
        var centerPaneButtons = new FlowPane();



        /*****************************
         * adding labels to containers
         *
        **********************************/
        bottomPane.getChildren().add(cityName);
        bottomPane.getChildren().add(submit);
        topPane.getChildren().add(city);
        rightPane.getChildren().add(temperatureValue);
        rightPane.getChildren().add(humidityValue);
        rightPane.getChildren().add(windValue);
        rightPane.getChildren().add(pressValue);
        rightPane.getChildren().add(cloudValue);


        leftPane.getChildren().addAll(dayValue, imageView);
        centerPane.getChildren().addAll(desc);
        centerPaneButtons.getChildren().addAll(newSearch, closeProgram);

        /*****************************************
         * adding innerContainer to median-containers
        ********************************************/
        rightVbox.getChildren().addAll(titleRight, rightPane);
        leftVbox.getChildren().addAll(titleLeft,leftPane);
        centerVbox.getChildren().addAll(centerPane, centerPaneButtons);
        topVbox.getChildren().add(topPane);
        bottomVbox.getChildren().add(bottomPane);


        /*******************************************
         * setting orientation
         * inside inner containers
         * then set it to outer containers
         *******************************************/
        rightPane.setOrientation(Orientation.VERTICAL);
        rightPane.setColumnHalignment(HPos.LEFT);

//        rightPane.setHgap(20);
        rightPane.setPadding(new Insets(10, 10, 10, 10));
        rightPane.setVgap(15);
//        rightPane.setStyle("-fx-background-color: #adff2f;");

        leftPane.setOrientation(Orientation.VERTICAL);
        leftPane.setPadding(new Insets(40));
//        leftPane.setStyle("-fx-background-color: #adff2f");
        topPane.setOrientation(Orientation.HORIZONTAL);
//        topPane.setStyle("-fx-background-color: #adff2f");
        topPane.setPadding(new Insets(20, 20, 10, 10));
        topPane.setAlignment(Pos.TOP_CENTER);
        centerPane.setPadding(new Insets(40));
//        centerPane.setStyle("-fx-background-color: #adff2f");
        centerPane.setAlignment(Pos.CENTER);

        centerPaneButtons.setAlignment(Pos.BOTTOM_CENTER);
        centerPaneButtons.setOrientation(Orientation.HORIZONTAL);
//        centerPaneButtons.setPadding(new Insets(30));
        centerPaneButtons.setHgap(20);

        bottomPane.setAlignment(Pos.BOTTOM_CENTER);
//        bottomPane.setStyle("-fx-background-color: #adff2f");

        border.setRight(rightVbox);
        border.setLeft(leftVbox);
        border.setCenter(centerVbox);
        border.setBottom(bottomVbox);
        border.setTop(topVbox);

        //defining scene
        Scene scene = new Scene(border, 900, 500);
        stage.setScene(scene);
        stage.setTitle("Weather App");
        window = stage;
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        stage.show();
    }

    private VBox addVBox(){
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        return vbox;
    }
    public static void main(String[] args) {
        launch();
    }

    private void closeProgram(){
        Boolean answer = ConfirmBox.display("Title", "Sure you want to exit?");
        if(answer) {
            window.close();
        }
    }

}
