package model;

import controller.SettingMenuController;
import view.game.Game;

public class User {
    private String username;
    private String password;
    private String profileAddress;
    private int score;
    private Game game;
    private SettingMenuController settingMenuController = new SettingMenuController();

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.profileAddress = "/fxml/images/1.png";
        this.score = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileAddress() {
        return profileAddress;
    }

    public void setProfileAddress(String profileAddress) {
        this.profileAddress = profileAddress;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public SettingMenuController getSettingMenuController() {
        return settingMenuController;
    }

    public void setSettingMenuController(SettingMenuController settingMenuController) {
        this.settingMenuController = settingMenuController;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
