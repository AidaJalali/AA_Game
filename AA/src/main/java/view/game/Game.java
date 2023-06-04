package view.game;

import controller.GameController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.BigBall;
import model.LittleBall;
import model.User;
import view.animation.Shooting;

import java.util.ArrayList;


public class Game extends Application {
    public static Stage stage;
    private static GameController gameController = new GameController();
    public final String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private final BigBall bigBall = new BigBall();
    private final Circle invisibleBall = new Circle(400, 300, 200);
    public ArrayList<Circle> littleBallsOnBigBall = new ArrayList<>();
    public Pane gamePane;
    public Scene scene;
    public Timeline timeline;
    private Popup popup;
    private ArrayList<LittleBall> littleBallsForPlayer = new ArrayList<>();
    private User user;
    private ArrayList<Timeline> timelines = new ArrayList<>();


    public Game() {
        //this.user = gameController.getCurrentUser();
        this.user = new User("aida", "122334");
    }


    public BigBall getBigBall() {
        return bigBall;
    }

    public Circle getInvisibleBall() {
        return invisibleBall;
    }

    public GameController getGameController() {
        return gameController;
    }

    public static void setGameController(GameController gameController) {
        Game.gameController = gameController;
    }

    public ArrayList<LittleBall> getLittleBallsForPlayer() {
        return littleBallsForPlayer;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public void start(Stage stage) throws Exception {
        Game.stage = stage;
        gamePane = FXMLLoader.load(this.getClass().getResource("/fxml/Game.fxml"));
        scene = new Scene(gamePane);
        scene.getStylesheets().add(css);
        gameController.setGame(this);
        initializeGame();
        stage.setScene(scene);
        stage.show();
    }

    private void initializeGame() {
        setBigBall();
        setPlayerBalls();
        scene.setOnKeyPressed(keyEvent -> {
            new Shooting(this).play();
        });
    }

    private void setBigBall() {
        invisibleBall.setFill(Color.LIGHTGREY);
        gamePane.getChildren().add(invisibleBall);
        gamePane.getChildren().add(bigBall);
    }


    private void setPlayerBalls() {
        for (int i = 0; i < user.getSettingMenuController().getNumberOfLittleBallsForPlayer(); i++) {
            double x = bigBall.getCenterX();
            double y = bigBall.getCenterY() + bigBall.getRadius() + 175;
            LittleBall littleBall = new LittleBall(x, y);
            littleBallsForPlayer.add(littleBall);
            gamePane.getChildren().add(littleBall);
        }
    }


    public void setRotationSetting(LittleBall littleBall) {
        Rotate rotation = new Rotate();
        rotation.setPivotX(0);
        rotation.setPivotY(-200);
        littleBall.getTransforms().add(rotation);
        timeline = new Timeline(new KeyFrame(Duration.ZERO,
                new KeyValue(rotation.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(5), new KeyValue(rotation.angleProperty(), 360)),
                new KeyFrame(Duration.ZERO, actionEvent -> {
            if (littleBallsForPlayer.size() == 0) {
                try {
                    endGame();
                    gameController.endGame("YOU WIN", stage);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            for (int i = 0; i < bigBall.getLittleBalls().size(); i++) {

                if (bigBall.getLittleBalls().get(i).equals(littleBall)) continue;

                if (littleBall.getBoundsInParent().intersects(bigBall.getLittleBalls().get(i).getBoundsInParent())) {

                    try {
                        endGame();
                        gameController.endGame("YOU LOSE", stage);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }));
        timelines.add(timeline);
        timeline.setCycleCount(-1);
        timeline.play();
    }


    private void endGame() {
        for (int i = 0; i < timelines.size(); i++) {
            timelines.get(i).stop();
            timelines.remove(timelines.get(i));
        }
    }

    public void miniMenu() throws Exception {

        popup = new Popup();
        Pane pane = new Pane();
        VBox vBox = new VBox();

        Button pause = new Button("Pause");
        Button restart = new Button("Restart");
        Button mute = new Button("Mute");
        Button music = new Button("Music");
        Button help = new Button("Help");
        Button back = new Button("Back");

        pause.setOnAction(ae -> pause());
        restart.setOnAction(ae -> {
            try {
                restart();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        mute.setOnAction(ae -> mute());
        music.setOnAction(ae -> music());
        help.setOnAction(ae -> help());
        back.setOnAction(ae -> popup.hide());

        pane.setMinWidth(200);
        pane.setMinHeight(400);
        pane.setBackground(Background.fill(Color.LIGHTGREY));
        pane.setBorder(Border.stroke(Color.BLACK));
        pane.setLayoutY(100);

        vBox.setMinWidth(600);
        vBox.setAlignment(Pos.BOTTOM_CENTER);
        vBox.setSpacing(20);
        vBox.setLayoutY(80);

        vBox.getChildren().addAll(pause, music, restart, mute, help, back);
        pane.getChildren().add(vBox);
        popup.getContent().add(pane);
        popup.show(stage);
    }

    private void help() {
    }

    private void music() {
    }

    private void mute() {
    }

    private void restart() throws Exception {
        popup.hide();
        endGame();
        new Game().start(stage);
    }

    private void pause() {

    }


}
