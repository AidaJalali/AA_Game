package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class LittleBall extends Circle {
    public LittleBall (double x , double y) {
        super(10, Color.BLACK);
        this.setTranslateX(x);
        this.setTranslateY(y);
    }
}
