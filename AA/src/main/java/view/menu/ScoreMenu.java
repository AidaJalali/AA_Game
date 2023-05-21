package view.menu;

import controller.ScoreMenuController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScoreMenu extends Application {
    public static Stage stage;
    public String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private static ScoreMenuController scoreMenuController;
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(EnterMenu.class.getResource("/fxml/ScoreMenu.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        ScoreMenu.stage = stage;
    }

    public static ScoreMenuController getScoreMenuController() {
        return scoreMenuController;
    }

    public static void setScoreMenuController(ScoreMenuController scoreMenuController) {
        ScoreMenu.scoreMenuController = scoreMenuController;
    }
}
