package view.game;



        import javafx.animation.Animation;
        import javafx.animation.KeyFrame;
        import javafx.animation.Timeline;
        import javafx.application.Application;
        import javafx.scene.Group;
        import javafx.scene.Scene;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.Circle;
        import javafx.scene.transform.Rotate;
        import javafx.stage.Stage;
        import javafx.util.Duration;

public class InvisibleCircle extends Application {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private Circle circle;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the circle
        circle = new Circle(WIDTH / 2, HEIGHT / 2, 50, Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(2);

        // Create a group and add the circle to it
        Group root = new Group();
        root.getChildren().add(circle);

        // Create a scene with the group as the root node
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();

        // Start the rotation animation
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.01), event -> rotate()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void rotate() {
        circle.getTransforms().add(new Rotate(1, WIDTH / 2, HEIGHT / 2));
    }

    public static void main(String[] args) {
        launch(args);
    }
}

