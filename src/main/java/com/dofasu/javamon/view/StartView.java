package com.dofasu.javamon.view;

import com.dofasu.javamon.controller.Controller;
import com.dofasu.javamon.view.component.Container;
import com.dofasu.javamon.view.component.StandardButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StartView extends VBox {

    Controller controller = Controller.getInstance();

    public StartView() {
        super(5);

        Text title = new Text("Javamon");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 80));
        title.setFill(Color.WHITE);

        Text copyright = new Text("Copyright Dofasu, Inc. 2021\n\n");
        copyright.setFill(Color.WHITE);

        VBox col = new VBox(title, new Text("\n"), new StandardButton("Start", onStart), new Text("\n"), copyright);
        col.setAlignment(Pos.CENTER);

        setAlignment(Pos.CENTER);
        getChildren().add(new Container(500, 250, col, .4));

        setBackground(controller.getBackgroundImage("/background1.png"));
    }

    final private EventHandler<ActionEvent> onStart = (ActionEvent e) -> {
        controller.goTo(this.getScene(), new SelectionView());
    };
}
