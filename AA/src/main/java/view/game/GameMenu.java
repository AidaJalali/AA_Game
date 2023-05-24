package view.game;

import controller.GameController;
import controller.SettingMenuController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.BigBall;
import model.Game;
import model.LittleBall;
import view.animation.ShootingAnimation;
import view.menu.MainMenu;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class GameMenu extends Application {
    public static Stage stage;
    private static GameController gameController;
    public final String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private Game game;
    private Pane pane = new Pane();
    private Scene scene;


    public static GameController getGameController() {
        return gameController;
    }

    public static void setGameController(GameController gameController) {
        GameMenu.gameController = gameController;
    }

    public void start(Stage stage) throws Exception {
        GameMenu.stage = stage;
        pane = FXMLLoader.load(this.getClass().getResource("/fxml/Game.fxml"));
        scene = new Scene(pane);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        initializeGame();
    }

    private void initializeGame() {
        Game game = new Game(new BigBall() , SettingMenuController.getNumberOfLittleBallsOnBigBall());
        GameController.setGame(game);
        this.game = game;
        StackPane stack = new StackPane();
        stack.setLayoutX(game.getBigBall().getCenterX() - 60);
        stack.setLayoutY(game.getBigBall().getCenterY() - 30);
        Text text = new Text("aa");
        text.setFill(Color.WHITE);
        text.setFont(Font.font("Arial", FontWeight.BOLD, 100));
        text.setBoundsType(TextBoundsType.VISUAL);
        stack.getChildren().add(game.getBigBall());
        stack.getChildren().add(text);
        //
        setPlayerBalls();
        setLittleBallsOnBigBall();
        setRotationSetting();
        //
        setShootingSetting();
        pane.getChildren().add(game.getBigBall());
        pane.getChildren().add(game.getInvisibleBall());
        pane.getChildren().add(stack);
    }

    private void setPlayerBalls() {
        int numberOfBalls = SettingMenuController.getNumberOfLittleBallsForPlayer();
        for (int i = 0; i < numberOfBalls; i++) {
            LittleBall littleBall = new LittleBall();
            littleBall.setCenterX(game.getBigBall().getCenterX());
            littleBall.setCenterY(game.getBigBall().getCenterY());
            StackPane stack = new StackPane();
            stack.setLayoutX(game.getInvisibleBall().getCenterX());
            stack.setLayoutY(game.getInvisibleBall().getCenterY() + game.getInvisibleBall().getRadius() + 80);
            Text text = new Text(String.valueOf(i));
            text.setFill(Color.WHITE);
            text.setBoundsType(TextBoundsType.VISUAL);
            stack.getChildren().add(littleBall);
            stack.getChildren().add(text);
            game.addLittleBallsForPlayer(stack);
            pane.getChildren().add(stack);
        }
        for (int i = 0; i < numberOfBalls - 1; i++)
            game.getLittleBallsForPlayer().get(i).setVisible(true);
    }

    public void setLittleBallsOnBigBall() {
        Circle invisibleBall = game.getInvisibleBall();
        int angle = 360 / SettingMenuController.getNumberOfLittleBallsOnBigBall();
        for (int i = 0; i < SettingMenuController.getNumberOfLittleBallsOnBigBall(); i++) {
            game.getBigBall().addLittleBallToBigBall(new LittleBall());
            double x = invisibleBall.getCenterX() + cos(i * angle) * invisibleBall.getRadius();
            double y = invisibleBall.getCenterY() + sin(i * angle) * invisibleBall.getRadius();
            game.getBigBall().getLittleBalls().get(i).setCenterX(x);
            game.getBigBall().getLittleBalls().get(i).setCenterY(y);
            pane.getChildren().add(game.getBigBall().getLittleBalls().get(i));
        }
    }

    private void setRotationSetting() {
        for (int i = 0; i < game.getBigBall().getLittleBalls().size(); i++) {
            LittleBall littleBall = game.getBigBall().getLittleBalls().get(i);
            Line line = new Line();
            line.setStartX(game.getBigBall().getCenterX());
            line.setStartY(game.getBigBall().getCenterY());
            line.setEndX(littleBall.getCenterX());
            line.setEndY(littleBall.getCenterY());
            game.getLittleBallsOnBigBall().getChildren().add(littleBall);
            game.getLinesGroup().getChildren().add(line);
        }
        pane.getChildren().add(game.getLittleBallsOnBigBall());
        pane.getChildren().add(game.getLinesGroup());
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(30), event -> {
            double angle1 = (game.getLittleBallsOnBigBall().getRotate() + 1) % 360;
            double angle2 = (game.getLinesGroup().getRotate() + 1) % 360;
            game.getLittleBallsOnBigBall().setRotate(angle1);
            game.getLinesGroup().setRotate(angle2);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void setShootingSetting() {
        stage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode().equals(KeyCode.SPACE)) {
                    new ShootingAnimation(pane, game).play();
                }
            }
        });
    }


    public void Back() throws Exception {
        new MainMenu().start(stage);
    }

    public Game getGame() {
        return game;
    }


}
