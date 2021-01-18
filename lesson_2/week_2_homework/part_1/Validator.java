package lesson_2.week_2_homework.part_1;

public class Validator {
    public static boolean checkAge(int age) {
        return age >= 18;
    }

    public static boolean checkPassword(String password) {
        boolean hasUppercase = false,
                hasLowercase = false,
                hasDigit = false,
                hasSpecialSymbol = false;

        for (char i: password.toCharArray()) {
            if(Character.isUpperCase(i)) {
                hasUppercase = true;
            }
            if(Character.isLowerCase(i)) {
                hasLowercase = true;
            }
            if(Character.isDigit(i)) {
                hasDigit = true;
            }
            if(i == '@' || i == '$' || i == '!' || i == '^') {
                hasSpecialSymbol = true;
            }
        }

        return hasUppercase && hasLowercase && hasDigit && hasSpecialSymbol && password.length() >= 8;
    }

    public static boolean checkDate(String date) {
        char[] dateChars = date.toCharArray();
        int day = 0, month = 0, year = 0;

        if (date.length() != 10 || dateChars[2] != '/' || dateChars[5] != '/') {
            return false;
        }

        for (int i = 0; i < date.length(); i++) {
            if (i != 2 && i != 5 && !Character.isDigit(dateChars[i])) {
                return false;
            }
        }

        day += 10 * (dateChars[0] - 48) + dateChars[1] - 48;
        month += 10 * (dateChars[3] - 48) + dateChars[4] - 48;
        year += 1000 * (dateChars[6] - 48) + 100 * (dateChars[7] - 48) + 10 * (dateChars[8] - 48) + dateChars[9] - 48;

        return isValidDate(year, month, day);
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

        if (month % 2 == 0) {
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

    public static boolean isLeapYear (int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
