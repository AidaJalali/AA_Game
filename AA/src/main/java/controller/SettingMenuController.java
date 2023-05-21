package controller;

import model.User;

public class SettingMenuController {
    private static int numberOfLittleBallsForPlayer = 10;
    private static int numberOfLittleBallsOnBigBall = 5;
    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public static int getNumberOfLittleBallsForPlayer() {
        return numberOfLittleBallsForPlayer;
    }

    public static void setNumberOfLittleBallsForPlayer(int numberOfLittleBallsForPlayer) {
        SettingMenuController.numberOfLittleBallsForPlayer = numberOfLittleBallsForPlayer;
    }

    public static int getNumberOfLittleBallsOnBigBall() {
        return numberOfLittleBallsOnBigBall;
    }

    public static void setNumberOfLittleBallsOnBigBall(int numberOfLittleBallsOnBigBall) {
        SettingMenuController.numberOfLittleBallsOnBigBall = numberOfLittleBallsOnBigBall;
    }
}
