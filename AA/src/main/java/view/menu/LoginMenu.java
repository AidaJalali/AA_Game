package view.menu;

import controller.RegisterAndLoginMenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginMenu {
    private String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private static RegisterAndLoginMenuController registerAndLoginMenuController;
    public void start(Stage stage) throws Exception {
        EnterMenu.stage = stage;
        Parent parent = FXMLLoader.load(EnterMenu.class.getResource("/fxml/LoginMenu.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }
    public void login(ActionEvent event){

    }

}
