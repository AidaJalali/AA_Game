package model;

import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class Game {
    private final BigBall bigBall;
    private final Circle invisibleBall = new Circle(450,350,200);
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
        littleBall.setCenterX(x);
        littleBall.setCenterY(y);
        littleBallsOnBigBall.getChildren().add(littleBall);
        System.out.println("little ball added");
    }

    public void addLineToBigBall(double x , double y){
        Line line = new Line();
        line.setStartX(x);
        line.setStartY(y);
        line.setEndX(bigBall.getCenterX());
        line.setEndY(bigBall.getCenterY());
        linesGroup.getChildren().add(line);
        System.out.println("line added");
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
