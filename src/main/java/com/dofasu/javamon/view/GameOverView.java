package com.dofasu.javamon.view;

import com.dofasu.javamon.controller.Navigator;
import com.dofasu.javamon.view.components.StandardButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GameOverView extends VBox {

    public GameOverView() {
        super(5);

        Text title = new Text("Game Over!\n");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 70));

        this.setFillWidth(false);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(
                title,
                new StandardButton("Select another Javamon", onClick),
                new Text("\n\n\n\n")
        );
    }

    final private EventHandler<ActionEvent> onClick = (ActionEvent e) -> {
        // TODO: merge the navigator into the controller
        new Navigator().goTo(this.getScene(), new SelectionView());
    };

}
