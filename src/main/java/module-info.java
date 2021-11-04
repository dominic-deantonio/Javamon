module com.dofasu.javamon.javamon {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.dofasu.javamon to javafx.fxml;
    exports com.dofasu.javamon;
}