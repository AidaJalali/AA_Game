package model;

import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Game {
    private final BigBall bigBall;
    private final Circle invisibleBall = new Circle(400,300,200);
    private ArrayList<StackPane>littleBallsForPlayer = new ArrayList<>();
    private Group littleBallsOnBigBall = new Group();
    private Group linesGroup = new Group();
    private int numberOfBallsForPlayer;

    public Game(BigBall bigBall , int numberOfBallsForPlayer) {
        this.bigBall = bigBall;
        invisibleBall.setVisible(false);
        this.numberOfBallsForPlayer = numberOfBallsForPlayer;
    }

    public void addLittleBallToBigBall(double x , double y){
        LittleBall littleBall = new LittleBall();
        littleBall.setFill(Color.RED);
        littleBall.setCenterX(x);
        littleBall.setCenterY(y);
        littleBallsOnBigBall.getChildren().add(littleBall);
    }

    public void addLineToBigBall(double x , double y){
        Line line = new Line();
        line.setStartX(x);
        line.setStartY(y);
        line.setEndX(bigBall.getCenterX());
        line.setEndY(bigBall.getCenterY());
        linesGroup.getChildren().add(line);
    }

    public BigBall getBigBall() {
        return bigBall;
    }

    public void addLittleBallsForPlayer(StackPane stackPane){
        littleBallsForPlayer.add(stackPane);
    }

    public Circle getInvisibleBall() {
        return invisibleBall;
    }

    public ArrayList<StackPane> getLittleBallsForPlayer() {
        return littleBallsForPlayer;
    }

    public Group getLittleBallsOnBigBall() {
        return littleBallsOnBigBall;
    }

    public Group getLinesGroup() {
        return linesGroup;
    }

    public int getNumberOfBallsForPlayer() {
        return numberOfBallsForPlayer;
    }
}
