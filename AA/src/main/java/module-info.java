module AA {
    requires javafx.controls;
    requires javafx.fxml;
    exports controller;
    exports view.menu;
    exports model;
    opens view.menu to javafx.fxml;
}

