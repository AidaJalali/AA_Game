package view.game;

import controller.GameController;
import controller.SettingMenuController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.BigBall;
import model.Game;
import model.LittleBall;
import view.menu.MainMenu;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

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
        setRotationSettings();
        GameMenu.stage = stage;
        stage.setScene(scene);
        stage.show();
    }

    private void initializeGame(AnchorPane anchorPane) {
        Game game = new Game(new BigBall());
        GameController.setGame(game);
        this.game = game;
        setLittleBallsOnBigBall(anchorPane);
        setPlayerBalls(anchorPane);
        anchorPane.getChildren().add(game.getBigBall());
        anchorPane.getChildren().add(game.getInvisibleBall());
    }

    private void setPlayerBalls(AnchorPane anchorPane) {
        int numberOfBalls = SettingMenuController.getNumberOfLittleBallsForPlayer();
        for (int i = 0; i < numberOfBalls;i++){
            LittleBall littleBall = new LittleBall();
            littleBall.setCenterX(game.getBigBall().getCenterX());
            littleBall.setCenterY(game.getBigBall().getCenterY() - 100);
            StackPane stack = new StackPane();
            Text text = new Text(String.valueOf(i));
            text.setFill(Color.WHITE);
            text.setBoundsType(TextBoundsType.VISUAL);
            stack.getChildren().add(game.getBigBall());
            stack.getChildren().add(text);
            game.addLittleBallsForPlayer(littleBall);
            anchorPane.getChildren().add(stack);
        }
        for(int i = 0;i < numberOfBalls - 1;i++)
            game.getLittleBallsForPlayer().get(i).setVisible(false);
    }

    public void setLittleBallsOnBigBall(AnchorPane anchorPane){
        int numberOfBalls = SettingMenuController.getNumberOfLittleBallsOnBigBall();
        Circle invisibleBall = game.getInvisibleBall();
        int angle = 360 / numberOfBalls;
        for (int i = 0; i < numberOfBalls;i++){
            game.getBigBall().addLittleBallToBigBall(new LittleBall());
            double x = invisibleBall.getCenterX() + cos(i * angle) * invisibleBall.getRadius();
            double y = invisibleBall.getCenterY() + sin(i * angle) * invisibleBall.getRadius();
            game.getBigBall().getLittleBalls().get(i).setCenterX(x);
            game.getBigBall().getLittleBalls().get(i).setCenterY(y);
            anchorPane.getChildren().add(game.getBigBall().getLittleBalls().get(i));
        }
    }


    private void setRotationSettings() {
            for (int i = 0 ; i < game.getBigBall().getLittleBalls().size();i++){
                LittleBall littleBall = game.getBigBall().getLittleBalls().get(i);
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), event -> {
                    double angle = (littleBall.getRotate() + 1) % 360;
                    double x = game.getInvisibleBall().getCenterX() + game.getInvisibleBall().getRadius() * Math.cos(Math.toRadians(angle));
                    double y = game.getInvisibleBall().getCenterY() + game.getInvisibleBall().getRadius() * Math.sin(Math.toRadians(angle));
                    littleBall.setCenterX(x);
                    littleBall.setCenterY(y);
                    littleBall.setRotate(angle);
                }));
                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();
            }
    }


    public void Back() throws Exception {
        new MainMenu().start(stage);
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
