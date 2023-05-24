package view.menu;

import controller.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.game.GameMenu;

public class MainMenu extends Application {
    public static Stage stage;
    public String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private static MainMenuController mainMenuController;
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/fxml/MainMenu.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        MainMenu.stage = stage;
    }

    public void startGame(ActionEvent event) throws Exception {
        GameController gameController = new GameController();
        //gameController.setCurrentUser(gameController.getCurrentUser());
        GameMenu.setGameController(gameController);
        new GameMenu().start(stage);
    }
    public void resumeGame() throws Exception{

    }

    public void enterProfileMenu() throws Exception{
        RegisterAndLoginAndProfileMenuController controller = new RegisterAndLoginAndProfileMenuController();
        //controller.setCurrentUser(mainMenuController.getCurrentUser());
        ProfileMenu.setProfileMenuController(controller);
        new ProfileMenu().start(stage);
    }

    public void enterSettingMenu() throws Exception{
        SettingMenuController settingMenuController = new SettingMenuController();
        //settingMenuController.setCurrentUser(mainMenuController.getCurrentUser());
        SettingMenu.setSettingMenuController(settingMenuController);
        new SettingMenu().start(stage);
    }

    public void enterScoreTable() throws Exception{
        ScoreMenuController scoreMenuController = new ScoreMenuController();
        //scoreMenuController.setCurrentUser(mainMenuController.getCurrentUser());
        ScoreMenu.setScoreMenuController(scoreMenuController);
        new ScoreMenu().start(stage);
    }

    public void exit() throws Exception{
        new EnterMenu().start(stage);
    }
    public static MainMenuController getMainMenuController() {
        return mainMenuController;
    }

    public static void setMainMenuController(MainMenuController mainMenuController) {
        MainMenu.mainMenuController = mainMenuController;
    }

}
