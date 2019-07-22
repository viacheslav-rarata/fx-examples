package org.avivicourses.fx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class FxApp extends Application {

    private Stage stage;
    private String title = "Fx App";
    private int width = 300;
    private int height = 250;
    private Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        beforeApp();
        stage.setTitle(title);

        Parent layout = populateLayout();
        if (scene == null) {
            if (width == 0 && height == 0) {
                scene = new Scene(layout);
            } else {
                scene = new Scene(layout, width, height);
            }
        }
        stage.setScene(scene);
        afterApp();
        stage.show();
    }

    public void setScene(Scene scene) {
        this.scene = scene;
        stage.setScene(scene);
    }
    protected void setTitle(String title) {
        this.title = title;
    }

    protected void setSizes(int width, int height) {
        this.width = width;
        this.height = height;
    }

    protected Scene getScene() {
        return scene;
    }

    protected void beforeApp() {}
    protected void afterApp() {}
    protected abstract Parent populateLayout();
}
