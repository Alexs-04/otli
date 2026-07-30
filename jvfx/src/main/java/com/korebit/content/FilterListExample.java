package com.korebit.content;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FilterListExample extends Application {

    @Override
    public void start(Stage stage) {
        ObservableList<User> users = FXCollections.observableArrayList(
                new User("Juan", "juan@example.com", 1),
                new User("Ana", "ana@example.com", 0),
                new User("Carlos", "carlos@example.com", 1),
                new User("Luis", "luis@example.com", 0)
        );

        FilteredList<User> usuariosFiltrados = new FilteredList<>(users, u -> true);

        TableView<User> tblUsers = new TableView<>(usuariosFiltrados);

        TableColumn<User, String> nameCol = new TableColumn<>("Nombre");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<User, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        tblUsers.getColumns().addAll(nameCol, emailCol);

        ComboBox<String> cbFilter = new ComboBox<>();
        cbFilter.getItems().addAll("Ver Todos", "Activos", "Inactivos");
        cbFilter.setValue("Ver Todos");

        cbFilter.setOnAction(event -> {
            String option = cbFilter.getValue();
            usuariosFiltrados.setPredicate(user -> {
                return switch (option) {
                    case "Activos" -> user.status() == 1;
                    case "Inactivos" -> user.status() == 0;
                    default -> true; // Ver Todos
                };
            });
        });

        // Layout
        VBox root = new VBox(10, cbFilter, tblUsers);
        root.setPadding(new Insets(10));
        root.setPrefSize(400, 300);

        stage.setScene(new Scene(root));
        stage.setTitle("Filtrar Usuarios (sin mostrar estado)");
        stage.show();
    }

    /**
     * @param status 1: Activo, 0: Inactivo
     */
    public record User(String name, String email, int status) {
    }

    public static void main(String[] args) {
        launch(args);
    }
}