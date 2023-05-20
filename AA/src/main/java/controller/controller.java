package controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import view.menu.*;


public class controller {

    Stage stage = RegisterMenu.stage;

    public void switchToRegisterPage() throws Exception{
        RegisterPage registerPage = new RegisterPage();
        registerPage.start(stage);
    }

    public void switchToLoginPage()throws Exception{
        LoginPage loginPage = new LoginPage();
        loginPage.start(stage);
    }

    public void switchToMainMenu() throws Exception {
        MainMenu mainMenu = new MainMenu();
        mainMenu.start(stage);
    }

    public void backToRegisterMenu() throws Exception {
        RegisterMenu registerMenu = new RegisterMenu();
        registerMenu.start(stage);
    }

    public void switchToGameMenu() throws Exception{
        GameMenu gameMenu = new GameMenu();
        gameMenu.start(stage);
    }

    public void switchToProfileMenu() throws Exception{
        ProfileMenu profileMenu = new ProfileMenu();
        profileMenu.start(stage);
    }

    public void switchToSettingMenu() throws Exception{
        SettingMenu settingMenu = new SettingMenu();
        settingMenu.start(stage);
    }

    public void switchToScoreMenu() throws Exception{
        ScoreMenu scoreMenu = new ScoreMenu();
        scoreMenu.start(stage);
    }

    public void register(ActionEvent event){

    }

    public void login(ActionEvent event){

    }

    }

