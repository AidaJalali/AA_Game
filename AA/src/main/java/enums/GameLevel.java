package enums;

public enum GameLevel {
    EASY(0.5 , 7 ),
    MEDIUM(1 ,5),
    HARD(2, 3);

    private final double speed;
    private final int freezeTime;

    GameLevel(double speed , int freezeTime) {
        this.speed = speed;
        this.freezeTime = freezeTime;
    }

    public double getSpeed() {
        return speed;
    }

    public int getFreezeTime() {
        return freezeTime;
    }
}
