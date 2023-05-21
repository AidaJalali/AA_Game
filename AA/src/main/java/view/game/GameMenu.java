package view.game;

import controller.GameController;
import controller.SettingMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;
import model.BigBall;
import model.Game;
import model.LittleBall;
import view.menu.EnterMenu;

public class GameMenu extends Application {
    public static Stage stage;
    public final String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private static GameController gameController;
    private Game game;
    public void start(Stage stage) throws Exception {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/fxml/Game.fxml"));
        Scene scene = new Scene(anchorPane);
        scene.getStylesheets().add(css);
        initializeGame(anchorPane);
        GameMenu.stage = stage;
        stage.setScene(scene);
        stage.show();
    }

    private void initializeGame(AnchorPane anchorPane) {
        Game game = new Game(new BigBall());
        for (int i = 0; i < SettingMenuController.getNumberOfLittleBallsForPlayer();i++){
            game.addLittleBallsForPlayer(new LittleBall());
        }
        //TODO --> you should set balls based on map
        for (int i = 0; i < SettingMenuController.getNumberOfLittleBallsOnBigBall();i++){
            game.getBigBall().addLittleBallToBigBall(new LittleBall());
        }
        GameController.setGame(game);
        anchorPane.getChildren().add(game.getBigBall());
        anchorPane.getChildren().add(game.getInvisibleBall());
    }

    public void setLittleBalls(int numberOfBalls){
        for (int i = 0; i < SettingMenuController.getNumberOfLittleBallsForPlayer();i++){
            Circle circle = new Circle();
            Text text = new Text(String.valueOf(i));
            text.setBoundsType(TextBoundsType.VISUAL);
            StackPane stack = new StackPane();
            stack.getChildren().add(circle);
            stack.getChildren().add(text);
            game.addLittleBallsForPlayer(new LittleBall());
        }
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

    public Game getGame() {
        return game;
    }
}
