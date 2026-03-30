package JavaFX;

/*Colton Stone, March 29, 2026, Module 1.3 Assignment

In this program I will write code that randomly selects four images from a deck of fifty-two images */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.File;
import java.util.Random;


public class Main extends Application {
    @Override
    public void start(Stage mainStage) {
        javafx.scene.image.ImageView IView = new ImageView();
        IView.setFitHeight(500);
        IView.setPreserveRatio(true);
        javafx.scene.control.Button btn = new Button("Refresh Images");



        btn.setOnAction(event -> {
            File cardFolder = new File("JavaFX/cards");
            File[] files = cardFolder.listFiles((cards, name) ->
                    name.toLowerCase().endsWith(".png"));

            if (files != null && files.length > 0) {
                int randIndex = new Random().nextInt(files.length);
                File randomCard = files[randIndex];
                Image img = new Image(randomCard.toURI().toString());
                IView.setImage(img);            }
        });

        HBox box = new HBox(50, IView, btn);
        mainStage.setScene(new Scene(box,500, 500));
        mainStage.setTitle("Random Cards");
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}


