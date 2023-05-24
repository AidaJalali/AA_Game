package view.game;


import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ShootingCircles extends Application {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private Circle shooterCircle;
    private Circle targetCircle;
    private TranslateTransition transition;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();

        // Create a shooter circle at the bottom of the screen
        shooterCircle = new Circle(WIDTH / 2, HEIGHT - 20, 10, Color.RED);

        // Create a target circle at the top of the screen
        targetCircle = new Circle(WIDTH / 2, 20, 10, Color.BLUE);

        // Add the circles to the scene
        root.getChildren().addAll(shooterCircle, targetCircle);

        // Create a transition that moves the shooter circle upward
        transition = new TranslateTransition(Duration.seconds(1), shooterCircle);
        transition.setToY(targetCircle.getCenterY() - shooterCircle.getRadius());
        transition.setOnFinished(event -> {
            if (shooterCircle.getBoundsInParent().intersects(targetCircle.getBoundsInParent())) {
                transition.stop();
            }
        });

        // Create a scene and add it to the stage
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                transition.play();
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}