package controller;

import model.User;

public class SettingMenuController {
    private User currentUser;
    private int numberOfLittleBallsForPlayer = 10;
    private int numberOfLittleBallsOnBigBall = 12;

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
