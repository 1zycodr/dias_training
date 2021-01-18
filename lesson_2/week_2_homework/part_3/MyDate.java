package lesson_2.week_2_homework.part_3;

import java.util.Scanner;

public class MyDate {
    private int year;
    private int day;
    private int month;

    public MyDate(int year, int month, int day) {
        this.setDate(day, month, year);
    }

    public void setDate(int day, int month, int year) {
        if (isValidDate(year, month, day)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid year, month, or day!");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 1 && year <= 9999) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid year!");
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (isLeapYear(this.year)) {
            if (month == 2) {
                if (day <= 29) {
                    this.day = day;
                }
            } else if (day <= DAYS_IN_MONTHS[month - 1]) {
                this.day = day;
            } else {
                throw new IllegalArgumentException("Invalid day!");
            }
        } else if (day <= DAYS_IN_MONTHS[month - 1]) {
            this.day = day;
        } else {
            throw new IllegalArgumentException("Invalid day!");
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            throw new IllegalArgumentException("Invalid month!");
        }
    }

    public static final String[] MONTHS = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    public static final String[] DAYS = {
            "Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"
    };

    public static final int[] DAYS_IN_MONTHS = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public static boolean isLeapYear (int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static boolean isValidDate (int year, int month, int day) {
        if (year > 9999 || year < 1) {
            return false;
        }

        if (month > 12 || month < 1) {
            return false;
        }

        if (day > 31 || day < 1) {
            return false;
        }
        //  1   2   3   4   5   6   7   8   9  10  11  12
        // 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        if (month % 2 == 0 && month < 8 || month % 2 == 1 && month > 8) {
            if (month == 2) {
                if (isLeapYear(year)) {
                    if (day > 29) {
                        return false;
                    }
                } else if (day > 28) {
                    return false;
                }
            } else if (day > 30) {
                return false;
            }
        }

        return true;
    }

    public static int getDayOfWeek(int year, int month, int day) {
        int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };

        if (month < 3) {
            year--;
        }
        return (year + year / 4 - year / 100 + year / 400 + t[month - 1] + day) % 7;
    }

    @Override
    public String toString() {
        // "xxxday d mmm yyyy",
        return DAYS[getDayOfWeek(year, month, day)] + " " + day + " " + MONTHS[month - 1] + " " + year;
    }

    public MyDate nextDay() {
        day++;

        if (isLeapYear(year)) {
            if (month == 2) {
                if (day > 29) {
                    day = 1;
                    month++;
                }
            } else if (day > DAYS_IN_MONTHS[month - 1]) {
                day = 1;
                month++;
            }
        } else if (day > DAYS_IN_MONTHS[month - 1]) {
            day = 1;
            month++;
        }

        if (month > 12) {
            month = 1;
            year++;
        }

        return new MyDate(year, month, day);
    }

    public MyDate nextMonth() {
        month++;

        if (day == DAYS_IN_MONTHS[month - 2]) {
            day = DAYS_IN_MONTHS[month - 1];
        }

        return new MyDate(year, month, day);
    }

    public MyDate nextYear() {
        year++;

        if (isLeapYear(year - 1) && month == 2 && day == 29) {
            day--;
        }

        return new MyDate(year, month, day);
    }

    public MyDate previousDay() {
        day--;

        if (day < 1) {
            month--;
            if(month < 1) {
                month = 12;
                year--;
            }

            day = DAYS_IN_MONTHS[month - 1];

            if (month == 2 && isLeapYear(year)) {
                day = 29;
            }
        }

        return new MyDate(year, month, day);
    }

    public MyDate previousMonth() {
        month--;

        if(day == DAYS_IN_MONTHS[month]) {
            if (month < 1) {
                month = 12;
                year--;
            }

            day = DAYS_IN_MONTHS[month - 1];

            if (isLeapYear(year) && month == 2) {
                day = 29;
            }
        } else if (month < 1) {
            month = 12;
            year--;
        }

        return new MyDate(year, month, day);
    }

    public MyDate previousYear() {
        year--;

        if (isLeapYear(year + 1) && month == 2 && day == 29) {
            day = 28;
        }

        return new MyDate(year, month, day);
    }

    public static void main(String[] args) {
        MyDate d1 = new MyDate(2012, 2, 28);
        System.out.println(d1);             // Tuesday 28 Feb 2012
        System.out.println(d1.nextDay());   // Wednesday 29 Feb 2012
        System.out.println(d1.nextDay());   // Thursday 1 Mar 2012
        System.out.println(d1.nextMonth()); // Sunday 1 Apr 2012
        System.out.println(d1.nextYear());  // Monday 1 Apr 2013

        MyDate d2 = new MyDate(2012, 1, 2);
        System.out.println(d2);                 // Monday 2 Jan 2012
        System.out.println(d2.previousDay());   // Sunday 1 Jan 2012
        System.out.println(d2.previousDay());   // Saturday 31 Dec 2011
        System.out.println(d2.previousMonth()); // Wednesday 30 Nov 2011
        System.out.println(d2.previousYear());  // Tuesday 30 Nov 2010

        MyDate d3 = new MyDate(2012, 2, 29);
        System.out.println(d3.previousYear());  // Monday 28 Feb 2011
    }
}
