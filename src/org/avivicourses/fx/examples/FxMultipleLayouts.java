package org.avivicourses.fx.examples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class FxMultipleLayouts extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        primaryStage.setTitle("Multiple layouts");

        HBox topMenu = new HBox();
        Button file = new Button("file");
        Button edit = new Button("edit");
        Button view = new Button("view");
        topMenu.getChildren().addAll(file, edit, view);

        VBox leftMenu = new VBox();
        Button fileD = new Button("fileD");
        Button editE = new Button("editE");
        Button viewF = new Button("viewF");
        leftMenu.getChildren().addAll(fileD, editE, viewF);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(leftMenu);

        Scene scene = new Scene(borderPane, 300, 250);
        window.setScene(scene);
        window.show();
    }
}
