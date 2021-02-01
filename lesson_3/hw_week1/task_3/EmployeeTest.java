package lesson_3.hw_week1.task_3;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Employee(1,"Dias", "Yerzhanuly", 999999);
        Employee e2 = new Employee(2, "Amir", "Rustem", 666666);
        e2.setSalary(777777);


        System.out.println("Id = " + e1.getId() + ", First name = " + e1.getFirstName() + ", Last name = " + e1.getLastName() + ", Salary = " + e1.getSalary());
        System.out.println("Id = " + e2.getId() + ", Name = " + e2.getName() + ", Salary = " + e2.getSalary());
        System.out.println("Dias has per year = " + e1.gatAnnualSalary());
        System.out.println("If Amir's salary is increased by 50%, then he will receive = " + e2.raiseSalary(50));
        System.out.println(e1 +"\n" + e2);
    }
}
