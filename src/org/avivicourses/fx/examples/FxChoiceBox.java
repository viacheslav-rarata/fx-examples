package org.avivicourses.fx.examples;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxChoiceBox extends Application {

    Stage window;
    Scene scene;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("CheckBox");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("banana");
        choiceBox.getItems().addAll("apple", "pineapple");

        choiceBox.setValue("apple");
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("from " + oldValue);
            System.out.println("to " + newValue);
        });
        button = new Button("Click me");
        button.setOnAction(event -> handleOptions(choiceBox));
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().setAll(choiceBox, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void handleOptions(ChoiceBox<String> choiceBox) {
        System.out.println(choiceBox.getValue());
    }

}
