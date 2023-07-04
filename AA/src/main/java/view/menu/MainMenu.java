package view.menu;

import controller.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import view.game.Game;
import java.util.Objects;

public class MainMenu extends Application {
    public static Stage stage;
    public String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private static MainMenuController mainMenuController;
    @FXML
    private ImageView imageView = new ImageView();
    public void start(Stage stage) throws Exception {
        Pane pane = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/fxml/MainMenu.fxml")));
        Scene scene = new Scene(pane);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        MainMenu.stage = stage;
    }

    public void startGame() throws Exception {
        GameController gameController = new GameController();
        gameController.setCurrentUser(gameController.getCurrentUser());
        Game.setGameController(gameController);
        new Game().start(stage);
    }
    public void resumeGame() throws Exception{

    }

    public void enterProfileMenu() throws Exception{
        RegisterAndLoginAndProfileMenuController controller = new RegisterAndLoginAndProfileMenuController();
        controller.setCurrentUser(mainMenuController.getCurrentUser());
        ProfileMenu.setProfileMenuController(controller);
        new ProfileMenu().start(stage);
    }

    public void enterSettingMenu() throws Exception{
        SettingMenuController settingMenuController = new SettingMenuController();
        settingMenuController.setCurrentUser(mainMenuController.getCurrentUser());
        SettingMenu.setSettingMenuController(settingMenuController);
        new SettingMenu().start(stage);
    }

    public void enterScoreTable() throws Exception{
        ScoreMenuController scoreMenuController = new ScoreMenuController();
        scoreMenuController.setCurrentUser(mainMenuController.getCurrentUser());
        ScoreMenu.setScoreMenuController(scoreMenuController);
        new ScoreMenu().start(stage);
    }

    public void exit() throws Exception{
        new PrimaryMenu().start(stage);
    }
    public static MainMenuController getMainMenuController() {
        return mainMenuController;
    }

    public static void setMainMenuController(MainMenuController mainMenuController) {
        MainMenu.mainMenuController = mainMenuController;
    }

}
