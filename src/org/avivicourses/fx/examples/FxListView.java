package org.avivicourses.fx.examples;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import org.avivicourses.fx.FxApp;

public class FxListView extends FxApp {

    Button button;
    ListView<String> listView;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    protected Parent populateLayout() {
        button = new Button("Click me");

        listView = new ListView<>();
        listView.getItems().addAll("Iron man", "Titanic", "Hitman");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        button.setOnAction(event -> clicked());
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(listView, button);
        return layout;
    }

    private void clicked() {
        ObservableList<String> movies = listView.getSelectionModel().getSelectedItems();
        movies.forEach(System.out::println);
    }

    @Override
    protected void beforeApp() {
        setTitle("List View");
    }

    @Override
    protected void afterApp() {

    }

}
