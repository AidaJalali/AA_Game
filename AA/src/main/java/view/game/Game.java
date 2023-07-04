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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.BigBall;
import model.LittleBall;
import model.Time;
import model.User;
import view.animation.Shooting;
import view.menu.MainMenu;
import view.menu.SettingMenu;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;


public class Game extends Application {
    public static Stage stage;
    private static GameController gameController = new GameController();
    private static ArrayList<Timeline> timelines = new ArrayList<>();
    private static ArrayList<Timeline> timelines2 = new ArrayList<>();
    private static ArrayList<Timeline> freezeTimeline = new ArrayList<>();
    public final String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private final BigBall bigBall = new BigBall();
    private final Circle invisibleBall = new Circle(500, 300, 200);
    public Scene scene;
    public Pane gamePane;
    public ArrayList<Circle> littleBallsOnBigBall = new ArrayList<>();
    private User user;
    private Game game;
    private ArrayList<LittleBall> littleBallsForPlayer = new ArrayList<>();
    private Timeline timeline;
    private Popup popup;
    private int leftLittleBalls;
    private int leftMapBalls;
    private int changeBorder;
    private int rotateDirection;
    private int radius;
    private boolean visible;
    private int scoreNumber;
    private Time time;

    private Label remaining = new Label();
    private Label score = new Label();
    private Label timer = new Label();

    public Game() {
        user = new User("sahand" , "sahand");
        this.game = this;
        this.leftLittleBalls = user.getSettingMenuController().getNumberOfLittleBallsForPlayer() - user.getSettingMenuController().getNumberOfLittleBallsOnBigBall();
        this.leftMapBalls = user.getSettingMenuController().getNumberOfLittleBallsOnBigBall();
        this.radius = 10;
        this.visible = true;
        this.changeBorder = leftLittleBalls / 4;
        this.rotateDirection = 360;
        //TODO : you will change this minute based on user
        this.time = new Time(2, 0);

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

    public int getLeftLittleBalls() {
        return leftLittleBalls;
    }

    public void setLeftLittleBalls(int leftLittleBalls) {
        this.leftLittleBalls = leftLittleBalls;
    }

    public int getRadius() {
        return radius;
    }


    public int getLeftMapBalls() {
        return leftMapBalls;
    }

    public void setLeftMapBalls(int leftMapBalls) {
        this.leftMapBalls = leftMapBalls;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void start(Stage stage) throws Exception {
        Game.stage = stage;
        gamePane = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/fxml/Game.fxml")));
        scene = new Scene(gamePane);
        scene.getStylesheets().add(css);
        gameController.setGame(this);
        initializeGame();
        stage.setScene(scene);
        stage.show();
    }

    private void initializeGame() {
        setRemaining();
        setTimer();
        setScore();
        setBigBall();
        setPlayerBalls();
        setTimerTimeLine();
        setMap();
        scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.SPACE))
                new Shooting(game).play();

            if (keyEvent.getCode().equals(KeyCode.ALT)) {
                freezeMode();
            }
        });
    }

    private void setRemaining() {
        gamePane.getChildren().add(remaining);
        remaining.setLayoutX(40);
        remaining.setLayoutY(500);
        remaining.setFont(new Font(30));
        changeRemaining();
    }

    private void setTimer() {
        gamePane.getChildren().add(timer);
        timer.setLayoutX(40);
        timer.setLayoutY(450);
        timer.setFont(new Font(30));
        changeTimer();
    }

    private void setScore() {
        gamePane.getChildren().add(score);
        score.setLayoutX(40);
        score.setLayoutY(550);
        score.setFont(new Font(30));
        changeScore();
    }

    private void changeRemaining() {
        if(SettingMenu.persianEffect)
            remaining.setText(leftLittleBalls + "باقی مانده : ");
        else remaining.setText("Remaining : " + leftLittleBalls);
    }

    private void changeTimer() {
        time.changeTime();
        timer.setText(time.getMinute() + " : " + time.getSecond());
    }

    private void changeScore() {
        if(SettingMenu.persianEffect)
            score.setText(" : امتیاز" + scoreNumber);
        else score.setText("Score : " + scoreNumber);
    }

    private void setMap() {
        Timeline setMap = new Timeline();
        setMap.getKeyFrames().setAll(new KeyFrame(Duration.seconds(1), actionEvent -> new Shooting(this).play()));
        setMap.setCycleCount(user.getSettingMenuController().getNumberOfLittleBallsOnBigBall());
        setMap.play();
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
        System.out.println("left little balls :" + leftLittleBalls);

        if (leftLittleBalls >= changeBorder * 3) {
            remaining.setBackground(Background.fill(Color.BLUE));
            setTimeline(littleBall, rotateDirection  , -1 , user.getSettingMenuController().getSpeed() ,false);
            if (leftLittleBalls == changeBorder * 3) {
                goToPhase2();
            }
            return;
        }

        if (leftLittleBalls >= changeBorder * 2) {
            System.out.println("I am going to phase 2");
            setTimeline(littleBall, rotateDirection  , -1 , user.getSettingMenuController().getSpeed() , false);
            if (leftLittleBalls == changeBorder * 2) {
                System.out.println("change phase 2 to phase 3");
                goToPhase3();
            }
            return;
        }

        if (leftLittleBalls >= changeBorder) {
            System.out.println("I am going to phase 3");
            setTimeline(littleBall, rotateDirection , -1 ,user.getSettingMenuController().getSpeed() ,false );
            if (leftLittleBalls == changeBorder) {
                System.out.println("change phase 3 to phase 4");
                goToPhase4();
            }
        }
    }

    public void setTimeline(LittleBall littleBall, int mode , int RotateTime , double speed , boolean isFreezeMode) {
        Timeline timeline;
        Rotate rotation = new Rotate();
        rotation.setPivotX(0);
        rotation.setPivotY(-200);
        littleBall.getTransforms().add(rotation);
        timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(rotation.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(5), new KeyValue(rotation.angleProperty(), mode)),
                new KeyFrame(Duration.ZERO, actionEvent -> {
                    for (int i = 0; i < bigBall.getLittleBalls().size(); i++) {

                        if (bigBall.getLittleBalls().get(i).equals(littleBall)) continue;

                        if (leftLittleBalls == 0) {
                            try {
                                endGame();
                                if(SettingMenu.persianEffect)
                                    gameController.endGame("شما بردید!", stage , time , scoreNumber);
                                else
                                    gameController.endGame("YOU WIN", stage , time , scoreNumber);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if (littleBall.getBoundsInParent().intersects(bigBall.getLittleBalls().get(i).getBoundsInParent())) {

                            try {
                                endGame();
                                gameController.endGame("YOU LOSE" , stage , time , scoreNumber);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }));
        if(leftMapBalls == 0) {
            scoreNumber += 10;
            changeScore();
        }
        changeRemaining();
        timeline.setCycleCount(RotateTime);
        timeline.setRate(speed);
        if(!isFreezeMode)
            timelines.add(timeline);
        else
            freezeTimeline.add(timeline);
        timeline.play();
    }


    private void setTimerTimeLine(){
        Timeline timer = new Timeline();
        timelines2.add(timer);
        timer.getKeyFrames().setAll(new KeyFrame(Duration.seconds(1), actionEvent -> changeTimer()));
        timer.setCycleCount(time.getMinute() * 60 + time.getSecond());
        timer.play();
    }


    private void goToPhase2() {
        Timeline timelineRotation = new Timeline();
        timelines2.add(timelineRotation);
        double random = new Random().nextDouble();
        timelineRotation.getKeyFrames().setAll(new KeyFrame(Duration.seconds(random * 2 + 3), actionEvent -> changeRotateDirection()));
        timelineRotation.setCycleCount(1);
        timelineRotation.play();

        Timeline changeBallsSize = new Timeline();
        timelines2.add(changeBallsSize);
        changeBallsSize.getKeyFrames().setAll(new KeyFrame(Duration.seconds(1), actionEvent -> changeBallsSize()));
        changeBallsSize.setCycleCount(-1);
        changeBallsSize.play();
        remaining.setBackground(Background.fill(Color.RED));
    }

    private void goToPhase3() {
        Timeline changeInvisibility = new Timeline();
        timelines2.add(changeInvisibility);
        changeInvisibility.getKeyFrames().setAll(new KeyFrame(Duration.seconds(1), actionEvent -> changeInvisibility()));
        changeInvisibility.setCycleCount(-1);
        changeInvisibility.play();
        remaining.setBackground(Background.fill(Color.YELLOW));
    }

    private void goToPhase4() {
        remaining.setBackground(Background.fill(Color.GREEN));
    }

    private void changeRotateDirection() {
        System.out.println("change rotation");
        stopTimeLines();
        rotateDirection = -1 * rotateDirection;
        for (int i = 0; i < game.getBigBall().getLittleBalls().size(); i++) {
            setTimeline(game.getBigBall().getLittleBalls().get(i), rotateDirection , -1 ,user.getSettingMenuController().getSpeed() ,false);
        }
    }

    private void changeBallsSize() {
        System.out.println("change balls size");
        if (radius == 15)
            radius = 10;
        else radius = 15;
        for (int i = 0; i < bigBall.getLittleBalls().size(); i++) {
            if (radius == 15)
                bigBall.getLittleBalls().get(i).setFill(Color.DARKRED);
            else
                bigBall.getLittleBalls().get(i).setFill(Color.BLACK);
            bigBall.getLittleBalls().get(i).setRadius(radius);
        }
    }

    private void changeInvisibility() {
        visible = !visible;
        for (int i = 0; i < bigBall.getLittleBalls().size(); i++) {
            bigBall.getLittleBalls().get(i).setVisible(visible);
        }
        bigBall.setVisible(visible);
        invisibleBall.setVisible(visible);
    }

    private void endGame() {
        stopTimeLines();
        for (int i = 0; i < timelines.size(); i++) {
            timelines.remove(timelines.get(i));
        }
        for(int i = 0 ; i <timelines2.size() ; i++){
            timelines2.get(i).stop();
            timelines2.remove(timelines2.get(i));
        }
        if(user.getBestScore() < scoreNumber){
            user.setBestScore(scoreNumber);
        }
        if(user.getBestTime() > time.getMinute() * 60 + time.getSecond())
            user.setBestTime(user.getBestTime() * 60 + time.getSecond());
    }

    private void freezeMode() {
        stopTimeLines();
        for (int i = 0; i < game.getBigBall().getLittleBalls().size(); i++) {
            setTimeline(game.getBigBall().getLittleBalls().get(i), rotateDirection , user.getSettingMenuController().getFreezeTime() , 0.25 ,true);
        }
 //       stopFreezeTimeLines();
//        for (int i = 0; i < game.getBigBall().getLittleBalls().size(); i++) {
//            setTimeline(game.getBigBall().getLittleBalls().get(i), rotateDirection ,  -1, 0.25 ,false);
//        }
    }

    private void stopTimeLines() {
        for (Timeline value : timelines) {
            value.stop();
        }
    }

    private void stopFreezeTimeLines(){
        for (Timeline value : freezeTimeline) {
            value.stop();
        }
    }


    public void miniMenu() {

        popup = new Popup();
        Pane pane = new Pane();
        VBox vBox = new VBox();

        Button pause = null;
        Button resume = null;
        Button restart = null;
        Button mute = null;
        Button music = null;
        Button help= null;
        Button back = null;
        Button exit = null;

        if(SettingMenu.persianEffect){
            pause = new Button("توقف");
            resume = new Button("ادامه");
            restart = new Button("شروع دوباره");
            mute = new Button("سکوت");
            music = new Button("موسیقی");
            help = new Button("کمک");
            back = new Button("بازگشت");
            exit = new Button("خروج");
        }


        if(!SettingMenu.persianEffect) {
            pause = new Button("Pause");
            resume = new Button("Resume");
            restart = new Button("Restart");
            mute = new Button("Mute");
            music = new Button("Music");
            help = new Button("Help");
            back = new Button("Back");
            exit = new Button("Exit");
        }

        resume.setOnAction(actionEvent -> resume());
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
        exit.setOnAction(ae -> {
            try {
                exit();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        pane.setMinWidth(200);
        pane.setMinHeight(400);
        pane.setBackground(Background.fill(Color.LIGHTGREY));
        pane.setBorder(Border.stroke(Color.BLACK));
        pane.setLayoutY(100);

        vBox.setMinWidth(600);
        vBox.setAlignment(Pos.BOTTOM_CENTER);
        vBox.setSpacing(20);
        vBox.setLayoutY(70);

        vBox.getChildren().addAll(resume, pause, music, restart, mute, help, back,exit);
        pane.getChildren().add(vBox);
        popup.getContent().add(pane);
        popup.show(stage);
    }

    private void help() {
        Popup help = new Popup();
        VBox vBox = new VBox();
        vBox.setMinSize(500,500);

        TextField enter = new TextField("press enter for shooting");
        TextField freezeMode = new TextField("press Alt for freezing mode");
        TextField info = new TextField("Your score will be calculated by your time and score");
        vBox.getChildren().addAll(enter, freezeMode, info);
        vBox.setSpacing(10);
        help.getContent().add(vBox);
        help.show(stage);
    }

    private void music() {
        Popup music = new Popup();
        VBox vBox = new VBox();
        vBox.setMinSize(500,500);

        Button button1 = new Button("music 1");
        Button button2 = new Button("music 2");
        Button button3 = new Button("music 3");
        vBox.getChildren().addAll(button1, button2, button3);
        vBox.setSpacing(10);
        music.getContent().add(vBox);
        music.show(stage);
    }

    private void mute() {
    }

    private void restart() throws Exception {
        popup.hide();
        endGame();
        new Game().start(stage);
    }

    private void pause() {
        for (Timeline value : timelines) {
            value.stop();
        }
        for (Timeline value : timelines2){
            value.stop();
        }
        popup.hide();
    }

    private void resume() {
        System.out.println("resume");
        for (int i = 0; i < game.getBigBall().getLittleBalls().size(); i++) {
            setTimeline(game.getBigBall().getLittleBalls().get(i), rotateDirection , -1 , user.getSettingMenuController().getSpeed() ,false);
        }
        for (Timeline value : timelines2) {
            value.play();
        }
        popup.hide();
    }

    private void exit() throws Exception {
        new MainMenu().start(stage);
    }


}
