package view.game;

import javafx.animation.Animation;
        import javafx.animation.KeyFrame;
        import javafx.animation.Timeline;
        import javafx.application.Application;
        import javafx.geometry.Point2D;
        import javafx.scene.Group;
        import javafx.scene.Scene;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.Circle;
        import javafx.scene.shape.Line;
        import javafx.stage.Stage;
        import javafx.util.Duration;

        import java.util.ArrayList;
        import java.util.List;

public class test extends Application {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private List<Circle> circles = new ArrayList<>();
    private Circle currentCircle;
    private Line line;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the circles
        for (int i = 0; i < 5; i++) {
            Circle circle = new Circle(Math.random() * WIDTH, Math.random() * HEIGHT, 20, Color.BLUE);
            circle.setOnMouseClicked(this::handleCircleClick);
            circles.add(circle);
        }

        // Create the line
        line = new Line();
        line.setStroke(Color.BLACK);

        // Create a group and add the circles and line to it
        Group root = new Group();
        root.getChildren().addAll(circles);
        root.getChildren().add(line);

        // Create a scene with the group as the root node
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();

        // Start the game loop
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.01), event -> update()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void handleCircleClick(MouseEvent event) {
        if (currentCircle == null) {
            currentCircle = (Circle) event.getSource();
        } else {
            Circle nextCircle = (Circle) event.getSource();
            line.setStartX(currentCircle.getCenterX());
            line.setStartY(currentCircle.getCenterY());
            line.setEndX(nextCircle.getCenterX());
            line.setEndY(nextCircle.getCenterY());
            currentCircle = nextCircle;
        }
    }

    private void update() {
        for (Circle circle : circles) {
            Point2D velocity = new Point2D(Math.random() * 2 - 1, Math.random() * 2 - 1);
            circle.setCenterX(circle.getCenterX() + velocity.getX());
            circle.setCenterY(circle.getCenterY() + velocity.getY());

            // Check for collisions with other circles
            for (Circle otherCircle : circles) {
                if (circle != otherCircle && circle.getBoundsInParent().intersects(otherCircle.getBoundsInParent())) {
//                    // Move the circle away from the other circle
//                    Point2D normal = circle.getCenter().subtract(otherCircle.getCenter()).normalize();
//                    circle.setCenterX(circle.getCenterX() + normal.getX() * 5);
//                    circle.setCenterY(circle.getCenterY() + normal.getY() * 5);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}