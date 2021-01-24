package lesson_3.hw.task_3;

public class TestPoint2D {
    public static void main(String[] args) {
        // create instance with default values
        Point2D pointA = new Point2D();
        System.out.println(pointA);

        // change x and y
        pointA.setXY(-10.0f, 16.6f);
        System.out.println(pointA);

        // create instance with x and y
        Point2D pointB = new Point2D(15.0f, -3.5f);
        System.out.println(pointB);
    }
}
