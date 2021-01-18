package lesson_2.week_2_homework.part_2;

public class MyTime {
    private int second;
    private int minute;
    private int hour;

    public MyTime() {}

    public MyTime(int second, int minute, int hour) {
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

    public static void main(String[] args) {
        MyTime time = new MyTime(12, 34, 2);
        MyTime time1 = new MyTime(333, 34, 2);

        System.out.println(time);
    }
}

