package org.avivicourses.fx.examples;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import org.avivicourses.fx.FxApp;

public class FxTreeView extends FxApp {

    TreeView<String> treeView;

    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    protected Parent populateLayout() {

        TreeItem<String> root, bucky, megan;

        root = new TreeItem<>();
        root.setExpanded(true);

        bucky = makeBranch("Bucky", root);
        makeBranch("youtube", bucky);
        makeBranch("films", bucky);
        makeBranch("music", bucky);

        megan = makeBranch("Megan", root);
        makeBranch("one", megan);
        makeBranch("two", megan);

        treeView = new TreeView<>(root);
        treeView.setShowRoot(false);
        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue!=null) {
                System.out.println(newValue.getValue());
            }
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(treeView);
        return layout;
    }

    private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

    @Override
    protected void beforeApp() {

    }

    @Override
    protected void afterApp() {

    }
}
