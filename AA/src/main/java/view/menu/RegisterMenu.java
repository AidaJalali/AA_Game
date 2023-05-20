package view.menu;

import controller.RegisterAndLoginMenuController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegisterMenu extends Application {
    public String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private static RegisterAndLoginMenuController registerAndLoginMenuController;
    private static Stage stage;
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Parent parent = FXMLLoader.load(EnterMenu.class.getResource("/fxml/RegisterMenu.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    public void register(ActionEvent event){

    }

    public void login(ActionEvent event){

    }
}
