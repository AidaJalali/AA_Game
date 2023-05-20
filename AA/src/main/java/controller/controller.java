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
    GameController gameController = new GameController();
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
    public void startGame() throws Exception{
        mainMenuController.startGame();
    }

    public void resumeGame() throws Exception{
        mainMenuController.resumeGame();
    }

    public void switchToProfileMenu() throws Exception{
        mainMenuController.switchToProfileMenu();
    }

    public void switchToSettingMenu() throws Exception{
        mainMenuController.switchToSettingMenu();
    }

    public void switchToScoreTable() throws Exception{
        mainMenuController.switchToScoreTable();
    }

    //Register and Login Menu
    public void register(ActionEvent event){
        registerAndLoginMenuController.register(event);
    }

    public void login(ActionEvent event){
        registerAndLoginMenuController.login(event);
    }
    public void reset(ActionEvent event){
        registerAndLoginMenuController.reset(event);
    }

    }

