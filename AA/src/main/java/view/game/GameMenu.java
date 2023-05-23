package view.game;

import controller.GameController;
import controller.SettingMenuController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
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
import view.menu.MainMenu;

import static java.lang.Math.*;

public class GameMenu extends Application {
    public static Stage stage;
    public final String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private static GameController gameController;
    private Game game;
    private Pane pane = new Pane();
    private Scene scene;
    private Group littleBallsOnBigBall = new Group();
    private Group littleBallsForPlayer= new Group();
    private Group linesGroup = new Group();

    public void start(Stage stage) throws Exception {
        pane = FXMLLoader.load(this.getClass().getResource("/fxml/Game.fxml"));
        scene = new Scene(pane);
        scene.getStylesheets().add(css);
        initializeGame();
        GameMenu.stage = stage;
        stage.setScene(scene);
        stage.show();
    }

    private void initializeGame() {
        Game game = new Game(new BigBall());
        GameController.setGame(game);
        this.game = game;
        StackPane stack = new StackPane();
        stack.setLayoutX(game.getBigBall().getCenterX() - 70);
        stack.setLayoutY(game.getBigBall().getCenterY() - 30);
        Text text = new Text("AA");
        //TODO -> take this part to a function and fix the bug of a text
        text.setFill(Color.WHITE);
        text.setFont(Font.font("Arial", FontWeight.BOLD, 100));
        text.setBoundsType(TextBoundsType.VISUAL);
        stack.getChildren().add(game.getBigBall());
        stack.getChildren().add(text);
        setPlayerBalls();
        setLittleBallsOnBigBall();
        setRotationSetting();
        setShootingSetting();
        pane.getChildren().add(game.getBigBall());
        pane.getChildren().add(game.getInvisibleBall());
        pane.getChildren().add(stack);
    }


    private void setPlayerBalls() {
        int numberOfBalls = SettingMenuController.getNumberOfLittleBallsForPlayer();
        for (int i = 0; i < numberOfBalls;i++){
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
            game.addLittleBallsForPlayer(littleBall);
            littleBallsForPlayer.getChildren().add(littleBall);
            pane.getChildren().add(stack);
        }
        for(int i = 0;i < numberOfBalls - 1;i++)
            game.getLittleBallsForPlayer().get(i).setVisible(false);
    }

    public void setLittleBallsOnBigBall(){
        int numberOfBalls = SettingMenuController.getNumberOfLittleBallsOnBigBall();
        Circle invisibleBall = game.getInvisibleBall();
        int angle = 360 / numberOfBalls;
        for (int i = 0; i < numberOfBalls;i++){
            game.getBigBall().addLittleBallToBigBall(new LittleBall());
            double x = invisibleBall.getCenterX() + cos(i * angle) * invisibleBall.getRadius();
            double y = invisibleBall.getCenterY() + sin(i * angle) * invisibleBall.getRadius();
            game.getBigBall().getLittleBalls().get(i).setCenterX(x);
            game.getBigBall().getLittleBalls().get(i).setCenterY(y);
            pane.getChildren().add(game.getBigBall().getLittleBalls().get(i));
        }
    }


    private void setRotationSetting() {
        for(int i = 0;i < game.getBigBall().getLittleBalls().size();i++){
            LittleBall littleBall = game.getBigBall().getLittleBalls().get(i);
            Line line = new Line();
            line.setStartX(game.getBigBall().getCenterX());
            line.setStartY(game.getBigBall().getCenterY());
            line.setEndX(littleBall.getCenterX());
            line.setEndY(littleBall.getCenterY());
            littleBallsOnBigBall.getChildren().add(littleBall);
            linesGroup.getChildren().add(line);
        }
        pane.getChildren().add(littleBallsOnBigBall);
        pane.getChildren().add(linesGroup);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(30), event -> {
            double angle1 = (littleBallsOnBigBall.getRotate() + 1) % 360;
            double angle2 = (linesGroup.getRotate() + 1) % 360;
            littleBallsOnBigBall.setRotate(angle1);
            linesGroup.setRotate(angle2);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void setShootingSetting(){
        LittleBall littleBall = game.getLittleBallsForPlayer().get(game.getLittleBallsForPlayer().size() - 1);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), event -> {
            littleBall.setCenterY(littleBall.getCenterY() - 1);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                timeline.play();
            }
        });
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
