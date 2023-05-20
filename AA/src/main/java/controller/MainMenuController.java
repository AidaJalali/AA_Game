package controller;

import model.User;
import view.game.Game;
import view.menu.ProfileMenu;
import view.menu.ScoreMenu;
import view.menu.SettingMenu;

import static view.menu.EnterMenu.stage;

public class MainMenuController {
    private User currentUser;
    public void startGame() throws Exception{
        Game game = new Game();
        game.start(stage);
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

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
