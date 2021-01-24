package lesson_3.hw.task_4;

public class TestMovablePoint {
    public static void main(String[] args) {
        MovablePoint pointA = new MovablePoint(1.0f, 3.0f, 1.5f, -5.0f);
        System.out.println(pointA);

        pointA = pointA.move();
        pointA = pointA.move();

        System.out.println(pointA);
    }
}
