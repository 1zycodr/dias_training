package lesson_3.oop;

public class Main {
    public static void main(String[] args) {
        // class - это абстракция
        // Integer
//        Integer a = 5;
        // a - экземпляр класса

        // название_класса имя_экземпляра = new название_класса();
//

        Education davlatEducation = new Education("11", 11, "AITU", "bachelor");
        Human davlat = new Human("Davlat", "Ushurbakiev", davlatEducation);

        System.out.println(davlat);



//        BankAccount account = new BankAccount();
////
////        account.cents = 100;
////
////        account.cents += 1000;

//        BankAccount account = new BankAccount(1000);
//
//        account.deposit(100);
//        account.deposit(1, 50);
    }
}
