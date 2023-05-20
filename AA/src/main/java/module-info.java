module AA {
    requires javafx.controls;
    requires javafx.fxml;
    exports controller;
    exports view;
    exports model;
    opens view to javafx.fxml;
    exports view.menu;
    opens view.menu to javafx.fxml;
}

