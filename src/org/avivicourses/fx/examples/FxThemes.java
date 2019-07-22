package org.avivicourses.fx.examples;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import org.avivicourses.fx.FxApp;

import java.util.Optional;

public class FxThemes extends FxApp {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    protected void afterApp() {
        getScene().getStylesheets().add(getClass().getClassLoader().getResource("Viper.css").toExternalForm());
    }

    @Override
    protected Parent populateLayout() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        Label userName = new Label("userName");
        userName.setStyle("-fx-text-fill: aquamarine");
        GridPane.setConstraints(userName, 0, 0);
        TextField bucky = new TextField("bucky");
        GridPane.setConstraints(bucky, 1, 0);
        Label userPass = new Label("password");
        userPass.setId("bold-label");
        GridPane.setConstraints(userPass, 0, 1);
        TextField pass = new TextField();
        pass.setPromptText("password...");
        GridPane.setConstraints(pass, 1, 1);

        Button login = new Button("Login");
        login.setOnAction(event -> {
            setUserAgentStylesheet(STYLESHEET_CASPIAN);
            alert();
        });
        GridPane.setConstraints(login, 1, 2);

        Button changeStyle = new Button("Change style");
        changeStyle.getStyleClass().add("button-blue");
        changeStyle.setOnAction(event -> setUserAgentStylesheet(STYLESHEET_CASPIAN));
        GridPane.setConstraints(changeStyle, 1, 3);

        gridPane.getChildren().addAll(userName, bucky, userPass, pass, login, changeStyle);
        return gridPane;
    }

    private void alert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("This is a Regular Confirmation Dialog");
        alert.setContentText("This is the message");

        Button button = new Button("Click to display an alert");
        button.setOnAction(e->{
            Optional<ButtonType> result = alert.showAndWait();
            result.ifPresent(System.out::println);
        });

        Scene scene = new Scene(new StackPane(button), 300, 200);
        setScene(scene);
    }
}
