package lesson_3.oop;

public class Human {
    private String name = "DefaultName";
    private String surname = "DefaultSurname";
    private Education education;

    Human() {}

    public Human(String name, String surname, Education education) {
        this.name = name;
        this.surname = surname;
        this.education = education;
    }

    public void sayHi() {
        System.out.println("Hi from " + name + " " + surname + "!");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", education=" + education +
                '}';
    }
}
