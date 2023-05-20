package controller;

import view.menu.LoginMenu;
import view.menu.MainMenu;
import view.menu.RegisterMenu;

import static view.menu.EnterMenu.stage;

public class EnterMenuController {

    public void switchToRegisterMenu() throws Exception{
        RegisterMenu registerMenu = new RegisterMenu();
        registerMenu.start(stage);
    }

    public void switchToLoginMenu()throws Exception{
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.start(stage);
    }

    public void switchToMainMenu() throws Exception {
        MainMenu mainMenu = new MainMenu();
        mainMenu.start(stage);
    }
}
