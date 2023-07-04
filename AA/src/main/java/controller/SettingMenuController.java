package controller;

import enums.GameLevel;
import model.User;

public class SettingMenuController {
    private User currentUser;
    private  double speed = GameLevel.MEDIUM.getSpeed();
    private int freezeTime = GameLevel.MEDIUM.getFreezeTime();
    private int numberOfLittleBallsForPlayer = 20;
    private int numberOfLittleBallsOnBigBall = 5;


    public  double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getFreezeTime() {
        return freezeTime;
    }

    public void setFreezeTime(int freezeTime) {
        this.freezeTime = freezeTime;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public int getNumberOfLittleBallsForPlayer() {
        return numberOfLittleBallsForPlayer;
    }

    public void setNumberOfLittleBallsForPlayer(int numberOfLittleBallsForPlayer) {
        this.numberOfLittleBallsForPlayer = numberOfLittleBallsForPlayer;
    }

    public int getNumberOfLittleBallsOnBigBall() {
        return numberOfLittleBallsOnBigBall;
    }

    public void setNumberOfLittleBallsOnBigBall(int numberOfLittleBallsOnBigBall) {
        this.numberOfLittleBallsOnBigBall = numberOfLittleBallsOnBigBall;
    }
}
