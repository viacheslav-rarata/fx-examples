package org.avivicourses.fx.examples;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FxFullScreen extends Application {
    Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        this.primaryStage = primaryStage;
        GridPane gp = new GridPane();
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25, 25, 25, 25));

        Scene firstScene = new Scene(gp, 300, 250);
        Button b = new Button("Change Scene");
        gp.add(b, 1, 1);
        b.setOnAction(event -> nextScene(primaryStage));

        primaryStage.setScene(firstScene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    private void nextScene(Stage primaryStage) {
        GridPane gp1 = new GridPane();
        Scene secondScene = new Scene(gp1);
        Text txtSecond = new Text("Second Scene");
        gp1.add(txtSecond, 1, 1);
        primaryStage.setScene(secondScene);
        primaryStage.setFullScreen(false);
        primaryStage.setFullScreen(true);
    }
}
