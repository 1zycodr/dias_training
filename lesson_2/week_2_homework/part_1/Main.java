package lesson_2.week_2_homework.part_1;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(
                "Alexander",
                "Gromov",
                25,
                "Male",
                "Fks@$123qwf",
                "29/02/2000"
        );

        if (
            Validator.checkDate(user1.getDateOfBirth()) &&
            Validator.checkAge(user1.getAge()) &&
            Validator.checkPassword(user1.getPassword())
        ) {
            System.out.println("User data is valid!");
        }
    }
}
