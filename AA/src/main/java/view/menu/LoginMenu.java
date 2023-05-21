package view.menu;

import controller.RegisterAndLoginAndProfileMenuController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginMenu extends Application {
    private String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private static RegisterAndLoginAndProfileMenuController registerAndLoginAndProfileMenuController;
    private static Stage stage;
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Parent parent = FXMLLoader.load(EnterMenu.class.getResource("/fxml/LoginMenu.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }
    public void login(ActionEvent event){

    }

}
