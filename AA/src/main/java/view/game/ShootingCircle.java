package view.game;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ShootingCircle extends Application {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private Circle circle;
    private Timeline timeline;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();

        // Create a circle at the bottom of the screen
        circle = new Circle(WIDTH / 2, HEIGHT - 20, 10, Color.RED);

        // Add the circle to the scene
        root.getChildren().add(circle);

        // Create a timeline that moves the circle upward
        timeline = new Timeline(new KeyFrame(Duration.millis(10), event -> {
            circle.setCenterY(circle.getCenterY() - 1);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);

        // Create a scene and add it to the stage
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                timeline.play();
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
