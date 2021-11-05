package com.dofasu.javamon;

import com.dofasu.javamon.view.StartView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage window) {
        Scene scene = new Scene(new StartView());
        scene.getRoot().setStyle("-fx-font-family: 'sans-serif'");
        window.setMinHeight(750);
        window.setMinWidth(1100);
        window.setTitle("Javamon");
        window.setScene(scene);
        window.show();
    }


}
