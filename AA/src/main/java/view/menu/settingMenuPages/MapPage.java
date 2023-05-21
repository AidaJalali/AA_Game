package view.menu.settingMenuPages;
import controller.SettingMenuController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.menu.EnterMenu;
import view.menu.SettingMenu;

public class MapPage extends Application {
    public static Stage stage;
    private static SettingMenuController settingMenuController;
    private final String css = this.getClass().getResource("/css/style.css").toExternalForm();
    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/fxml/SettingMenuPages/MapPage.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        EnterMenu.stage = stage;
    }

    public void chooseMapOne(ActionEvent event){
        SettingMenuController.setNumberOfLittleBallsOnBigBall(6);
    }

    public void chooseMapTwo(ActionEvent event){
        SettingMenuController.setNumberOfLittleBallsOnBigBall(12);
    }

    public void chooseMapThree(ActionEvent event){
        SettingMenuController.setNumberOfLittleBallsOnBigBall(20);
    }

    public void backToSettingMenu(ActionEvent event) throws Exception {
        new SettingMenu().start(stage);
    }

    public static SettingMenuController getSettingMenuController() {
        return settingMenuController;
    }

    public static void setSettingMenuController(SettingMenuController settingMenuController) {
        MapPage.settingMenuController = settingMenuController;
    }

}
