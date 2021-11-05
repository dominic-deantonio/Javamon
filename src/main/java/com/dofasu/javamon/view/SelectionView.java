package com.dofasu.javamon.view;

import com.dofasu.javamon.controller.Navigator;
import com.dofasu.javamon.view.components.StandardButton;
import com.dofasu.javamon.view.components.TypeLabel;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.List;

public class SelectionView extends VBox {

    public SelectionView() {
        super(5);

        Text title = new Text("Select Your Javamon!");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 70));

        HBox selector = new HBox(getListView(), getImageAndType());
        selector.setSpacing(100);

        this.setFillWidth(false);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(
                title,
                selector,
                new Text("\n\n"),
                new StandardButton("Start Battle!", startBattle)

        );
    }

    private VBox getImageAndType() {
        VBox column = new VBox();
        column.getChildren().addAll(
                getImage("/pikachu.png"),
                new TypeLabel()
        );
        column.setAlignment(Pos.CENTER);
        column.setSpacing(100);
        return column;
    }

    private ImageView getImage(String path) {
        ImageView iv = new ImageView(path);
        iv.setPreserveRatio(true);
        iv.setFitHeight(350);
        return iv;
    }

    private ListView<String> getListView() {
        List<String> pokes = Arrays.asList("Pikachu", "Charmander", "Jigglypuff");
        ObservableList<String> names = FXCollections.observableArrayList();
        pokes.forEach(p -> names.add(p));

        ListView<String> listView = new ListView<>(names);
        listView.getSelectionModel().selectedItemProperty().addListener(changeSelection);
        listView.getSelectionModel().select(0);
        return listView;
    }

    final private ChangeListener<String> changeSelection = (observable, oldValue, newValue) -> {
        System.out.println(oldValue);
        System.out.println(newValue);
    };

    final private EventHandler<ActionEvent> startBattle = (ActionEvent e) -> {
        // TODO: merge the navigator into the controller
        new Navigator().goTo(this.getScene(), new BattleView());
    };
}
