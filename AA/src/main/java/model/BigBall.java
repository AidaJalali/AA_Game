package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class BigBall extends Circle {
    private ArrayList<LittleBall>littleBalls = new ArrayList<>();

    public BigBall (){
        super(500,300,50);
        this.setFill(Color.BLACK);
    }

    public void addLittleBallToBigBall(LittleBall littleBall){
        littleBalls.add(littleBall);
    }

    public ArrayList<LittleBall> getLittleBalls() {
        return littleBalls;
    }
}