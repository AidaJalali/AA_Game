package view.menu;

import controller.RegisterAndLoginAndProfileMenuController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AvatarMenu extends Application {
    public static Stage stage;
    private static RegisterAndLoginAndProfileMenuController profileMenuController;
    public String css = this.getClass().getResource("/css/style.css").toExternalForm();
    @FXML
    private ChoiceBox choiceBox;

    public static void setProfileMenuController(RegisterAndLoginAndProfileMenuController profileMenuController) {
        AvatarMenu.profileMenuController = profileMenuController;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = FXMLLoader.load(this.getClass().getResource("/fxml/AvatarMenu.fxml"));
        Scene scene = new Scene(pane);
        scene.getStylesheets().add(css);
        handleMenuItem();
        stage.setScene(scene);
        stage.show();
        AvatarMenu.stage = stage;
    }

    private void handleMenuItem(){
        if (choiceBox.getValue().equals("avatar1"))
            MainMenu.getMainMenuController().getCurrentUser().setProfileAddress("/fxml/images/1.png");
        if (choiceBox.getValue().equals("avatar2"))
            MainMenu.getMainMenuController().getCurrentUser().setProfileAddress("/fxml/images/3.png");
        if (choiceBox.getValue().equals("avatar3"))
            MainMenu.getMainMenuController().getCurrentUser().setProfileAddress("/fxml/images/4.png");
        if (choiceBox.getValue().equals("avatar4"))
            MainMenu.getMainMenuController().getCurrentUser().setProfileAddress("/fxml/images/5.png");
        if (choiceBox.getValue().equals("avatar5"))
            MainMenu.getMainMenuController().getCurrentUser().setProfileAddress("/fxml/images/2.png");
        if (choiceBox.getValue().equals("avatar6"))
            MainMenu.getMainMenuController().getCurrentUser().setProfileAddress("/fxml/images/10.png");
    }
}
