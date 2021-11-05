package com.dofasu.javamon.controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Images {

    public static ImageView getImageView(String path) {
        ImageView iv = new ImageView(path);
        iv.setPreserveRatio(true);
        iv.setFitHeight(250);
        return iv;
    }


    public static Image getImage(String imageUrl) {
        return new Image(imageUrl);
    }
}
