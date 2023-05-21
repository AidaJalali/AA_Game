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

//        RotateTransition rotateTransition = new RotateTransition();
//        rotateTransition.setNode(circle);
//        rotateTransition.setDuration(Duration.seconds(2));
//        rotateTransition.setByAngle(360);
//        rotateTransition.setCycleCount(Animation.INDEFINITE);
//        rotateTransition.setAutoReverse(false);
//        rotateTransition.play();
//        Group root = new Group();
//        root.getChildren().add(circle);
    }

    public void addLittleBallToBigBall(LittleBall littleBall){
        littleBalls.add(littleBall);
    }

    public ArrayList<LittleBall> getLittleBalls() {
        return littleBalls;
    }
}