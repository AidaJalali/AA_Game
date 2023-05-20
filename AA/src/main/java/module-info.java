module AA {
    requires javafx.controls;
    requires javafx.fxml;
    exports controller;
    opens controller to javafx.fxml;
    exports model;
    exports view.menu;
    opens view.menu to javafx.fxml;
}

