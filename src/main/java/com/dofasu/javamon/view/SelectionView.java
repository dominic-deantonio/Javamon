package com.dofasu.javamon.view;

import com.dofasu.javamon.controller.Controller;
import com.dofasu.javamon.controller.Images;
import com.dofasu.javamon.models.ElementType;
import com.dofasu.javamon.models.Javamon;
import com.dofasu.javamon.view.components.StandardButton;
import com.dofasu.javamon.view.components.ElementTypeButton;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SelectionView extends VBox {
    Controller controller = Controller.getInstance();
    Javamon selectedMon;
    ImageView selectedMonImage = new ImageView();
    ElementTypeButton selectedMonTypeLabel = new ElementTypeButton(ElementType.ELECTRIC);

    public SelectionView() {
        super(5);
        controller.buildJavamon();
        setStyle("-fx-font-family: 'sans-serif'");
        selectedMonImage.setFitHeight(350);
        selectedMonImage.setPreserveRatio(true);

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
                selectedMonImage == null ? new Text("") : selectedMonImage,
                selectedMonTypeLabel
        );
        column.setAlignment(Pos.CENTER);
        column.setSpacing(100);
        return column;
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
        List<Javamon> javamonList = new ArrayList<>(controller.getJavamonList());
        selectedMon = javamonList.get(newValue.intValue());
        selectedMonImage.setImage(Images.getImage(selectedMon.getImageUrl()));
        selectedMonTypeLabel.updateType(selectedMon.getType());
    };

    final private EventHandler<ActionEvent> startBattle = (ActionEvent e) -> {
        controller.startBattle(this.getScene(), selectedMon);
    };
}
