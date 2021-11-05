package com.dofasu.javamon.view;

import com.dofasu.javamon.controller.Controller;
import com.dofasu.javamon.controller.Images;
import com.dofasu.javamon.controller.Navigator;
import com.dofasu.javamon.models.ElementType;
import com.dofasu.javamon.view.components.Bar;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BattleView extends VBox {

    Controller controller = Controller.getInstance();

    public BattleView() {
        super(5);


        this.setFillWidth(false);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(
                getOpponent(),
                new Text("\n\n\n\n"),
                getPlayer(),
                new StandardButton("End Game!", onClick),
                new Text("\n")
        );
    }

    private HBox getOpponent() {
        ImageView opponentImage = Images.getImageView("/pidgeotto.png");
        HBox hbox = new HBox(getHealthBar(), opponentImage);
        hbox.setSpacing(150);
        return hbox;
    }

    private HBox getPlayer() {
        ImageView playerImage = Images.getImageView("/pikachu.png");
        playerImage.setScaleX(-1);
        HBox hbox = new HBox(playerImage, getHealthBar());
        hbox.setSpacing(150);
        return hbox;
    }

    private VBox getHealthBar() {
        HBox healthBar = new HBox();
        StackPane bar = new StackPane();
        bar.getChildren().addAll(
                new Bar(300, Color.LIGHTGREY),
                new Bar(150, Color.DARKGREEN)
        );
        bar.setAlignment(Pos.CENTER_LEFT);
        Text hp = new Text("70 HP");
        hp.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        healthBar.getChildren().addAll(bar, hp);
        healthBar.setSpacing(10);

        Text javamonName = new Text("Pikachu");
        javamonName.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        VBox row = new VBox();
        row.getChildren().addAll(
                new Text("\n"),
                javamonName,
                healthBar,
                new TypeLabel(ElementType.ELECTRIC)
        );
        return row;
    }


    final private EventHandler<ActionEvent> onClick = (ActionEvent e) -> {
        // TODO: merge the navigator into the controller
        new Navigator().goTo(this.getScene(), new GameOverView());
    };


}
