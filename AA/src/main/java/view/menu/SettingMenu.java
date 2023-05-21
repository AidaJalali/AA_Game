package view.menu;

import controller.SettingMenuController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.menu.settingMenuPages.MapPage;

public class SettingMenu extends Application {
    public static Stage stage;
    public static int getNumberOfBallsForGame;
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

    public void setDifficulty(ActionEvent event){}

    public void goToMapPage(ActionEvent event) throws Exception {
        MapPage.setSettingMenuController(settingMenuController);
        new MapPage().start(stage);
    }

    public void setLittleNumbers(ActionEvent event){

    }

    public void setMute(ActionEvent event){}

    public void setTheme(ActionEvent event){}

    public void changeLanguage(ActionEvent event){}

    public void changeButtons(ActionEvent event){}

    public void backToMainMenu(ActionEvent event) throws Exception {
        new MainMenu().start(stage);
    }

    public static SettingMenuController getSettingMenuController() {
        return settingMenuController;
    }

    public static void setSettingMenuController(SettingMenuController settingMenuController) {
        SettingMenu.settingMenuController = settingMenuController;
    }


}
