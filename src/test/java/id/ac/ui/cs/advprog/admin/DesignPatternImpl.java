package id.ac.ui.cs.advprog.admin;
import org.springframework.boot.SpringApplication;
//Design pattern yang dipakai adalah 'State' Design Pattern
public class DesignPatternImpl {
    public static void main(String[] args) {
        SpringApplication.run(DesignPatternImpl.class, args);
        Customer customer = new Customer();
        System.out.println(customer.getWarningMessage());

        customer.addWarning();
        System.out.println(customer.getWarningMessage());

        customer.addWarning();
        System.out.println(customer.getWarningMessage());

        customer.addWarning();
        System.out.println(customer.getWarningMessage());
    }
}
