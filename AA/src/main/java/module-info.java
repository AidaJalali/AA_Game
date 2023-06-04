module AA {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires com.google.gson;
    exports controller;
    opens controller to javafx.fxml;
    exports model;
    opens model to com.google.gson;
    exports view.menu;
    opens view.menu to javafx.fxml;
    exports view.game;
    opens view.game to javafx.fxml;

}


