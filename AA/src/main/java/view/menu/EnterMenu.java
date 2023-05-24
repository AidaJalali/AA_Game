package view.menu;

import controller.MainMenuController;
import controller.RegisterAndLoginAndProfileMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URL;


public class EnterMenu extends Application {
    public static Stage stage;
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = FXMLLoader.load(
                new URL(LoginMenu.class.getResource("/fxml/EnterMenu.fxml").toExternalForm()));
        EnterMenu.stage = stage;
        Scene scene = new Scene(root);
        //ToDO
        //changeStyleScene();
        stage.setScene(scene);
        stage.show();
    }

    public void enterLoginMenu() throws Exception {
        LoginMenu.setRegisterAndLoginAndProfileMenuController(new RegisterAndLoginAndProfileMenuController());
        new LoginMenu().start(stage);
    }

    public void enterRegisterMenu() throws Exception {
        LoginMenu.setRegisterAndLoginAndProfileMenuController(new RegisterAndLoginAndProfileMenuController());
        new RegisterMenu().start(stage);
    }


    public void enterMainMenuAsGuest() throws Exception {
        MainMenu.setMainMenuController(new MainMenuController());
        new MainMenu().start(stage);
    }


}



