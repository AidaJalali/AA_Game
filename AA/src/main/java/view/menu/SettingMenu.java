package view.menu;

import controller.SettingMenuController;
import enums.GameLevel;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SettingMenu extends Application {
    private static SettingMenuController settingMenuController;
    public static Stage stage;
    public String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private AnchorPane anchorPane;
    private int numberOfLittleBallsOnBigBall = 6;
    private int numberOfLittleBallsForPlayer = 5;
    @FXML
    private RadioButton easy;
    @FXML
    private RadioButton medium;
    @FXML
    private RadioButton hard;
    public void start(Stage stage) throws Exception {
        SettingMenu.stage = stage;
        anchorPane = FXMLLoader.load(this.getClass().getResource("/fxml/SettingMenu.fxml"));
        Scene scene = new Scene(anchorPane);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        handle();
        stage.show();
    }

    private void handle() {

        EventHandler handler = new EventHandler() {
            @Override
            public void handle(Event event) {
                if (easy.isFocused()) {
                    settingMenuController.setSpeed(GameLevel.EASY.getSpeed());
                    settingMenuController.setFreezeTime(GameLevel.EASY.getFreezeTime());
                }
                if(medium.isFocused()){
                    settingMenuController.setSpeed(GameLevel.MEDIUM.getSpeed());
                    settingMenuController.setFreezeTime(GameLevel.MEDIUM.getFreezeTime());
                }
                if(hard.isFocused()){
                    settingMenuController.setSpeed(GameLevel.HARD.getSpeed());
                    settingMenuController.setFreezeTime(GameLevel.HARD.getFreezeTime());
                }
            }
        };
    }


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
