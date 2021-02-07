package lesson_5.midterm;

import java.util.Calendar;
import java.util.Date;
import java.util.spi.CalendarDataProvider;

public class Test {
    public static void main(String[] args) {
        Сustomer customer1 = new Сustomer("Dias");
        Сustomer customer2 = new Сustomer("Amir");
        Сustomer customer3 = new Сustomer("Daniar");

        customer1.setMember(true);
        customer2.setMember(true);
        customer3.setMember(true);

        customer1.setMemberType("Premium");
        customer2.setMemberType("Gold");
        customer3.setMemberType("Silver");

        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(customer3);

        Visit visit1 = new Visit(customer1, Calendar.getInstance());
        Visit visit2 = new Visit(customer2, Calendar.getInstance());
        Visit visit3 = new Visit(customer3, Calendar.getInstance());

        visit1.setProductExpense(1000.0);
        visit2.setProductExpense(1500.0);
        visit3.setProductExpense(2000.0);

        visit1.setServiceExpense(10000.0);
        visit2.setServiceExpense(15000.0);
        visit3.setServiceExpense(20000.0);

        visit1.setProductExpense(
                visit1.getProductExpense() *
                        (1 - DiscountRate.getProductDiscountRate(
                                visit1.getCustomer().getMemberType()))
        );

        visit2.setProductExpense(
                visit2.getProductExpense() *
                        (1 - DiscountRate.getProductDiscountRate(
                                visit2.getCustomer().getMemberType()))
        );

        visit3.setProductExpense(
                visit3.getProductExpense() *
                        (1 - DiscountRate.getProductDiscountRate(
                                visit3.getCustomer().getMemberType()))
        );

        visit1.setServiceExpense(
                visit1.getServiceExpense() *
                        (1 - DiscountRate.getServiceDiscountRate(
                                visit1.getCustomer().getMemberType()))
        );

        visit2.setServiceExpense(
                visit2.getServiceExpense() *
                        (1 - DiscountRate.getServiceDiscountRate(
                                visit2.getCustomer().getMemberType()))
        );

        visit3.setServiceExpense(
                visit3.getServiceExpense() *
                        (1 - DiscountRate.getServiceDiscountRate(
                                visit3.getCustomer().getMemberType()))
        );

        System.out.println(visit1);
        System.out.println(visit2);
        System.out.println(visit3);

        System.out.println("Dias's bill = " + visit1.getTotalExpense());
        System.out.println("Amir's bill = " + visit2.getTotalExpense());
        System.out.println("Daniars's bill = " + visit3.getTotalExpense());
        
    }
}
