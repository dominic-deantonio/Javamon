package com.dofasu.javamon.view;

import com.dofasu.javamon.controller.Images;
import com.dofasu.javamon.controller.Navigator;
import com.dofasu.javamon.view.components.StandardButton;
import com.dofasu.javamon.view.components.TypeLabel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class BattleView extends VBox {


    public BattleView() {
        super(5);


        this.setFillWidth(false);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(
                getOpponent(),
                new Text("\n\n\n\n\n"),
                getPlayer(),
                new StandardButton("End Game!", onClick),
                new Text("\n\n\n\n")
        );
    }

    private HBox getOpponent() {
        ImageView opponentImage = Images.getImage("/pikachu.png");
        HBox hbox = new HBox(getHealthBar(), opponentImage);
        hbox.setSpacing(200);
        return hbox;
    }

    private HBox getPlayer() {
        ImageView playerImage = Images.getImage("/pikachu.png");
        playerImage.setScaleX(-1);
        HBox hbox = new HBox(playerImage, getHealthBar());
        hbox.setSpacing(200);
        return hbox;
    }

    private VBox getHealthBar() {
        HBox nameAndHealth = new HBox();
        nameAndHealth.getChildren().addAll(
                new Text("Pikachu" + "     "),
                new TypeLabel(),
                new Text("             "),
                new Text("70 HP")
        );

        StackPane bar = new StackPane();
        bar.getChildren().addAll(
                new Rectangle(300, 20, Color.BLUE)
        );

        VBox row = new VBox();
        row.getChildren().addAll(
                nameAndHealth,
                bar
        );
        row.setSpacing(10);
        return row;
    }

    final private EventHandler<ActionEvent> onClick = (ActionEvent e) -> {
        // TODO: merge the navigator into the controller
        new Navigator().goTo(this.getScene(), new GameOverView());
    };


}
