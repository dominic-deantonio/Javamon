package com.dofasu.javamon.views;

import com.dofasu.javamon.models.Constants;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StartView extends VBox {

    Button startButton = new Button("Start");
    Text errorMessage = new Text("");

    public StartView() {
        super(5);
        startButton.setStyle(Constants.BUTTON_COLOR);
        startButton.setPrefWidth(200);
        startButton.setTextFill(Color.WHITE);
        startButton.setOnAction((ActionEvent e) -> {
            errorMessage.setText("");
        });
        Text title = new Text("Javamon!\n");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 70));

        this.setFillWidth(false);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(
                new Text("Welcome to\n\n"),
                title,
                errorMessage,
                startButton,
                new Text("\n\n\n\n")
        );
    }
}
