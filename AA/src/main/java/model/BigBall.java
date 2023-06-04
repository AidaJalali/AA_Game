package model;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.Stack;

public class BigBall extends Circle {
    private ArrayList<LittleBall>littleBalls = new ArrayList<>();

    public BigBall (){
        super(400,300,50);
        this.setFill(Color.BLACK);
    }

    public void addLittleBallToBigBall(LittleBall littleBall){
        littleBalls.add(littleBall);
    }

    public ArrayList<LittleBall> getLittleBalls() {
        return littleBalls;
    }
}