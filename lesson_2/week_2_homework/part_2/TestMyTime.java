package lesson_2.week_2_homework.part_2;

public class TestMyTime {
    public static MyTime time;

    public static void testNextSecond() {
        int errors = 0;
        System.out.println("Testing nextSecond()...");

        // 00:00:00 -> 00:00:01
        time = new MyTime(00, 00, 00);
        time.nextSecond();
        if (time.getSecond() == 1 && time.getMinute() == 0 && time.getHour() == 0) {
            System.out.println("MyTime instance 00:00:00, result: " + time + " -> correct!");
        } else {
            errors -= 1;
            System.out.println("MyTime instance 00:00:00, result: " + time + " -> error! Expected: 00:00:01");
        }

        // 23:59:59 -> 00:00:00
        time = new MyTime(23, 59, 59);
        time.nextSecond();
        if (time.getSecond() == 0 && time.getMinute() == 0 && time.getHour() == 0) {
            System.out.println("MyTime instance 23:59:59, result: " + time + " -> correct!");
        } else {
            errors -= 1;
            System.out.println("MyTime instance 23:59:59, result: " + time + " -> error! Expected: 00:00:00");
        }

        System.out.println("2 tests finished! " + errors + " from 2 tests!\n");
    }

    public static void testNextMinute() {
        int errors = 2;
        System.out.println("Testing nextMinute()...");

        // 00:00:00 -> 00:01:00
        time = new MyTime(00, 00, 00);
        time.nextMinute();
        if (time.getSecond() == 0 && time.getMinute() == 1 && time.getHour() == 0) {
            System.out.println("MyTime instance 00:00:00, result: " + time + " -> correct!");
        } else {
            errors -= 1;
            System.out.println("MyTime instance 00:00:00, result: " + time + " -> error! Expected: 00:01:00");
        }

        // 23:59:00 -> 00:00:00
        time = new MyTime(23, 59, 00);
        time.nextMinute();
        if (time.getSecond() == 0 && time.getMinute() == 0 && time.getHour() == 0) {
            System.out.println("MyTime instance 23:59:00, result: " + time + " -> correct!");
        } else {
            errors -= 1;
            System.out.println("MyTime instance 23:59:00, result: " + time + " -> error! Expected: 00:00:00");
        }

        System.out.println("2 tests finished! " + errors + " from 2 tests!\n");
    }

    public static  void testNextHour() {
        int errors = 2;
        System.out.println("Testing nextHour()...");

        // 00:00:00 -> 01:00:00
        time = new MyTime(00, 00, 00);
        time.nextHour();
        if (time.getSecond() == 0 && time.getMinute() == 0 && time.getHour() == 1) {
            System.out.println("MyTime instance 00:00:00, result: " + time + " -> correct!");
        } else {
            errors -= 1;
            System.out.println("MyTime instance 00:00:00, result: " + time + " -> error! Expected: 01:00:00");
        }

        // 23:00:00 -> 00:00:00
        time = new MyTime(23, 00, 00);
        time.nextHour();
        if (time.getSecond() == 0 && time.getMinute() == 0 && time.getHour() == 0) {
            System.out.println("MyTime instance 23:00:00, result: " + time + " -> correct!");
        } else {
            errors -= 1;
            System.out.println("MyTime instance 23:00:00, result: " + time + " -> error! Expected: 00:00:00");
        }

        System.out.println("2 tests finished! " + errors + " from 2 tests!\n");
    }

    public static void testPreviousSecond() {
        int errors = 2;
        System.out.println("Testing previousSecond()...");

        // 00:00:00 -> 23:59:59
        time = new MyTime(00, 00, 00);
        time.previousSecond();
        if (time.getSecond() == 59 && time.getMinute() == 59 && time.getHour() == 23) {
            System.out.println("MyTime instance 00:00:00, result: " + time + " -> correct!");
        } else {
            errors -= 1;
            System.out.println("MyTime instance 00:00:00, result: " + time + " -> error! Expected: 23:59:59");
        }

        // 23:00:00 -> 22:59:59
        time = new MyTime(23, 00, 00);
        time.previousSecond();
        if (time.getSecond() == 59 && time.getMinute() == 59 && time.getHour() == 22) {
            System.out.println("MyTime instance 23:00:00, result: " + time + " -> correct!");
        } else {
            errors -= 1;
            System.out.println("MyTime instance 23:00:00, result: " + time + " -> error! Expected: 22:59:59");
        }

        System.out.println("2 tests finished! " + errors + " from 2 tests!\n");
    }

    public static void testPreviousMinute() {
        int errors = 2;
        System.out.println("Testing previousMinute()...");

        // 00:00:00 -> 23:59:00
        time = new MyTime(00, 00, 00);
        time.previousMinute();
        if (time.getSecond() == 0 && time.getMinute() == 59 && time.getHour() == 23) {
            System.out.println("MyTime instance 00:00:00, result: " + time + " -> correct!");
        } else {
            errors -= 1;
            System.out.println("MyTime instance 00:00:00, result: " + time + " -> error! Expected: 23:59:00");
        }

        // 23:00:00 -> 22:59:00
        time = new MyTime(23, 00, 00);
        time.previousMinute();
        if (time.getSecond() == 00 && time.getMinute() == 59 && time.getHour() == 22) {
            System.out.println("MyTime instance 23:00:00, result: " + time + " -> correct!");
        } else {
            errors -= 1;
            System.out.println("MyTime instance 23:00:00, result: " + time + " -> error! Expected: 22:59:00");
        }

        System.out.println("2 tests finished! " + errors + " from 2 tests!\n");
    }

    public static void testPreviousHour() {
        int errors = 2;
        System.out.println("Testing previousHour()...");

        // 00:00:00 -> 23:00:00
        time = new MyTime(00, 00, 00);
        time.previousHour();
        if (time.getSecond() == 0 && time.getMinute() == 0 && time.getHour() == 23) {
            System.out.println("MyTime instance 00:00:00, result: " + time + " -> correct!");
        } else {
            errors -= 1;
            System.out.println("MyTime instance 00:00:00, result: " + time + " -> error! Expected: 23:00:00");
        }

        // 23:00:00 -> 22:00:00
        time = new MyTime(23, 00, 00);
        time.previousHour();
        if (time.getSecond() == 00 && time.getMinute() == 00 && time.getHour() == 22) {
            System.out.println("MyTime instance 23:00:00, result: " + time + " -> correct!");
        } else {
            errors -= 1;
            System.out.println("MyTime instance 23:00:00, result: " + time + " -> error! Expected: 22:00:00");
        }

        System.out.println("2 tests finished! " + errors + " from 2 tests!\n");
    }

    public static void startTests() {
        // testing next methods
        testNextSecond();
        testNextMinute();
        testNextHour();

        // testing previous methods
        testPreviousSecond();
        testPreviousMinute();
        testPreviousHour();
    }
}
