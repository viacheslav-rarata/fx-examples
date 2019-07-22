package org.avivicourses.fx.examples;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import org.avivicourses.fx.FxApp;

public class FxCheckBox extends FxApp {

    Button button;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    protected Parent populateLayout() {
        CheckBox box1 = new CheckBox("bacon");
        CheckBox box2 = new CheckBox("tuna");
        box2.setSelected(true);

        button = new Button("Click me");
        button.setOnAction(event -> handleOptions(box1, box2));
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().setAll(box1, box2, button);
        return layout;
    }

    private void handleOptions(CheckBox box1, CheckBox box2) {
        System.out.println(box1.isSelected());
        System.out.println(box2.isSelected());
    }
}
