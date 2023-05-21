package view.menu;

import controller.RegisterAndLoginAndProfileMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProfileMenu extends Application {
    public static Stage stage;
    public String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private static RegisterAndLoginAndProfileMenuController profileMenuController;
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(EnterMenu.class.getResource("/fxml/ProfileMenu.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        ProfileMenu.stage = stage;
    }

    public static RegisterAndLoginAndProfileMenuController getProfileMenuController() {
        return profileMenuController;
    }

    public static void setProfileMenuController(RegisterAndLoginAndProfileMenuController profileMenuController) {
        ProfileMenu.profileMenuController = profileMenuController;
    }
}
