package com.dofasu.javamon.controller;

import com.dofasu.javamon.view.SelectionView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Merge this class's methods into the Controller
 */
public class Navigator {

    public void goTo(Scene scene, Pane nextView) {
        scene.setRoot(nextView);
    }


}
