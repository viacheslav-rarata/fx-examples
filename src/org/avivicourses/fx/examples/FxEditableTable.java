package org.avivicourses.fx.examples;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.avivicourses.fx.FxApp;
import org.avivicourses.fx.domain.Product;

public class FxEditableTable extends FxApp {

    TableView<Product> table;
    TextField nameInput, priceInput, quantityInput;

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

        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        priceInput = new TextField();
        priceInput.setPromptText("Price");

        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");

        Button add = new Button("add");
        add.setOnAction(event -> addAction());
        Button delete = new Button("delete");
        delete.setOnAction(event -> deleteAction());

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10,10,10,10));
        hbox.setSpacing(10);
        hbox.getChildren().addAll(nameInput, priceInput, quantityInput, add, delete);

        table = new TableView<>();
        table.setItems(getProducts());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hbox);
        return vBox;
    }

    private void deleteAction() {
        ObservableList<Product> selected, all;
        all = table.getItems();
        selected = table.getSelectionModel().getSelectedItems();
        selected.forEach(all::remove);
    }

    private void addAction() {
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setQuantity(Integer.parseInt(quantityInput.getText()));
        table.getItems().add(product);
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

    @Override
    protected void beforeApp() {
        setSizes(0,0);
    }

    @Override
    protected void afterApp() {

    }

    public ObservableList<Product> getProducts() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 859.0, 20));
        products.add(new Product("Mobile", 276.0, 140));
        products.add(new Product("Watch", 34.0, 420));
        return products;
    }
}
