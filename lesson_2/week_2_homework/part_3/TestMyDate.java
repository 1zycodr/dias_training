package lesson_2.week_2_homework.part_3;

public class TestMyDate {
    public static void main(String[] args) {
        MyDate date = new MyDate(2011, 12, 27);

        while (date.getDay() != 2 || date.getMonth() != 3 || date.getYear() != 2012) {
            date = date.nextDay();
            System.out.println(date);
        }
    }
}
