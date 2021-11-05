package com.dofasu.javamon;

import com.dofasu.javamon.views.StartView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    @Override
    public void start(Stage mainWindow) throws IOException {
        Scene scene = new Scene(new StartView());
        scene.getRoot().setStyle("-fx-font-family: 'sans-serif'");
        mainWindow.setMinHeight(750);
        mainWindow.setMinWidth(1100);
        mainWindow.setTitle("Javamon");
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
