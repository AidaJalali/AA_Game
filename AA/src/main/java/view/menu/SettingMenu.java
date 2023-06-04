package view.menu;

import controller.SettingMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SettingMenu extends Application {
    private static SettingMenuController settingMenuController;
    public static Stage stage;
    public String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private int numberOfLittleBallsOnBigBall = 6;
    private int numberOfLittleBallsForPlayer = 5;
    public void start(Stage stage) throws Exception {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/fxml/SettingMenu.fxml"));
        Scene scene = new Scene(anchorPane);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        SettingMenu.stage = stage;
    }

    public void setDifficulty(MouseEvent mouseEvent){}

    public void selectMap1(MouseEvent mouseEvent) throws Exception {
        this.numberOfLittleBallsOnBigBall = 6;
    }

    public void selectMap2(MouseEvent mouseEvent)throws Exception{
        this.numberOfLittleBallsOnBigBall = 12;
    }

    public void selectMap3(MouseEvent mouseEvent)throws Exception{
        this.numberOfLittleBallsOnBigBall = 20;
    }

    public void setLittleNumbers(MouseEvent mouseEvent){

    }
    public void setMute(MouseEvent mouseEvent){}

    public void setTheme(MouseEvent mouseEvent){}

    public void changeLanguage(MouseEvent mouseEvent){}

    public void changeButtons(MouseEvent mouseEvent){}

    public void backToMainMenu(MouseEvent mouseEvent) throws Exception {
        new MainMenu().start(stage);
    }

    public static SettingMenuController getSettingMenuController() {
        return settingMenuController;
    }

    public static void setSettingMenuController(SettingMenuController settingMenuController) {
        SettingMenu.settingMenuController = settingMenuController;
    }

}
