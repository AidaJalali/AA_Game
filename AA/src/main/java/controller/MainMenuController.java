package controller;

import view.menu.GameMenu;
import view.menu.ProfileMenu;
import view.menu.ScoreMenu;
import view.menu.SettingMenu;

import static view.menu.EnterMenu.stage;

public class MainMenuController {
    public void startGame() throws Exception{
        GameMenu gameMenu = new GameMenu();
        gameMenu.start(stage);
    }

    public void resumeGame() throws Exception{

    }

    public void switchToProfileMenu() throws Exception{
        ProfileMenu profileMenu = new ProfileMenu();
        profileMenu.start(stage);
    }

    public void switchToSettingMenu() throws Exception{
        SettingMenu settingMenu = new SettingMenu();
        settingMenu.start(stage);
    }

    public void switchToScoreTable() throws Exception{
        ScoreMenu scoreMenu = new ScoreMenu();
        scoreMenu.start(stage);
    }
}
