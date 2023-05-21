package view.menu;

import controller.ScoreMenuController;
import controller.SettingMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SettingMenu extends Application {
    public static Stage stage;
    public String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private static SettingMenuController settingMenuController;
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(EnterMenu.class.getResource("/fxml/SettingMenu.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        SettingMenu.stage = stage;
    }

    public static SettingMenuController getSettingMenuController() {
        return settingMenuController;
    }

    public static void setSettingMenuController(SettingMenuController settingMenuController) {
        SettingMenu.settingMenuController = settingMenuController;
    }
}
