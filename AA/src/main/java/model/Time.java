package model;

public class Time {
    private int minute;
    private int second;

    public Time(int minute, int second) {
        this.minute = 2;
        this.second = 0;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public boolean changeTime(){
        if(second > 0) {
            second--;
            return false;
        }
        if(second == 0 && minute != 0) {
            second = 59;
            minute --;
            return false;
        }
        return true;
    }

}
