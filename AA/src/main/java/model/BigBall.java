package model;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.ArrayList;

public class BigBall extends Circle {
    private ArrayList<LittleBall>littleBalls = new ArrayList<>();

    public BigBall (){
        super(450,350,100);
        this.setFill(Color.BLACK);
    }

    public void addLittleBallToBigBall(LittleBall littleBall){
        littleBalls.add(littleBall);
    }

    public ArrayList<LittleBall> getLittleBalls() {
        return littleBalls;
    }
}