package view.animation;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.LittleBall;

public class ShootingAnimation extends Transition {

    private Pane pane;
    private LittleBall littleBall;


    public ShootingAnimation(Pane pane, LittleBall littleBall) {
        this.pane = pane;
        this.littleBall = littleBall;
        this.setCycleDuration(Duration.millis(1000));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {
        double y = littleBall.getCenterY() - 10;
        littleBall.setLayoutY(y);
    }
}
