package com.maxjosh.weather;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);

        //create 2 buttons
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox(10);
        FlowPane confirmPane = new FlowPane();
        confirmPane.getChildren().addAll(yesButton,noButton);
        confirmPane.setAlignment(Pos.BOTTOM_CENTER);
        confirmPane.setOrientation(Orientation.HORIZONTAL);
        layout.getChildren().addAll(label,confirmPane);
        layout.setAlignment(Pos.CENTER);



        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}

