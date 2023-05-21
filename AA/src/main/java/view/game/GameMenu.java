package view.game;

import controller.GameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.BigBall;
import view.menu.EnterMenu;

public class GameMenu extends Application {
    public static Stage stage;
    private final String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private static GameController gameController;
    public void start(Stage stage) throws Exception {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/fxml/Game.fxml"));
        Scene scene = new Scene(anchorPane);
        scene.getStylesheets().add(css);
        intializeGame(anchorPane);
        GameMenu.stage = stage;
        stage.setScene(scene);
        stage.show();
    }

    private void intializeGame(AnchorPane anchorPane) {
        BigBall bigBall = new BigBall();
        for ()
    }

    public void Back() throws Exception {
        new EnterMenu().start(stage);
    }

    public static GameController getGameController() {
        return gameController;
    }

    public static void setGameController(GameController gameController) {
        GameMenu.gameController = gameController;
    }
}
