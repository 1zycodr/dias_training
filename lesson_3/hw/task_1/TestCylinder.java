package lesson_3.hw.task_1;

public class TestCylinder {
    public static void main(String[] args) {
        // create instance with default values
        Cylinder cylinder1 = new Cylinder();

        System.out.println("Cylinder 1: "
                + cylinder1
                + "\n\tbase area = " + cylinder1.getArea()
                + "\n\tvolume = " + cylinder1.getVolume()
                + "\n"
        );

        // create instance with height only
        Cylinder cylinder2 = new Cylinder(2.5);

        System.out.println("Cylinder 2: "
                + cylinder2
                + "\n\tbase area = " + cylinder2.getArea()
                + "\n\tvolume = " + cylinder2.getVolume()
                + "\n"
        );

        // create instance with radius and height
        Cylinder cylinder3 = new Cylinder(2.5, 5.5);

        System.out.println("Cylinder 3: "
                + cylinder3
                + "\n\tbase area = " + cylinder3.getArea()
                + "\n\tvolume = " + cylinder3.getVolume()
                + "\n"
        );

        // create instance with all arguments
        Cylinder cylinder4 = new Cylinder(5, "green", 10);

        System.out.println("Cylinder 4:\n\t"
                + cylinder4
                + "\n\tbase area = " + cylinder4.getArea()
                + "\n\tvolume = " + cylinder4.getVolume()
                + "\n"
        );
    }
}
