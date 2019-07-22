package org.avivicourses.fx.examples;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FxGrid extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        primaryStage.setTitle("Multiple layouts");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        Label label = new Label("username:");
        GridPane.setConstraints(label, 0, 0);
        TextField bucky = new TextField("Bucky");
        GridPane.setConstraints(bucky, 1, 0);

        Label passLab = new Label("Pass:");
        GridPane.setConstraints(passLab, 0, 1);
        TextField passInp = new TextField();
        passInp.setPromptText("pass");
        GridPane.setConstraints(passInp, 1, 1);

        Button login = new Button("login");
        login.setOnAction(event -> isInt(passInp, passInp.getText()));
        GridPane.setConstraints(login, 1, 2);

        gridPane.getChildren().addAll(label, bucky, passLab, passInp, login);

        window.setScene(new Scene(gridPane, 300, 200));
        window.show();
    }

    private boolean isInt(TextField passInp, String text) {
        try {
            int age = Integer.parseInt(text);
            System.out.println(age);
            return true;
        }catch (NumberFormatException e) {
            System.out.println(" some error");
            return false;
        }
    }
}
