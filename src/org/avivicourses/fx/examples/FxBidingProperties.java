package org.avivicourses.fx.examples;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.avivicourses.fx.FxApp;

public class FxBidingProperties extends FxApp {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    protected Parent populateLayout() {

        TextField userInput = new TextField();
        userInput.setMaxWidth(200);
        Label label1 = new Label("Welcome ");
        Label label2 = new Label();

        HBox hBox = new HBox(label1, label2);
        hBox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10, userInput, hBox);
        layout.setAlignment(Pos.CENTER);
        label2.textProperty().bind(userInput.textProperty());
        return layout;
    }
}
