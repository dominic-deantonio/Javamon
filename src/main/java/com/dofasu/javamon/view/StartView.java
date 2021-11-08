package com.dofasu.javamon.view;

import com.dofasu.javamon.controller.Controller;
import com.dofasu.javamon.view.components.Container;
import com.dofasu.javamon.view.components.StandardButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StartView extends VBox {

    Controller controller = Controller.getInstance();

    public StartView() {
        super(5);

        Text title = new Text("Javamon\n");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 80));
        title.setFill(Color.WHITE);

        VBox col = new VBox(title, new StandardButton("Start", onClick), new Text("\n\n"));
        col.setAlignment(Pos.CENTER);

        setAlignment(Pos.CENTER);
        getChildren().add(new Container(500, 250, col, .4));

        setBackground(getBackgroundImage());
    }

    final private EventHandler<ActionEvent> onClick = (ActionEvent e) -> {
        controller.goTo(this.getScene(), new SelectionView());
    };

    private Background getBackgroundImage() {
        Image image = new Image("/background1.png", true);
        BackgroundImage bgImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1, 1, true, true, false, false));
        return new Background(bgImage);
    }
}
