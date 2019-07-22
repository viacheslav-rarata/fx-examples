package org.avivicourses.fx.fxml;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class SampleController implements Initializable {
    public Button button;

    public void handleBundleClick() {
        System.out.println("fxml from file");
        button.setText("Stop touching me");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("loading...");
    }
    public void onLogin() {
        System.out.println("You logged in");
    }
}
