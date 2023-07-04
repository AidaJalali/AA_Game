package view.menu;

import controller.SettingMenuController;
import enums.GameLevel;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingMenu extends Application implements Initializable {
    private static SettingMenuController settingMenuController;
    public static Stage stage;
    public static Boolean persianEffect = false;
    public String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private AnchorPane anchorPane;
    private int numberOfLittleBallsOnBigBall = 6;
    private int numberOfLittleBallsForPlayer = 5;

    public RadioButton easy;
    public RadioButton medium;
    public RadioButton hard;
    public CheckBox changeButton;
    public CheckBox changeTheme;
    public CheckBox persian;
    public Button addNumber;
    public TextField littleBalls;
    public void start(Stage stage) throws Exception  {
        SettingMenu.stage = stage;
        anchorPane = FXMLLoader.load(this.getClass().getResource("/fxml/SettingMenu.fxml"));
        Scene scene = new Scene(anchorPane);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        handle();
        stage.show();
    }

    private void handle() {

        EventHandler handler = event -> {
            if (easy.isSelected()) {
                settingMenuController.setSpeed(GameLevel.EASY.getSpeed());
                settingMenuController.setFreezeTime(GameLevel.EASY.getFreezeTime());
            }
            if(medium.isSelected()){
                settingMenuController.setSpeed(GameLevel.MEDIUM.getSpeed());
                settingMenuController.setFreezeTime(GameLevel.MEDIUM.getFreezeTime());
            }
            if(hard.isSelected()){
                settingMenuController.setSpeed(GameLevel.HARD.getSpeed());
                settingMenuController.setFreezeTime(GameLevel.HARD.getFreezeTime());
            }
            if(persian.isSelected()){
                persianEffect = true;
            }
            if(!persian.isSelected()){
                persianEffect = false;
            }
        };
        addNumber.setOnAction(actionEvent -> numberOfLittleBallsForPlayer = Integer.parseInt(littleBalls.getText()));

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
