package lesson_3.hw_week1.task_2;

public class Tester {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(2.2);
        Circle c3 = new Circle();
        c3.setRadius(3.0);

        System.out.println("The Circle has radius of " + c1.getRadius() + " and area of " + c1.getArea() + "and circumference of " + c1.getCircumference());
        System.out.println(c2);
        System.out.println(c3);
    }
}
