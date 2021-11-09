package com.dofasu.javamon.view.component;

import com.dofasu.javamon.controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MessageBox extends StackPane {
    final Controller controller = Controller.getInstance();
    private final Text messageText = new Text("Select an attack");
    private final StandardButton nextButton = new StandardButton("Next", e -> controller.nextStep(null));

    public MessageBox() {
        Rectangle box = new Rectangle(800, 100, Color.WHITESMOKE);
        box.setArcWidth(10.0);
        box.setArcHeight(10.0);
        box.setStrokeWidth(2);
        box.setStroke(Color.BLACK);

        messageText.setFont(Font.font("Verdana", 25));
        nextButton.setDisable(true);

        nextButton.setPrefWidth(60);
        HBox bottom = new HBox(nextButton, new Text("    "));
        bottom.setAlignment(Pos.BOTTOM_RIGHT);

        VBox col = new VBox(messageText, new Text(""), bottom);
        col.setAlignment(Pos.CENTER);

        getChildren().addAll(box, col);
        setAlignment(Pos.CENTER);
    }

    public void updateMessage(String message) {
        messageText.setText(message);
    }

    public void disableButton(boolean isDisabled) {
        nextButton.setDisable(isDisabled);
    }
}
