package model;

import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Game {
    private final BigBall bigBall;
    private final Circle invisibleBall = new Circle(450,350,200);
    private ArrayList<LittleBall>littleBallsForPlayer = new ArrayList<>();

    public Game(BigBall bigBall) {
        this.bigBall = bigBall;
        invisibleBall.setVisible(false);
    }

    public BigBall getBigBall() {
        return bigBall;
    }

    public void addLittleBallsForPlayer(LittleBall littleBall){
        littleBallsForPlayer.add(littleBall);
    }

    public Circle getInvisibleBall() {
        return invisibleBall;
    }

    public ArrayList<LittleBall> getLittleBallsForPlayer() {
        return littleBallsForPlayer;
    }
}
