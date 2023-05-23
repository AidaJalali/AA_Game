package view.game;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GroupedCirclesRotation extends Application {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private static final int CENTER_X = 200;
    private static final int CENTER_Y = 200;
    private static final int RADIUS = 100;

    private Group circlesGroup;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();

        // Create multiple circles
        Circle circle1 = new Circle(CENTER_X, CENTER_Y - RADIUS, 10, Color.RED);
        Circle circle2 = new Circle(CENTER_X + RADIUS * Math.cos(Math.toRadians(120)), CENTER_Y + RADIUS * Math.sin(Math.toRadians(120)), 10, Color.GREEN);
        Circle circle3 = new Circle(CENTER_X + RADIUS * Math.cos(Math.toRadians(240)), CENTER_Y + RADIUS * Math.sin(Math.toRadians(240)), 10, Color.BLUE);

        // Create a group and add the circles to it
        circlesGroup = new Group(circle1, circle2, circle3);

        // Add the group to the scene
        root.getChildren().add(circlesGroup);

        // Create a timeline that rotates the group around the center
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), event -> {
            double angle = (circlesGroup.getRotate() + 1) % 360;
            circlesGroup.setRotate(angle);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        // Create a scene and add it to the stage
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



