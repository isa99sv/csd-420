package javafx.demo;

import java.util.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;

/* Colton Stone, May 2, 2026, Module 7.2 Assignment

In this program I will write a JavaFX program that displays four different circles with an CSS style sheet which will set the colors for them .*/


public class Main extends Application {

    public void start(Stage primaryStage) {

        HBox hBox = new HBox(10);
        Scene scene = new Scene(hBox, 600, 300);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/mystyle.css")).toExternalForm());

        Circle circle1 = new Circle(40, 100, 25);
        Circle circle2 = new Circle(65, 100, 50);
        Circle circle3 = new Circle(90, 100, 75);
        Circle circle4 = new Circle(115, 100, 100);

        circle1.getStyleClass().add("circleclass");
        circle2.getStyleClass().add("circleclass");
        circle3.getStyleClass().add("circleclass");
        circle4.getStyleClass().add("circleclass");

        circle1.setId("redcolor");
        circle2.setId("greencolor");
        circle3.setId("redcolor");
        circle4.setId("greencolor");

        Pane pane1 = new Pane();
        Pane pane2 = new Pane();
        Pane pane3 = new Pane();
        Pane pane4 = new Pane();

        pane1.getChildren().add(circle1);
        pane2.getChildren().add(circle2);
        pane3.getChildren().add(circle3);
        pane4.getChildren().add(circle4);
        hBox.getChildren().addAll(pane1, pane2, pane3, pane4);

        primaryStage.setTitle("Circles Sample");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
