package lesson_5.midterm;

import java.util.Date;

public class Visit {
    private Сustomer customer;
    private Date date;
    private double serviceExpense;
    private double productExpense;

    public Visit(Сustomer customer,Date date) {
        this.customer = customer;
        this.date = date;
    }

    public String getName() {
        return customer.getName();
    }

    public Сustomer getCustomer() {
        return customer;
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public double getTotalExpense() {
        return serviceExpense + productExpense;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "customer=" + customer +
                ", date=" + date +
                ", serviceExpense=" + serviceExpense +
                ", productExpense=" + productExpense +
                '}';
    }
}
