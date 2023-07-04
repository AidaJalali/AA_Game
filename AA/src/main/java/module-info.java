module AA {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires com.google.gson;

    exports view.animation;
    exports view.menu;
    exports enums;
    exports controller;
    exports model;
    exports view.game;

    opens view.animation to com.google.gson,javafx.fxml;
    opens view.menu to com.google.gson, javafx.fxml;
    opens view.game to com.google.gson,javafx.fxml;
    opens enums to com.google.gson,javafx.fxml;
    opens controller to  com.google.gson,javafx.fxml;
    opens model to com.google.gson,javafx.fxml;

}


