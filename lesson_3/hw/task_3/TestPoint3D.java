package lesson_3.hw.task_3;

public class TestPoint3D {
    public static void main(String[] args) {
        // create instance with default values
        Point3D pointC = new Point3D();
        System.out.println(pointC);

        // change coordinates
        pointC.setXYZ(1.0f, .5f, -2.4f);
        System.out.println(pointC);

        // create instance with values
        Point3D pointD = new Point3D(1.4f, .8f, -21.3f);
        System.out.println(pointD);
    }
}
