package com.dofasu.javamon.view;

import com.dofasu.javamon.controller.Controller;
import com.dofasu.javamon.view.components.Container;
import com.dofasu.javamon.view.components.StandardButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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

        VBox col = new VBox(title, new StandardButton("Start", onStart), new Text("\n\n"));
        col.setAlignment(Pos.CENTER);

        setAlignment(Pos.CENTER);
        getChildren().add(new Container(500, 250, col, .4));

        setBackground(controller.getBackgroundImage("/background1.png"));
    }

    final private EventHandler<ActionEvent> onStart = (ActionEvent e) -> {
        controller.goTo(this.getScene(), new SelectionView());
    };
}
