package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DataEntryForm {
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        TextField nameField = new TextField();
        TextField emailField = new TextField();
        Button saveButton = new Button("Save");

        saveButton.setOnAction(e -> {
            saveDataToSpreadsheet(nameField.getText(), emailField.getText());
            nameField.clear();
            emailField.clear();
        });

        root.getChildren().addAll(
                new Label("Name:"),
                nameField,
                new Label("Email:"),
                emailField,
                saveButton
        );

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Data Entry Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void saveDataToSpreadsheet(String name, String email) {
        // Implement Apache POI logic to save data to spreadsheet here
        // This can include opening the existing spreadsheet, appending data, etc.
        // For simplicity, we won't implement this part in detail here.
    }

    public static void main(String[] args) {
        launch(args);
    }
}
