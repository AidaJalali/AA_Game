package model;

import controller.SettingMenuController;
import enums.ImageEnum;

public class User {
    private String username;
    private String password;
    private String image;
    private int bestScore;
    private int bestTime;
    private SettingMenuController settingMenuController = new SettingMenuController();

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.image = ImageEnum.PERSON.getImage();
        this.bestScore = 0;
        this.bestTime = 0;
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

    public SettingMenuController getSettingMenuController() {
        return settingMenuController;
    }

    public void setSettingMenuController(SettingMenuController settingMenuController) {
        this.settingMenuController = settingMenuController;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public int getBestTime() {
        return bestTime;
    }

    public void setBestTime(int bestTime) {
        this.bestTime = bestTime;
    }
}
