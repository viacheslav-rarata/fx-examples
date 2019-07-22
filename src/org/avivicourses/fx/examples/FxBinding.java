package org.avivicourses.fx.examples;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import org.avivicourses.fx.FxApp;


public class FxBinding extends FxApp {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    protected Parent populateLayout() {
        IntegerProperty x = new SimpleIntegerProperty(3);
        IntegerProperty y = new SimpleIntegerProperty();
        y.bind(x.multiply(10));

        System.out.println(x.getValue());
        System.out.println(y.getValue());
        x.setValue(9);
        System.out.println(x.getValue());
        System.out.println(y.getValue());

        Button button = new Button("Submit");
        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        return layout;
    }
}
