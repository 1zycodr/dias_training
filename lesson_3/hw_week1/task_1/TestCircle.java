package lesson_3.hw_week1.task_1;

public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(2.0);
        Circle c3 = new Circle(3.0, "blue");
        Circle c4 = new Circle();
        c4.setRadius(5.5);
        c4.setColor("green");
        Circle c5 = new Circle(5.5);
        Circle c6 = new Circle(6.6);

        System.out.println("The circle has radius of " + c1.getRadius() + " and area of " + c1.getArea());
        System.out.println("The circle has radius of " + c2.getRadius() + " and area of " + c2.getArea());
        System.out.println("The circle has radius of " + c3.getRadius() + " color of " + c3.getColor() + " and area of " + c3.getArea());
        System.out.println("radius is " + c4.getRadius() + " and color is " + c4.getColor());
        System.out.println(c5.toString());
        System.out.println(c6.toString());
        System.out.println(c6);
        System.out.println("Operator '+' invokes toString() too: " + c6);

    }
}
