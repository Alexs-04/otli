package com.korebit.app;

import com.korebit.util.Paths;
import com.korebit.util.ShowAlert;
import com.korebit.util.WindowLoader;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            WindowLoader.showWindow(Paths.MAIN_TEST, "Test", false);
        } catch (IOException e) {
            ShowAlert.showAlert("NO SE PUDO CARGAR LA VENTANA PRINCIPAL", "Error al cargar la ventana", "Error", "error");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}