package lesson_5.exceptions;

public class Exceptions {
    public static void main(String[] args) {
        try {
            int a = 1 / 1;
        } catch (ArithmeticException ex) {
            System.out.println("Exception!");
            System.out.println(ex);
        } finally {
            System.out.println("Finally!");
        }

        try {
            doSomething();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static void doSomething() throws Exception {
        throw new Exception("Error!");
    }
}
