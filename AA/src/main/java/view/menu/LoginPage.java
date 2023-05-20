package view.menu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginPage {
    public String css = this.getClass().getResource("/css/style.css").toExternalForm();
    public void start(Stage stage) throws Exception {
        RegisterMenu.stage = stage;
        Parent parent = FXMLLoader.load(RegisterMenu.class.getResource("/fxml/LoginPage.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

}
