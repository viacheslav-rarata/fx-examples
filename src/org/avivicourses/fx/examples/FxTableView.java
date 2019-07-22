package org.avivicourses.fx.examples;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import org.avivicourses.fx.FxApp;
import org.avivicourses.fx.domain.Product;

public class FxTableView extends FxApp {

    TableView<Product> table;

    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    protected Parent populateLayout() {
        TableColumn<Product, String> nameColumn = new TableColumn("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, String> priceColumn = new TableColumn("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, String> quantityColumn = new TableColumn("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        table = new TableView<>();
        table.setItems(getProducts());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);
        return vBox;
    }

    @Override
    protected void beforeApp() {
        setSizes(0,0);
    }

    @Override
    protected void afterApp() {

    }

    private ObservableList<Product> getProducts() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 859.0, 20));
        products.add(new Product("Mobile", 276.0, 140));
        products.add(new Product("Watch", 34.0, 420));
        return products;
    }
}
