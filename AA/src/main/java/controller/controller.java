package controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import view.menu.*;


public class controller {

    EnterMenuController enterMenuController = new EnterMenuController();
    RegisterAndLoginMenuController registerAndLoginMenuController = new RegisterAndLoginMenuController();
    ProfileMenuController profileMenuController = new ProfileMenuController();
    MainMenuController mainMenuController = new MainMenuController();
    ScoreMenuController scoreMenuController = new ScoreMenuController();
    SettingMenuController settingMenuController = new SettingMenuController();
    Stage stage = EnterMenu.stage;

    //                                  <<<<<< MENU FUNCTIONS >>>>>>

    //functions that are common between menus
    public void backToRegisterMenu() throws Exception {
        EnterMenu enterMenu = new EnterMenu();
        enterMenu.start(stage);
    }

    //functions related to every Menu

    //Enter menu
    public void switchToRegisterMenu() throws Exception{
        enterMenuController.switchToRegisterMenu();
    }
    public void switchToLoginMenu()throws Exception{
        enterMenuController.switchToLoginMenu();
    }
    public void switchToMainMenu() throws Exception {
        enterMenuController.switchToMainMenu();
    }

    //Main menu
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

    //Register and Login Menu
    public void register(ActionEvent event){
        registerAndLoginMenuController.register(event);
    }

    public void login(ActionEvent event){

    }

    }

