package view.menu;

import controller.MainMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class MainMenu extends Application {
    public String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private static MainMenuController mainMenuController;
    private static Stage stage;
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        URL url = MainMenu.class.getResource("/fxml/MainMenu.fxml");
        Parent parent = FXMLLoader.load(url);
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }
}
