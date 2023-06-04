package view.animation;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.LittleBall;
import view.game.Game;

public class Shooting extends Transition {
    private Game game;
    private Pane gamePane;
    private Pane ballsPane;
    private LittleBall littleBall;

    public Shooting(Game game) {
        this.game = game;
        this.gamePane = game.gamePane;
        this.littleBall = game.getLittleBallsForPlayer().get(0);
        this.setCycleDuration(Duration.millis(100000));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {
        double y = littleBall.getTranslateY() - 30;
        littleBall.setTranslateY(y);
        game.getLittleBallsForPlayer().remove(littleBall);
        game.setRotationSetting(littleBall);
        game.getBigBall().addLittleBallToBigBall(littleBall);
        this.stop();
    }
}


