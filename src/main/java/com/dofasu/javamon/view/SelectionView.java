package com.dofasu.javamon.view;

import com.dofasu.javamon.controller.Controller;
import com.dofasu.javamon.model.ElementType;
import com.dofasu.javamon.model.Javamon;
import com.dofasu.javamon.view.component.Container;
import com.dofasu.javamon.view.component.ElementTypeButton;
import com.dofasu.javamon.view.component.StandardButton;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Collection;

/**
 * SelectionView creates screen where the player selects
 * their Javamon
 * @author DOFASU
 * @version 1.0
 */

public class SelectionView extends VBox {
    Controller controller = Controller.getInstance();
    Javamon selectedMon;
    ImageView selectedMonImage = new ImageView();
    ElementTypeButton selectedMonTypeLabel = new ElementTypeButton(ElementType.ELECTRIC);

    /**
     * Registers the GUI to display the all the Javamon the player is able to select. The background
     * is a blue sky with clouds. The picture of the Javamon is on the right hand side of the screen.
     * The list of Javamon the player is able to select is on the left hand side of the screen.
     * Clicking on the name of the Javamon allows the player to select the Javamon. Also provides the
     * type of the Javamon
     */

    public SelectionView() {
        super(5);
        controller.buildJavamonList();
        setStyle("-fx-font-family: 'sans-serif'");
        selectedMonImage.setFitHeight(350);
        selectedMonImage.setPreserveRatio(true);

        Text title = new Text("Select your Javamon");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        title.setFill(Color.WHITE);

        HBox selector = new HBox(getListView(), getImageAndType());
        selector.setSpacing(100);

        this.setFillWidth(false);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(
                new Container(1000, 100, title, .4),
                selector,
                new Text("\n\n"),
                new StandardButton("Start Battle!", startBattle)
        );

        setBackground(controller.getBackgroundImage("/background1.png"));
    }

    private Node getImageAndType() {
        VBox column = new VBox();
        column.getChildren().addAll(
                selectedMonImage == null ? new Text("") : selectedMonImage,
                selectedMonTypeLabel
        );
        column.setAlignment(Pos.CENTER);
        column.setSpacing(100);

        return new Container(400, 500,  column, .4);
    }

    private ListView<String> getListView() {
        Collection<Javamon> javamonList = controller.getJavamonList();
        ObservableList<String> names = FXCollections.observableArrayList();
        javamonList.forEach(p -> names.add(p.getName()));

        ListView<String> listView = new ListView<>(names);
        listView.getSelectionModel().selectedIndexProperty().addListener(selectJavamon);
        listView.getSelectionModel().select(0);

        return listView;
    }

    final private ChangeListener<Number> selectJavamon = (observable, oldValue, newValue) -> {
        selectedMon = controller.getJavamonList().get(newValue.intValue());
        selectedMonImage.setImage(controller.getImage(selectedMon.getImageUrl()));
        selectedMonTypeLabel.updateType(selectedMon.getType());
    };

    final private EventHandler<ActionEvent> startBattle = (ActionEvent e) -> {
        controller.startBattle(this.getScene(), selectedMon);
    };


}
