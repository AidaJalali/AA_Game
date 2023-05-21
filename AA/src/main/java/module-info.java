module AA {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    exports controller;
    opens controller to javafx.fxml;
    exports model;
    opens model to com.google.gson;
    exports view.menu;
    opens view.menu to javafx.fxml;
    exports view.game;
    opens view.game to javafx.fxml;
    exports view.menu.settingMenuPages;
    opens view.menu.settingMenuPages to javafx.fxml;

}

