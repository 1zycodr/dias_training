package lesson_2.week_2_homework.part_2;

import java.util.Scanner;

public class MyTime {
    private int second;
    private int minute;
    private int hour;

    public MyTime() {}

    public MyTime(int hour, int minute, int second) {
        if (!isValidSecond(second) || !isValidMinute(minute) || !isValidHour(hour)) {
            System.out.println("Invalid input!");
        } else {
            this.second = second;
            this.minute = minute;
            this.hour = hour;
        }
    }

    public boolean isValidSecond(int second) {
        return second >= 0 && second <= 59;
    }

    public boolean isValidMinute(int minute) {
        return minute >= 0 && minute <= 59;
    }

    public boolean isValidHour(int hour) {
        return hour >= 0 && hour <= 23;
    }
    public void setTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getSecond() {
        return second;
    }

    public int getMinute() {
        return minute;
    }

    public int getHour() {
        return hour;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
    }

    public void nextSecond() {
        this.second += 1;
        if (this.second > 59) {
            this.second = 0;
            this.minute += 1;

            if (this.minute > 59) {
                this.minute = 0;
                this.hour += 1;

                if (this.hour > 23) {
                    this.hour = 0;
                }
            }
        }
    }

    public void nextMinute() {
        this.minute += 1;

        if (this.minute > 59) {
            this.minute = 0;
            this.hour += 1;

            if (this.hour > 23) {
                this.hour = 0;
            }
        }
    }

    public void nextHour() {
        this.hour += 1;

        if (this.hour > 23) {
            this.hour = 0;
        }
    }

    public void previousSecond() {
        this.second -= 1;

        if (this.second < 0) {
            this.second = 59;
            this.minute -= 1;

            if (this.minute < 0) {
                this.minute = 59;
                this.hour -= 1;

                if (this.hour < 0) {
                    this.hour = 23;
                }
            }
        }
    }

    public void previousMinute() {
        this.minute -= 1;

        if (this.minute < 0) {
            this.minute = 59;
            this.hour -= 1;

            if (this.hour < 0) {
                this.hour = 23;
            }
        }
    }

    public void previousHour() {
        this.hour -= 1;
        if (this.hour < 0) {
            this.hour = 23;
        }
    }

    public static void main(String[] args) {
        TestMyTime.startTests();
    }
}

