package view.menu;

import javafx.application.Application;
import javafx.css.Size;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import view.game.Game;

public class EndMenu extends Application {
    public static Stage stage;
    private final String css = this.getClass().getResource("/css/style.css").toExternalForm();
    public Label result = new Label();

    @Override
    public void start(Stage stage) throws Exception {
        EndMenu.stage = stage;
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/fxml/endMenu.fxml"));
        Scene scene = new Scene(anchorPane);
        result.setLayoutX(280);
        result.setLayoutY(100);
        result.setFont(new Font("modern",50));
        anchorPane.getChildren().add(result);
        result.setVisible(true);
        if (result.getText().equals("YOU WIN"))
            anchorPane.setBackground(Background.fill(Color.LIGHTGREEN));
        if (result.getText().equals("YOU LOSE"))
            anchorPane.setBackground(Background.fill(Color.RED));
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    public void startAgain() throws Exception {
        new Game().start(stage);
    }

    public void goToMainMenu() throws Exception {
        new MainMenu().start(stage);
    }
}
