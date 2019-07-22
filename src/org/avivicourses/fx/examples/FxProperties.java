package org.avivicourses.fx.examples;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import org.avivicourses.fx.FxApp;
import org.avivicourses.fx.domain.Person;

public class FxProperties extends FxApp {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    protected Parent populateLayout() {
        Person person = new Person();
        person.firstNameProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            System.out.println(person.firstNameProperty());
            System.out.println(person.getFirstName());
        });

        Button click = new Button("Click");
        click.setOnAction(event -> person.setFirstName("porky"));
        StackPane layout = new StackPane();
        layout.getChildren().add(click);

        return layout;
    }
}
