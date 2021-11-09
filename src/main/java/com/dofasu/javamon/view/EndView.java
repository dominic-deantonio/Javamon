package com.dofasu.javamon.view;

import com.dofasu.javamon.controller.Controller;
import com.dofasu.javamon.model.Javamon;
import com.dofasu.javamon.view.component.Container;
import com.dofasu.javamon.view.component.StandardButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class EndView extends VBox {

    Controller controller = Controller.getInstance();

    public EndView(Boolean playerWins) {
        super(5);

        String message = playerWins ? "You win!" : "You lose!";
        Text title = new Text(message);
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        title.setFill(Color.WHITE);

        Javamon winner = playerWins ? controller.getPlayer() : controller.getOpponent();

        ImageView winnerImage = controller.getImageView(winner.getImageUrl());
        winnerImage.setFitHeight(350);

        setStyle("-fx-font-family: 'sans-serif'");
        this.setFillWidth(false);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(
                new Container(400, 100, title, .5),
                new Text("\n"),
                winnerImage,
                new Text("\n"),
                new StandardButton("Select another Javamon", onClick),
                new Text("\n\n\n\n")
        );
        setBackground(controller.getBackgroundImage("/background1.png"));
    }

    final private EventHandler<ActionEvent> onClick = (ActionEvent e) -> {
        controller.goTo(this.getScene(), new SelectionView());
    };


}
