package view.menu;

import controller.MainMenuController;
import controller.RegisterAndLoginAndProfileMenuController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.shape.*;
import javafx.stage.Stage;


public class EnterMenu extends Application {
    public static Stage stage;
    private StackPane root = new StackPane();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        setRoot();
        setAction();
        EnterMenu.stage = stage;
        stage.setScene(new Scene(root , 900 , 700));
        stage.show();
    }

    private void setRoot(){
        Button register = new Button("Register");
        Button login = new Button("Login");
        Button guest = new Button("Guest");
        Sphere sphere = new Sphere();
        sphere.setDrawMode(DrawMode.LINE);
        sphere.setRadius(300);
        sphere.setLayoutX(400);
        sphere.setLayoutX(450);
        register.setMaxSize(100 , 50);
        login.setMaxSize(100,50);
        guest.setMaxSize(100,50);
        register.setTranslateX(5);
        register.setTranslateY(-130);
        login.setTranslateX(5);
        login.setTranslateY(0);
        guest.setTranslateX(5);
        guest.setTranslateY(130);
        register.setOnAction();
        root.setBackground(Background.fill(Color.LAVENDER));
        root.getChildren().addAll(sphere , register , login , guest);
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



