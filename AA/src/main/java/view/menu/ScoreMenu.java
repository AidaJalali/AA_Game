package view.menu;

import controller.ScoreMenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScoreMenu {
    public String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private static ScoreMenuController scoreMenuController;
    public void start(Stage stage) throws Exception {
        EnterMenu.stage = stage;
        Parent parent = FXMLLoader.load(EnterMenu.class.getResource("/fxml/ScoreMenu.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }
}
