package view.animation;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import model.Game;
import model.LittleBall;

public class ShootingAnimation extends Transition {

    private Game game;
    private Pane pane;
    private StackPane littleBall;


    public ShootingAnimation(Pane pane , Game game) {
        this.pane = pane;
        this.game = game;
        this.littleBall = game.getLittleBallsForPlayer().get(0);
        this.setCycleDuration(Duration.millis(1000));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {
        double y = littleBall.getLayoutY() - 20;
        littleBall.setLayoutY(y);
        if(shootingBallHitLittleBall(littleBall)){
        }
        if(littleBall.getLayoutY() == (game.getInvisibleBall().getCenterY() + game.getInvisibleBall().getRadius())) {
            littleBall.setVisible(false);
            this.stop();
            game.addLittleBallToBigBall(littleBall.getLayoutX() , littleBall.getLayoutY());
            game.addLineToBigBall(littleBall.getLayoutX() , littleBall.getLayoutY() );
            game.getLittleBallsForPlayer().remove(littleBall);
        }
    }

    private boolean shootingBallHitLittleBall(StackPane stackPane) {
      return false;
    }

}
