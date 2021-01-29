package lesson_4.lesson.inheritance;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("A", "B", 2);
        Human human2 = new Human("A", "B", 2);

        System.out.println(human1.equals(human2));

    }
}
