package view.menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProfileMenu extends Application {
    public String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private static ProfileMenuController profileMenuController;
    private static Stage stage;
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Parent parent = FXMLLoader.load(EnterMenu.class.getResource("/fxml/ProfileMenu.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }
}
