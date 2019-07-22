package org.avivicourses.fx.examples;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxComboBox extends Application {

    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("CheckBox");

        comboBox = new ComboBox<>();
        comboBox.getItems().add("banana");
        comboBox.getItems().addAll("apple", "pineapple");

        comboBox.setPromptText("Select fruit");
        comboBox.setOnAction(event -> System.out.println(comboBox.getValue()));
        comboBox.setEditable(true);

        button = new Button("Click me");
        button.setOnAction(event -> handleOptions(comboBox));
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().setAll(comboBox, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void handleOptions(ComboBox<String> comboBox) {
        System.out.println(comboBox.getValue());
    }

}
