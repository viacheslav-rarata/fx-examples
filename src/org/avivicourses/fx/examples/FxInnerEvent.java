package org.avivicourses.fx.examples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FxInnerEvent  extends Application {
    Button button;
    Button btn;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("New of the window");
        button = new Button("Click me again");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("hello");
            }
        });
        btn = new Button("here");
        btn.setOnAction(e -> System.out.println("lambda"));
//        btn.setOnAction(e -> {System.out.println("lambda");});
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        // one on other
        layout.getChildren().add(btn);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
