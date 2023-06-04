package view.menu;

import controller.MainMenuController;
import controller.RegisterAndLoginAndProfileMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.net.URL;


public class PrimaryMenu extends Application {
    public static Stage stage;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = FXMLLoader.load(
                new URL(LoginMenu.class.getResource("/fxml/EnterMenu.fxml").toExternalForm()));
        PrimaryMenu.stage = stage;
        root.setBackground(new Background(new BackgroundImage(new Image(ProfileMenu.class.getResource("/images/darkSun.jpg").toExternalForm()),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1, 1, true, true, false, false))));
        Media media = new Media(getClass().getResource("/media/main.mp3").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(this.getClass().getResource("/css/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void enterLoginMenu() throws Exception {
        LoginMenu.setRegisterAndLoginAndProfileMenuController(new RegisterAndLoginAndProfileMenuController());
        new LoginMenu().start(stage);
    }

    public void enterRegisterMenu() throws Exception {
        RegisterMenu.setRegisterAndLoginAndProfileMenuController(new RegisterAndLoginAndProfileMenuController());
        new RegisterMenu().start(stage);
    }


    public void enterMainMenuAsGuest() throws Exception {
        MainMenu.setMainMenuController(new MainMenuController());
        new MainMenu().start(stage);
    }

    public void exit() {
        System.exit(0);
    }

}



