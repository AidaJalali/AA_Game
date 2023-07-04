package view.menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Time;
import view.game.Game;

public class EndMenu extends Application {
    public static Stage stage;
    private final String css = this.getClass().getResource("/css/style.css").toExternalForm();
    public Label result = new Label();
    private int score;
    private Time time;
    private AnchorPane anchorPane;


    public void setScore(int score) {
        this.score = score;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public void start(Stage stage) throws Exception {
        EndMenu.stage = stage;
        anchorPane = FXMLLoader.load(this.getClass().getResource("/fxml/endMenu.fxml"));
        Scene scene = new Scene(anchorPane);
        result.setLayoutX(350);
        result.setLayoutY(100);
        result.setFont(new Font("modern",70));
        anchorPane.getChildren().add(result);
        result.setVisible(true);
        if (result.getText().equals("YOU WIN"))
            anchorPane.setBackground(Background.fill(Color.LIGHTGREEN));
        if (result.getText().equals("YOU LOSE"))
            anchorPane.setBackground(Background.fill(Color.RED));
        scene.getStylesheets().add(css);
        setScoreLabel();
        setTimeLabel();
        stage.setScene(scene);
        stage.show();
    }

    private void setScoreLabel(){
        Label scoreLabel = new Label();
        scoreLabel.setText("Total score : " + score);
        anchorPane.getChildren().add(scoreLabel);
        scoreLabel.setLayoutX(350);
        scoreLabel.setLayoutY(300);
        scoreLabel.setFont(new Font(50));
    }

    private void setTimeLabel(){
        Label timeLabel = new Label();
        timeLabel.setText("Left time : " + time.getMinute() + ":" + time.getSecond());
        anchorPane.getChildren().add(timeLabel);
        timeLabel.setLayoutX(350);
        timeLabel.setLayoutY(350);
        timeLabel.setFont(new Font(50));
    }

    public void startAgain() throws Exception {
        new Game().start(stage);
    }

    public void goToMainMenu() throws Exception {
        new MainMenu().start(stage);
    }
}
