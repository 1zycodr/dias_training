package lesson_2.week_2_homework.part_1;

import java.util.Scanner;

public class User {
    private String firstName;
    private String secondName;
    private static int idCounter = 0;
    private int id;
    private int age;
    private String gender;
    private String password;
    private String dateOfBirth;

    public User(String firstName, String secondName, int age, String gender, String password, String dateOfBirth) {
        this.id = idCounter++;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.gender = gender;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String currentDate;

        for(;;) {
            currentDate = cin.next();

            if(Validator.checkDate(currentDate)) {
                System.out.println("Valid!");
            } else {
                System.out.println("Invalid");
            }
        }
    }
}
